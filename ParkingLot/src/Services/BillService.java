package Services;

import java.util.ArrayList;
import java.util.Date;

import Exceptions.TicketNumberIncorrectException;
import Models.Bill;
import Models.Payment;
import Models.PaymentMode;
import Models.TicketStatus;

public class BillService {
	private ParkingLotService parkingLotService;
	
	
	public BillService(ParkingLotService parkingLotService) {
		super();
		this.parkingLotService = parkingLotService;
	}

	public ParkingLotService getParkingLotService() {
		return parkingLotService;
	}

	public void setParkingLotService(ParkingLotService parkingLotService) {
		this.parkingLotService = parkingLotService;
	}



	public double calcAmount(int ticketNumber, int numberOfHours) throws TicketNumberIncorrectException  {
		double amount = parkingLotService.calcAmount(ticketNumber, numberOfHours);
		return amount;
	}

	public Bill generateBill(int ticketNumber,int numberOfHours, int exitGateId, double paymentAmount, PaymentMode paymentMode,
			String transactionId) throws TicketNumberIncorrectException {
		double amount = this.calcAmount(ticketNumber, numberOfHours);
		Bill bill = new Bill();
		bill.setTicket(parkingLotService.getParkingLotRepository().getTicket(ticketNumber));
		bill.setExitGate(parkingLotService.getGate(exitGateId));
		bill.setExitGateTime(new Date());
		bill.setOperator(parkingLotService.getGate(exitGateId).getCurrentOperator());
		if (bill.getPayments() == null)
			bill.setPayments(new ArrayList<>());
		bill.getPayments().add(new Payment(paymentMode,transactionId, paymentAmount));
		bill.setTotalAmount(amount);
		double paidAmount = 0.0;
		for (Payment payment: bill.getPayments())
		{
			paidAmount += payment.getAmount();
		}
		if (paidAmount < amount )
			parkingLotService.getParkingLotRepository().getTicket(ticketNumber).setTicketStatus(TicketStatus.PARTIALLYPAID);
		else
			parkingLotService.getParkingLotRepository().getTicket(ticketNumber).setTicketStatus(TicketStatus.PAID);
		parkingLotService.saveBill(bill);
		return bill;
	}

}

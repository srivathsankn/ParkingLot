package Controllers;

import Models.Bill;
import Models.PaymentMode;
import Services.BillService;
import Services.ParkingLotService;

public class BillController {
	private BillService billService;
	
	public BillController(BillService billService) {
		super();
		this.billService = billService;
	}

	public BillService getBillService() {
		return billService;
	}

	public void setBillService(BillService billService) {
		this.billService = billService;
	}

	public double calculateAmount(int ticketNumber, int numberOfHours)
	{
		try
		{
			double amount = billService.calcAmount(ticketNumber, numberOfHours);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage() + " So, Amount cannot be calculated");
		}
		return 0.0;
		
	}
	
	public Bill generateBill(int ticketNumber, int numberOfHours, int exitGateId, double payment, PaymentMode paymentMode, String transactionId )
	{
		try
		{
			Bill bill = billService.generateBill(ticketNumber, numberOfHours, exitGateId, payment, paymentMode, transactionId);
			return bill;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage() + " So, Bill cannot be generated.");
		}
		return null;
	}

}

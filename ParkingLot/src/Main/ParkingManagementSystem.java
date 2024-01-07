package Main;

import Controllers.BillController;
import Controllers.TicketController;
import Models.Bill;
import Models.GateType;
import Models.ParkingLot;
import Models.PaymentMode;
import Models.Ticket;
import Models.VehicleType;
import Repositories.ParkingLotRepository;
import Repositories.VehicleRepository;
import Services.BillService;
import Services.ParkingLotService;
import Services.TicketService;
import Services.VehicleService;
import Strategies.SpotAllocationStrategy;
import Strategies.fixedBillingStrategy;
import Strategies.NearestSpotAllocationStrategy;

public class ParkingManagementSystem {

	public static void main(String[] args) {
		ParkingLot parkingLot = ParkingLot.getBuilder()
								.withName("A1 Parking Services")
								.withAddress("OMR Chennai")
								.addFloor(5)
								.addGate(GateType.ENTRY, 0, 4)
								.addGate(GateType.EXIT, 0, 2)
								.addOperators("Rajan", "Kumar", "Senthil", "Vicky")
								.assignOperatorToGate(0, 0)
								.assignOperatorToGate(1, 1)
								.assignOperatorToGate(2, 2)
								.assignOperatorToGate(3, 3)
								.addSpot(0, 0, VehicleType.CAR)
								.addSpot(0, 1, VehicleType.CAR)
								.addSpot(0, 2, VehicleType.CAR)
								.addSpot(0, 3, VehicleType.TWOWHEELER)
								.addSpot(0, 4, VehicleType.EV)
								.addSpot(1, 0, VehicleType.CAR)
								.addSpot(1, 1, VehicleType.CAR)
								.addSpot(1, 2, VehicleType.CAR)
								.addSpot(1, 3, VehicleType.TWOWHEELER)
								.addSpot(1, 4, VehicleType.EV)
								.addSpot(2, 0, VehicleType.CAR)
								.addSpot(2, 1, VehicleType.EV)
								.addSpot(3, 0, VehicleType.CAR)
								.addSpot(3, 1, VehicleType.EV)
								.addSpot(4, 0, VehicleType.CAR)
								.addSpot(5, 0, VehicleType.CAR)
								.build();
		
		
		
		VehicleRepository vehicleRepository = new VehicleRepository();
		VehicleService vehicleService = new VehicleService(vehicleRepository);
		ParkingLotRepository parkingLotRepository = new ParkingLotRepository(parkingLot);
		SpotAllocationStrategy spotAllocationStrategy = new NearestSpotAllocationStrategy();
		ParkingLotService parkingLotService = new ParkingLotService (spotAllocationStrategy, parkingLotRepository, new fixedBillingStrategy());
		TicketService ticketService = new TicketService(vehicleService, parkingLotService);
		TicketController ticketController  = new TicketController(ticketService);
		BillService billService = new BillService(parkingLotService);
		BillController billController = new BillController(billService);
		
		
		Ticket ticket = ticketController.generateTicket(0, "TN64W4136", VehicleType.CAR);
		Ticket ticket1 = ticketController.generateTicket(0, "TN64W4137", VehicleType.CAR);
		Ticket ticket2 = ticketController.generateTicket(0, "TN64W4138", VehicleType.CAR);
		Ticket ticket3 = ticketController.generateTicket(0, "TN64W4139", VehicleType.CAR);
		Ticket ticket4 = ticketController.generateTicket(0, "TN64W4140", VehicleType.CAR);
		Ticket ticket5 = ticketController.generateTicket(0, "TN64W4141", VehicleType.CAR);
		
		Bill bill = billController.generateBill(1, 3, 3, 90, PaymentMode.CARD, "VISA000123456");
		Bill bill1 = billController.generateBill(2, 3, 3, 50, PaymentMode.CARD, "VISA000123457");
		
		//System.out.println(ticket);
		System.out.println(parkingLot);
	}

}

package Services;

import java.util.Date;

import Exceptions.NoSpotAvailableException;
import Exceptions.SpotAllocationStrategyNotDefinedException;
import Models.Gate;
import Models.Spot;
import Models.SpotStatus;
import Models.Ticket;
import Models.TicketStatus;
import Models.Vehicle;
import Models.VehicleType;
import Strategies.SpotAllocationStrategy;

public class TicketService {
	VehicleService vehicleService;	
	ParkingLotService parkingLotService;
	
	
	public TicketService(VehicleService vehicleService, ParkingLotService parkingLotService) {
		super();
		this.vehicleService = vehicleService;
		this.parkingLotService = parkingLotService;
	}


	public Ticket getTicket(int entryGateId, String vehicleNumber, VehicleType vehicleType) throws SpotAllocationStrategyNotDefinedException, NoSpotAvailableException {
		
		//check if Vehicle is already there on the database and if present, proceed
		//If not found, Add vehicle.
		Ticket ticket = new Ticket();
		
		Vehicle vehicle = vehicleService.findVehicle(vehicleNumber);
		if (vehicle == null)
		{
			vehicle = new Vehicle(vehicleNumber, vehicleType);
			vehicleService.addVehicle(vehicle);
		}
		
		//get Gate details
		
		Gate entryGate = parkingLotService.getGate(entryGateId);
		Integer floorNumber = entryGate.getFloorNumber();
		
		//spot Allocation 
		
		Spot parkingSpot = parkingLotService.allocateSpot(vehicleType, floorNumber );
		
		
		//set the fields like Date, Time, Vehicle object, operator object on the ticket
		ticket.setEntryGateId(entryGate);
		ticket.setEntryGateTime(new Date());
		ticket.setOperator(entryGate.getCurrentOperator());
		ticket.setSpot(parkingSpot);
		ticket.setTicketNo(Ticket.getNextTicketNo());
		Ticket.setNextTicketNo(Ticket.getNextTicketNo()+1);
		ticket.setTicketStatus(TicketStatus.ISSUED);
		ticket.setVehicle(vehicle);
		
		parkingLotService.saveTicket(ticket);
		return ticket;
	}
	
	public void printTicket(Ticket ticket)
	{
		System.out.println(ticket);
	}
	
	
}

package Controllers;

import Exceptions.SpotAllocationStrategyNotDefinedException;
import Models.Gate;
import Models.Spot;
import Models.Ticket;
import Models.Vehicle;
import Models.VehicleType;
import Services.TicketService;
import Services.VehicleService;

public class TicketController {

	TicketService ticketService;
		
	
	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	
	public Ticket generateTicket(int entryGateId, String vehicleNumber, VehicleType vehicleType)
	{
		try
		{
			Ticket ticket = ticketService.getTicket(entryGateId, vehicleNumber, vehicleType);
			return ticket;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage() + " So, Ticket cannot be generated!!!");
			e.printStackTrace();
		}
		return null;
	}

}

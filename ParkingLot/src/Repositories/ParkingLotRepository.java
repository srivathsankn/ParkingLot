package Repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Models.Bill;
import Models.Floor;
import Models.FloorStatus;
import Models.Gate;
import Models.ParkingLot;
import Models.Spot;
import Models.SpotStatus;
import Models.Ticket;
import Models.VehicleType;

public class ParkingLotRepository {
	private ParkingLot parkingLot;
	
	
	public ParkingLotRepository(ParkingLot parkingLot)
	{
		this.parkingLot = parkingLot;
	}
	
	
	
	public ParkingLot getParkingLot() {
		return parkingLot;
	}



	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}



	public List<Spot> getAllSpots() {
		
		List<Spot> parkingSpots = new ArrayList<Spot>();
		
		for (Floor floor : parkingLot.getFloors())
		{
			parkingSpots.addAll(floor.getSpots());
		}
		
		return parkingSpots;
	}
	
	public Map<Integer, List<Spot>> getAllAvailableSpotsFloorWise() {
		
		Map<Integer,List<Spot>> parkingSpotsFloorWise = new HashMap();
		
		for (Floor floor : parkingLot.getFloors())
		{	
			if (floor.getStatus() == FloorStatus.OPEN)
			{
				if (!parkingSpotsFloorWise.containsKey(floor.getFloorNumber()) )
					parkingSpotsFloorWise.put(floor.getFloorNumber(), new ArrayList<Spot>());
				
				for (Spot spot : floor.getSpots())
				{	
					if (spot.getStatus()==SpotStatus.VACANT)
						parkingSpotsFloorWise.get(floor.getFloorNumber()).add(spot);
				}
			}
		}
		
		return parkingSpotsFloorWise;
	}

	public void saveTicket(Ticket ticket) {
		this.parkingLot.addTicket(ticket);
	}

	public Gate getGate(int entryGateId) {
		return this.parkingLot.getGates().get(entryGateId);
	}

	public VehicleType getVehicleType(int ticketNumber) {
		Ticket ticket = this.getTicket(ticketNumber);
		if (ticket != null)
			return ticket.getVehicle().getVehicleType();
		return null;
	}



	public Ticket getTicket(int ticketNumber) {
		
		for(Ticket ticket : this.getParkingLot().getTickets())
		{
			if (ticket.getTicketNo() == ticketNumber)
			{
				return ticket;
			}
		}
		return null;
	}



	public void saveBill(Bill bill) {
		this.parkingLot.addBill(bill);
	}
}

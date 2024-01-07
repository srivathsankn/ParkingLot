package Models;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	private List<Floor> floors;
	private List<Gate> gates;
	private List<Ticket> tickets;
	private List<Operator> operators;
	private List<Bill> bills;
	private String name;
	private String address;
	private ParkingLotStatus status;
	
	private ParkingLot(ParkingLotBuilder parkingLotBuilder)
	{
		this.floors = parkingLotBuilder.floors;
		this.gates = parkingLotBuilder.gates;
		this.tickets = parkingLotBuilder.tickets;
		this.operators = parkingLotBuilder.operators;
		this.bills = parkingLotBuilder.bills;
		this.name = parkingLotBuilder.name;
		this.address = parkingLotBuilder.address;
	}
	
	public List<Floor> getFloors() {
		return floors;
	}
	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}
	public List<Gate> getGates() {
		return gates;
	}
	public void setGates(List<Gate> gates) {
		this.gates = gates;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	public List<Operator> getOperators() {
		return operators;
	}
	public void setOperators(List<Operator> operators) {
		this.operators = operators;
	}
	public List<Bill> getBills() {
		return bills;
	}
	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ParkingLotStatus getStatus() {
		return status;
	}
	public void setStatus(ParkingLotStatus status) {
		this.status = status;
	}

	public void addTicket(Ticket ticket)
	{
		this.tickets.add(ticket);
	}
	
	public void addBill(Bill bill)
	{
		this.bills.add(bill);
	}
	
	public static ParkingLotBuilder getBuilder()
	{
		return new ParkingLotBuilder();
	}
	
	public String toString()
	{
		
		return "Name     : " + this.name + "\n" +
			   "Address  : " + this.address + "\n" +
			   "Floors   : " + this.floors + "\n" +
		       "Gates    : " + this.gates + "\n" +
			   "Operators: " + this.operators + "\n" +
			   "Tickets  : " + this.tickets + "\n" +
			   "Bills    : " + this.bills ;
		
	}
	
	public static class ParkingLotBuilder
	{
		private List<Floor> floors;
		private List<Gate> gates;
		private List<Ticket> tickets;
		private List<Operator> operators;
		private List<Bill> bills;
		private String name;
		private String address;
		private ParkingLotStatus status;
		
		public ParkingLotBuilder()
		{
			floors = new ArrayList<Floor>();
			gates = new ArrayList<Gate>();
			tickets = new ArrayList<Ticket>();
			operators = new ArrayList<Operator>();
			bills = new ArrayList<Bill>();
			this.status = ParkingLotStatus.OPEN;
		}
		
		public ParkingLotBuilder addFloor(int numberOfFloors)
		{
			for (int i=0; i<=numberOfFloors ; i++)
			{
				this.floors.add(new Floor(i,FloorStatus.OPEN,new ArrayList<Spot>()));
			}
			return this;
		}
		
		public ParkingLotBuilder addSpot(int floorNumber, long spotId, VehicleType spotType)
		{
			this.floors.get(floorNumber).getSpots().add(new Spot((floorNumber*100) + spotId, floorNumber, spotType, SpotStatus.VACANT));
			return this;
		}
		
		public ParkingLotBuilder addGate(GateType gateType, int... floorNumbers)
		{
			int gateCount = this.gates.size();
			for (int i=0; i<floorNumbers.length; i++)
			{
				this.gates.add(new Gate(gateType,gateCount+i, null, floorNumbers[i],GateStatus.OPEN));
			}
			return this;
		}
		
		public ParkingLotBuilder addOperators(String... operatorNames  )
		{
			for(int i=1; i<=operatorNames.length; i++)
			{
				operators.add(new Operator(1000 + i, operatorNames[i-1]));
			}
			return this;
		}
		
		public ParkingLotBuilder assignOperatorToGate(int gateId, int operatorId)
		{
			this.gates.get(gateId).setCurrentOperator(this.operators.get(operatorId));
			return this;
		}
		
		public ParkingLotBuilder withName(String name)
		{
			this.name = name;
			return this;
		}
		
		public ParkingLotBuilder withAddress(String address)
		{
			this.address = address;
			return this;
		}
		
		public ParkingLot build()
		{
			ParkingLot parkingLot = new ParkingLot(this);
			return parkingLot;
		}
	}
	
}

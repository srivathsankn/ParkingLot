package Models;

import java.util.Date;

public class Ticket {
	private static Long nextTicketNo = 1l;
	
	private Long TicketNo;
	private Gate entryGateId;
	private Date entryGateTime;
	private Operator operator;
	private Vehicle vehicle;
	private TicketStatus ticketStatus;
	private Spot spot;
	
	public Spot getSpot() {
		return spot;
	}
	public void setSpot(Spot spot) {
		this.spot = spot;
	}
	public static Long getNextTicketNo() {
		return nextTicketNo;
	}
	public static void setNextTicketNo(Long nextTicketNo) {
		Ticket.nextTicketNo = nextTicketNo;
	}
	public Long getTicketNo() {
		return TicketNo;
	}
	public void setTicketNo(Long ticketNo) {
		TicketNo = ticketNo;
	}
	public Gate getEntryGateId() {
		return entryGateId;
	}
	public void setEntryGateId(Gate entryGateId) {
		this.entryGateId = entryGateId;
	}
	public Date getEntryGateTime() {
		return entryGateTime;
	}
	public void setEntryGateTime(Date entryGateTime) {
		this.entryGateTime = entryGateTime;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	
	public String toString()
	{
		return "Ticket No : " + this.getTicketNo() + "\n"+
	           "Entry Gate : " + this.getEntryGateId() + " Entered Date/Time : "+  this.getEntryGateTime() + "\n" +
	           "Issued by " + this.getOperator().getName() + " ( " + this.getOperator().getOperatorId() + " )\n" +
	           "Allocated Spot : " + this.getSpot() + "\n" +  
	           "Vehicle : " + this.getVehicle()  + "\nStatus : "+ this.getTicketStatus();
	           
		
	}
	
	
	
}

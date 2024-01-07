package Models;

import java.util.Date;
import java.util.List;

public class Bill {
	private Ticket ticket;
	private Gate exitGate;
	private Date exitGateTime;
	private Operator operator;
	private Double totalAmount;
	private List<Payment> payments;
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Gate getExitGate() {
		return exitGate;
	}
	public void setExitGate(Gate exitGate) {
		this.exitGate = exitGate;
	}
	public Date getExitGateTime() {
		return exitGateTime;
	}
	public void setExitGateTime(Date exitGateTime) {
		this.exitGateTime = exitGateTime;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<Payment> getPayments() {
		return payments;
	}
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	
	public String toString()
	{
		return " \nTicket # " + this.ticket.getTicketNo() + " exiting on gate # " + exitGate.getGateNumber() + " on " + exitGateTime 
				+ "\n Bill Issued by "+ operator.getName() + " Amount : " +  totalAmount + " Status :" + this.getTicket().getTicketStatus() + "\n  Payments : " + payments;
				
	}
	
}

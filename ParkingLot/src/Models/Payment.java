package Models;

public class Payment {
	private PaymentMode mode;
	private String transactionId;
	private Double amount;
	
	
	
	public Payment(PaymentMode mode, String transactionId, Double amount) {
		super();
		this.mode = mode;
		this.transactionId = transactionId;
		this.amount = amount;
	}
	public PaymentMode getMode() {
		return mode;
	}
	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String toString()
	{
		return "Paid Rs." + amount + " using " + mode + " Transaction ID: "+ transactionId; 
	}
	
}

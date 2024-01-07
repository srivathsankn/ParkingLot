package Models;

public class Gate {
	private GateType type;
	private Integer GateNumber;
	private Operator currentOperator;
	private Integer floorNumber;
	private GateStatus gateStatus;
	
	
	public Gate(GateType type, Integer gateNumber, Operator currentOperator, Integer floorNumber,GateStatus gateStatus) {
		this.type = type;
		GateNumber = gateNumber;
		this.currentOperator = currentOperator;
		this.floorNumber = floorNumber;
		this.gateStatus = gateStatus;
	}
	public GateType getType() {
		return type;
	}
	public void setType(GateType type) {
		this.type = type;
	}
	public Integer getGateNumber() {
		return GateNumber;
	}
	public void setGateNumber(Integer gateNumber) {
		GateNumber = gateNumber;
	}
	public Operator getCurrentOperator() {
		return currentOperator;
	}
	public void setCurrentOperator(Operator currentOperator) {
		this.currentOperator = currentOperator;
	}
	public Integer getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}
	
	public String toString()
	{
		return this.getType() + " : Floor # " + this.floorNumber + " GateID : "+ this.getGateNumber()+ " Operator : "+ this.getCurrentOperator() + "\n";
	}
}

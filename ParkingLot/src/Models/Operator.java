package Models;

public class Operator {
	private Integer operatorId;
	private String name;
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Operator(Integer operatorId, String name) {
		super();
		this.operatorId = operatorId;
		this.name = name;
	}
	
	public String toString()
	{
		return  this.operatorId + " : " + this.name + "\n" ;
	}
}

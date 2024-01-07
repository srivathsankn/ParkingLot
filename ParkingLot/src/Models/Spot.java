package Models;

public class Spot {
	private Long spotId;
	private int floorNumber;
	private VehicleType type;
	private SpotStatus status;
	
	
	
	public Spot(Long spotId, int floorNumber, VehicleType type, SpotStatus status) {
		super();
		this.spotId = spotId;
		this.floorNumber = floorNumber;
		this.type = type;
		this.status = status;
	}
	public Long getSpotId() {
		return spotId;
	}
	public void setSpotId(Long spotId) {
		this.spotId = spotId;
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public SpotStatus getStatus() {
		return status;
	}
	public void setStatus(SpotStatus status) {
		this.status = status;
	}
	
	public String toString()
	{
		return "SpotID " + spotId.intValue() +  " - Type :" + type + " - " + status + "\n"; 
	}
	
}

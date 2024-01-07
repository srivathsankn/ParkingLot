package Models;

import java.util.ArrayList;
import java.util.List;

public class Floor {
	private List<Spot> spots;
	private Integer floorNumber;
	private FloorStatus status;
	
	public Floor(int floorNumber, FloorStatus floorStatus, ArrayList<Spot> spots) {
		this.spots = spots;
		this.floorNumber = floorNumber;
		this.status = floorStatus; 
	}
	
	public List<Spot> getSpots() {
		return spots;
	}
	public void setSpots(List<Spot> spots) {
		this.spots = spots;
	}
	public Integer getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}
	public FloorStatus getStatus() {
		return status;
	}
	public void setStatus(FloorStatus status) {
		this.status = status;
	}
	
	public String toString()
	{
		return "Floor " + floorNumber + this.spots + status + "\n"; 
	}
	
}

package Models;

public class EVSpot extends Spot {
	private Integer startReading;
	private Integer endReading;
	private Double pricePerunit;
	
	
	public EVSpot(Long spotId, int floorNumber, VehicleType type, SpotStatus status) {
		super(spotId, floorNumber, type, status);
	}
	
	public Integer getStartReading() {
		return startReading;
	}
	public void setStartReading(Integer startReading) {
		this.startReading = startReading;
	}
	public Integer getEndReading() {
		return endReading;
	}
	public void setEndReading(Integer endReading) {
		this.endReading = endReading;
	}
	public Double getPricePerunit() {
		return pricePerunit;
	}
	public void setPricePerunit(Double pricePerunit) {
		this.pricePerunit = pricePerunit;
	}
	
	
}

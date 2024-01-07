package Strategies;

import java.util.List;
import java.util.Map;

import Models.Spot;
import Models.VehicleType;

public interface SpotAllocationStrategy {
	public Spot getSpot(VehicleType vehicleType, Integer floorNumber, Map<Integer,List<Spot>> parkingSpotsFloorWise);
}

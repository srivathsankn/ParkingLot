package Strategies;

import java.util.List;
import java.util.Map;

import Models.Spot;
import Models.SpotStatus;
import Models.VehicleType;

public class NearestSpotAllocationStrategy implements SpotAllocationStrategy {
	
	@Override
	public Spot getSpot(VehicleType vehicleType, Integer floorNumber, Map<Integer,List<Spot>> parkingSpotsFloorWise)
	{
		
		// check current floor first. IF not available then search for other floors
		for (Spot spot: parkingSpotsFloorWise.get(floorNumber.intValue()))
		{
			//spot found in the floor
			if (spot.getType()==vehicleType)
			{
				spot.setStatus(SpotStatus.OCCUPIED);
				return spot;
			}
		}
		//Check nearest spot to our floor
		int floordiff=Integer.MAX_VALUE;
		Spot selectedSpot= null;
		for(Integer floor:parkingSpotsFloorWise.keySet())
		{
			if (Math.abs(floor.intValue()-floorNumber) < floordiff )
			{
				List<Spot> spots =  parkingSpotsFloorWise.get(floor);
				for(Spot spot: spots)
				{
					if (spot.getType()==vehicleType)
					{
						selectedSpot = spot;
						floordiff = Math.abs(floor.intValue()-floorNumber);
						break;
					}
				}
				
			}
			
		}
		if (selectedSpot != null)
		{
			selectedSpot.setStatus(SpotStatus.OCCUPIED);
		}
			return selectedSpot;
	}
}

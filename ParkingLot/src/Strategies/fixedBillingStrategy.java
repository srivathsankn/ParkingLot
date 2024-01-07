package Strategies;

import Models.VehicleType;

public class fixedBillingStrategy implements BillingStrategy {

	@Override
	public Double calculateBilling(VehicleType vehicleType, int numberOfHours) {
		if (vehicleType == VehicleType.CAR)
			return (double)numberOfHours * 30.0;
		else if(vehicleType == VehicleType.TWOWHEELER)
			return (double)numberOfHours * 15.0;
		else 
			return (double)numberOfHours * 40.0; //default
	
	}
	
	
}

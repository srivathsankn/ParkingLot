package Strategies;

import Models.VehicleType;

public interface BillingStrategy {
	public Double calculateBilling(VehicleType vehicleType, int numberOfHours);
}

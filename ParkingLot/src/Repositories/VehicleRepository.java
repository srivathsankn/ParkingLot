package Repositories;

import java.util.HashMap;
import java.util.Map;

import Models.Vehicle;

public class VehicleRepository {
	
	private Map<String, Vehicle> vehicleDataStore;
		
	
	public VehicleRepository() {
		this.vehicleDataStore = new HashMap<String, Vehicle>();
	}

	public VehicleRepository(HashMap<String, Vehicle> vehicleDataStore) {
		super();
		this.vehicleDataStore = vehicleDataStore;
	}

	public Vehicle getVehicle(String vehicleNumber) {
		return vehicleDataStore.get(vehicleNumber);
	}

	public void addVehicle(Vehicle vehicle) {
		vehicleDataStore.put(vehicle.getRegNo(), vehicle );
	}
	
}

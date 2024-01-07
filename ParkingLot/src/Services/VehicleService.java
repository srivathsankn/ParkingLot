package Services;

import Models.Vehicle;
import Repositories.VehicleRepository;

public class VehicleService {
	VehicleRepository vehicleRepository;
		
	public VehicleService(VehicleRepository vehicleRepository) {
		super();
		this.vehicleRepository = vehicleRepository;
	}

	public Vehicle findVehicle(String vehicleNumber) {
		return vehicleRepository.getVehicle(vehicleNumber);
	}

	public void addVehicle(Vehicle vehicle) {
		vehicleRepository.addVehicle(vehicle);
	}

}

package Services;

import java.util.List;
import java.util.Map;

import Exceptions.NoSpotAvailableException;
import Exceptions.SpotAllocationStrategyNotDefinedException;
import Exceptions.TicketNumberIncorrectException;
import Models.Bill;
import Models.Gate;
import Models.PaymentMode;
import Models.Spot;
import Models.Ticket;
import Models.VehicleType;
import Repositories.ParkingLotRepository;
import Repositories.ParkingLotRepository;
import Strategies.BillingStrategy;
import Strategies.NearestSpotAllocationStrategy;
import Strategies.SpotAllocationStrategy;

public class ParkingLotService {
	
	private SpotAllocationStrategy spotAllocationStrategy;
	private ParkingLotRepository parkingLotRepository;
	private BillingStrategy billingStrategy;
	
	
	public ParkingLotService(SpotAllocationStrategy spotAllocationStrategy, ParkingLotRepository parkingLotRepository, BillingStrategy billingStrategy) {
		super();
		this.spotAllocationStrategy = spotAllocationStrategy;
		this.parkingLotRepository = parkingLotRepository;
		this.billingStrategy = billingStrategy;
	}
	

	public SpotAllocationStrategy getSpotAllocationStrategy() {
		return spotAllocationStrategy;
	}
	public void setSpotAllocationStrategy(SpotAllocationStrategy spotAllocationStrategy) {
		this.spotAllocationStrategy = spotAllocationStrategy;
	}
	
		
	public ParkingLotRepository getParkingLotRepository() {
		return parkingLotRepository;
	}
	public void setParkingLotRepository(ParkingLotRepository parkingLotRepository) {
		this.parkingLotRepository = parkingLotRepository;
	}
	
	public Spot allocateSpot(VehicleType vehicleType, Integer floorNumber) throws SpotAllocationStrategyNotDefinedException, NoSpotAvailableException {

		if (spotAllocationStrategy == null)
			throw new SpotAllocationStrategyNotDefinedException("No Spot allocation strategy defined");
		
		Map<Integer, List<Spot>> parkingSpots = parkingLotRepository.getAllAvailableSpotsFloorWise();
		
		Spot parkingSpot = spotAllocationStrategy.getSpot(vehicleType, floorNumber, parkingSpots);
		
		if (parkingSpot == null)
			throw new NoSpotAvailableException("No Parking slot available..");
		return parkingSpot;
	}
	public void saveTicket(Ticket ticket) {
		parkingLotRepository.saveTicket(ticket);
		
	}


	public Gate getGate(int entryGateId) {
		return parkingLotRepository.getGate(entryGateId);
	}


	public double calcAmount(int ticketNumber, int numberOfHours) throws TicketNumberIncorrectException {
		VehicleType type = parkingLotRepository.getVehicleType(ticketNumber);
		if (type == null)
			throw new TicketNumberIncorrectException("Ticket Number passed is not Valid.");
		double amount = billingStrategy.calculateBilling(type, numberOfHours);	
		return amount;
	}


	public void saveBill(Bill bill) {
		parkingLotRepository.saveBill(bill);
		
	}




}

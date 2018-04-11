package com.shail.parking;

import com.shail.parking.exceptions.DuplicateParkingSpotException;
import com.shail.parking.exceptions.ParkingException;
import com.shail.parking.exceptions.ParkingSpotNotFoundException;
import com.shail.parking.interfaces.IParkingLot;
import com.shail.parking.interfaces.IParkingSpot;
import com.shail.parking.interfaces.IVehicle;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

/**
 * A ParkingLot contains parking spots which can be occupied by vehicles.
 * @author Shail Shah
 */
public class ParkingLot implements IParkingLot {

	private final Collection<IParkingSpot> parkingSpotsVacant;
	private final Collection<IParkingSpot> parkingSpotsOccupied;
	private static final int INIT_CAPACITY = 500;
	/**
	 * Constructor for creating a new ParkingLot.
	 */
	ParkingLot() {
		parkingSpotsVacant = new HashSet<>(INIT_CAPACITY);
		parkingSpotsOccupied = new HashSet<>(INIT_CAPACITY);
	}

	/**
	 * Get a collection of parking spots that are vacant.
	 *
	 * @return a collection of parking spots that are vacant.
	 */
	public Collection<IParkingSpot> getParkingSpotsVacant(){
		return parkingSpotsVacant;
	}

	/**
	 * Get the parking spots that are occupied in the parking lot.
	 *
	 * @return a collection of parking spots that are occupied.
	 */
	public Collection<IParkingSpot> getParkingSpotsOccupied() {
		return parkingSpotsOccupied;
	}

	/**
	 * Add a parking spot to the parking lot.
	 *
	 * @param parkingSpot a parking spot to add.
	 */
	@Override
	public void addParkingSpot(IParkingSpot parkingSpot) throws DuplicateParkingSpotException {
		if(parkingSpotsVacant.contains(parkingSpot) || parkingSpotsOccupied.contains(parkingSpot))
			throw new DuplicateParkingSpotException(DuplicateParkingSpotException.DEFAULT_MESSAGE);
		parkingSpotsVacant.add(parkingSpot);
	}

	/**
	 * Remove a parking spot from the parking lot.
	 *
	 * @param id the id of the parking spot.
	 */
	@Override
	public void removeParkingSpot(int id) throws ParkingSpotNotFoundException {
		IParkingSpot parkingSpot = findParkingSpot(id);
		parkingSpotsOccupied.remove(parkingSpot);
		parkingSpotsVacant.remove(parkingSpot);
	}

	/**
	 * Park a vehicle in the parking lot.
	 *
	 * @param vehicle a vehicle to park.
	 * @return the parking lot where the vehicle is parked.
	 * @throws ParkingSpotNotFoundException if no parking spot is available for the vehicle to park.
	 */
	@Override
	public IParkingSpot parkVehicle(IVehicle vehicle) throws ParkingSpotNotFoundException, ParkingException {
		assert vehicle != null;

		IParkingSpot parkingSpot = vehicle.pickBestParking(parkingSpotsVacant);
		parkingSpot.parkVehicle(vehicle);

		parkingSpotsVacant.remove(parkingSpot);
		parkingSpotsOccupied.add(parkingSpot);

		return parkingSpot;
	}

	/**
	 * Remove a vehicle from its parking spot in the parking lot.
	 *
	 * @param vehicle a vehicle to be removed.
	 * @throws ParkingSpotNotFoundException when a the parking spot containing the vehicle is not found.
	 */
	@Override
	public void removeVehicle(IVehicle vehicle) throws ParkingSpotNotFoundException {
		IParkingSpot parkingSpot = findParkingSpot(vehicle);
		parkingSpot.removeCurrentVehicle();

		parkingSpotsOccupied.remove(parkingSpot);
		parkingSpotsVacant.add(parkingSpot);
	}

	/**
	 * Find which parking spot the given vehicle is parked in.
	 *
	 * @param vehicle a vehicle to find.
	 * @return the parking spot where the vehicle is parked.
	 * @throws ParkingSpotNotFoundException if the vehicle is not found in any parking spot.
	 */
	@Override
	public IParkingSpot findParkingSpot(IVehicle vehicle) throws ParkingSpotNotFoundException {
		Predicate<IParkingSpot> predicate = ps-> (ps.getCurrentVehicle() != null)
				&& ps.getCurrentVehicle().equals(vehicle);
		IParkingSpot parkingSpot = findParkingSpot(predicate);

		if(parkingSpot == null)
			throw new ParkingSpotNotFoundException(ParkingSpotNotFoundException.DEFAULT_MESSAGE);
		else return parkingSpot;
	}

	/**
	 * Search for a parking spot by Id.
	 *
	 * @param id the id of the parking spot.
	 * @return the instance of the ParkingSpot that has the mentioned id.
	 * @throws ParkingSpotNotFoundException if the parking spot is not found in the parking lot.
	 */
	public IParkingSpot findParkingSpot(int id) throws ParkingSpotNotFoundException{
		Predicate<IParkingSpot> predicate = ps -> ps.getId() == id;
		IParkingSpot parkingSpot = findParkingSpot(predicate);

		if(parkingSpot == null)
			throw new ParkingSpotNotFoundException(ParkingSpotNotFoundException.DEFAULT_MESSAGE);
		else return parkingSpot;
	}

	/**
	 * Search for a parking spot by the given predicate.
	 *
	 * @param predicate the predicate to search by.
	 * @return a parking spot that matches the predicate.
	 * If nothing matches, null's returned.
	 */
	private IParkingSpot findParkingSpot(Predicate<IParkingSpot> predicate) {
		return parkingSpotsOccupied
				.stream()
				.filter(predicate)
				.findFirst()
				.orElseGet(() -> parkingSpotsVacant
						.stream()
						.filter(predicate)
						.findFirst()
						.orElse(null));
	}
}

package com.shail.parking;

import com.shail.parking.enums.Size;
import com.shail.parking.enums.VehicleType;
import com.shail.parking.exceptions.ParkingSpotNotFoundException;
import com.shail.parking.interfaces.IParkingSpot;
import com.shail.parking.interfaces.IVehicle;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * A Vehicle represents a vehicle that can be parked in a parking spot.
 * @author Shail Shah
 */
public class Vehicle implements IVehicle {
	private final String licensePlate;
	private final VehicleType type;
	private final boolean hasHandicapParkingPermit;

	/**
	 * Constructor for making a Vehicle.
	 *
	 * @param licensePlate the license plate number of the vehicle.
	 * @param type the type of vehicle.
	 */
	Vehicle(String licensePlate, VehicleType type, boolean hasHandicapParkingPermit) {
		this.licensePlate = licensePlate;
		this.type = type;
		this.hasHandicapParkingPermit = hasHandicapParkingPermit;
	}

	/**
	 * Get this vehicles's license plate number.
	 *
	 * @return this vehicles's license plate number.
	 */
	@Override
	public String getLicensePlate() {
		return licensePlate;
	}

	/**
	 * Get the size of the vehicle.
	 *
	 * @return the size of the vehicle.
	 */
	@Override
	public Size getSize() {
		return type.getSize();
	}

	/**
	 * Get whether the vehicle has a handicap parking permit.
	 *
	 * @return true if the vehicle has a handicap parking permit.
	 */
	@Override
	public boolean hasHandicapParkingPermit() {
		return hasHandicapParkingPermit;
	}

	/**
	 * Pick the best parking spot from all the parking spots in the parking lot.
	 *
	 * @param parkingSpots a set of parking spots.
	 * @return a parking spot from the given parking spots that can be used by the vehicle to park it in.
	 * @throws ParkingSpotNotFoundException when a parking spot is not found.
	 */
	public IParkingSpot pickBestParking(Collection<IParkingSpot> parkingSpots) throws ParkingSpotNotFoundException {
		List<IParkingSpot> vacantParkingSpotsWithHandicapFilter
				= getHandicapParkingSpots(getVacantParkingSpots(parkingSpots));

		vacantParkingSpotsWithHandicapFilter.sort(Comparator.comparing(IParkingSpot::getSize));

		return vacantParkingSpotsWithHandicapFilter.get(0);
	}

	/**
	 * Get a list of parking spots that are vacant and that can fit this vehicle.
	 *
	 * @param parkingSpots a set of parking spots.
	 * @return a list of parking spots that are vacant and able to fit this vehicle.
	 * @throws ParkingSpotNotFoundException if no such parking spot is available at the moment.
	 */
	private Collection<IParkingSpot> getVacantParkingSpots(Collection<IParkingSpot> parkingSpots)
			throws ParkingSpotNotFoundException {

		Predicate<IParkingSpot> filterPredicateVacant = ps -> ps.isVacant()
				&& (ps.getSize().ordinal() >= type.getSize().ordinal());

		List<IParkingSpot> vacantParkingSpots = parkingSpots.stream()
				.filter(filterPredicateVacant)
				.collect(Collectors.toList());

		if((vacantParkingSpots == null) || vacantParkingSpots.isEmpty())
			throw new ParkingSpotNotFoundException(ParkingSpotNotFoundException.DEFAULT_MESSAGE);
		else return vacantParkingSpots;
	}

	/**
	 * Get a list of parking spots that match this vehicle's handicap parking permission.
	 *
	 * @param parkingSpots a list of parking spots
	 * @return a list of parking spots that match this vehicle's handicap parking permission.
	 * @throws ParkingSpotNotFoundException if no parking spot is available.
	 */
	private List<IParkingSpot> getHandicapParkingSpots(Collection<IParkingSpot> parkingSpots)
			throws ParkingSpotNotFoundException {

		List<IParkingSpot> parkingSpotsWithHandicapFilter = null;
		
		if(hasHandicapParkingPermit)
			parkingSpotsWithHandicapFilter = parkingSpots.stream()
					.filter(IParkingSpot::isForHandicap)
					.collect(Collectors.toList());

		if((parkingSpotsWithHandicapFilter == null) || parkingSpotsWithHandicapFilter.isEmpty())
			parkingSpotsWithHandicapFilter = parkingSpots.stream()
					.filter(ps -> !ps.isForHandicap())
					.collect(Collectors.toList());

		if((parkingSpotsWithHandicapFilter == null) || parkingSpotsWithHandicapFilter.isEmpty())
			throw new ParkingSpotNotFoundException(ParkingSpotNotFoundException.DEFAULT_MESSAGE);

		return parkingSpotsWithHandicapFilter;
	}
}

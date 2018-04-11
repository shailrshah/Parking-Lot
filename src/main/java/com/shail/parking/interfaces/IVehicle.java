package com.shail.parking.interfaces;

import com.shail.parking.enums.Size;
import com.shail.parking.exceptions.ParkingSpotNotFoundException;

import java.util.Collection;

/**
 * A class implementing IVehicle represents a vehicle.
 * @author Shail Shah
 */
public interface IVehicle {

	/**
	 * Get the license plate number.
	 *
	 * @return this vehicles's license plate number.
	 */
	String getLicensePlate();

	/**
	 * Get the size of the vehicle.
	 *
	 * @return the size of the vehicle.
	 */
	Size getSize();

	/**
	 * Get whether the vehicle is allowed to park in spots reserved for handicaps.
	 *
	 * @return true if the vehicle has a handicap parking permit.
	 */
	boolean hasHandicapParkingPermit();

	/**
	 * Pick the best parking spot from all the parking spots in the parking lot.
	 *
	 * @param parkingSpots a collection of parking spots.
	 * @return a parking spot from the given parking spots that can be used by the vehicle to park it in.
	 * @throws ParkingSpotNotFoundException when a parking spot is not found.
	 */
	IParkingSpot pickBestParking(Collection<IParkingSpot> parkingSpots) throws ParkingSpotNotFoundException;
}

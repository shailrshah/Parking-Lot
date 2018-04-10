package com.shail.parking.interfaces;

import com.shail.parking.enums.Size;
import com.shail.parking.exceptions.ParkingSpotNotFoundException;

import java.util.Set;

/**
 * A class implementing IVehicle represents a vehicle
 * @author Shail Shah
 */
public interface IVehicle {

	/**
	 * @return this vehicles's license plate number
	 */
	String getLicensePlate();

	/**
	 * @return the size of the vehicle
	 */
	Size getSize();

	/**
	 * @return true if the vehicle has a handicap parking permit
	 */
	boolean hasHandicapParkingPermit();

	/**
	 * Pick the best parking spot from all the parking spots in the parking lot
	 *
	 * @param parkingSpots a set of parking spots
	 * @return a parking spot from the given parking spots that can be used by the vehicle to park it in
	 * @throws ParkingSpotNotFoundException when a parking spot is not found
	 */
	IParkingSpot pickBestParking(Set<IParkingSpot> parkingSpots) throws ParkingSpotNotFoundException;
}

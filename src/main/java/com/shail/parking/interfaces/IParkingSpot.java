package com.shail.parking.interfaces;

import com.shail.parking.enums.Size;
import com.shail.parking.exceptions.ParkingException;

/**
 * An interface for a parking spot that provides space for vehicles to be parked.
 * @author Shail Shah
 */
public interface IParkingSpot {

	/**
	 * Get the id of the parking spot.
	 *
	 * @return the id of the parking spot.
	 */
	int getId();

	/**
	 * Get the maximum size of the vehicle that can be accommodated.
	 *
	 * @return the maximum size of the vehicle that can be accommodated.
	 */
	Size getSize();

	/**
	 * Get whether the parking spot is for cars with handicap parking permits only.
	 *
	 * @return true if this parking spot is for cars with handicap parking permits only.
	 */
	boolean isForHandicap();

	/**
	 * Get the Vehicle that is currently parked in this parking spot.
	 *
	 * @return the Vehicle that is currently parked in this parking spot.
	 */
	IVehicle getCurrentVehicle();

	/**
	 * Get whether the parking spot is vacant.
	 *
	 * @return true if the parking spot is vacant.
	 */
	boolean isVacant();

	/**
	 * Park a vehicle in this parking spot.
	 *
	 * @param vehicle the vehicle to park.
	 * @throws ParkingException if the vehicle is unable to park in this parking spot.
	 */
	void parkVehicle(IVehicle vehicle) throws ParkingException;

	/**
	 * Remove the currently parked vehicle from this parking spot.
	 */
	void removeCurrentVehicle();
}

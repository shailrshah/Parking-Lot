package com.shail.parking.interfaces;

import com.shail.parking.enums.Size;
import com.shail.parking.exceptions.ParkingException;

/**
 * An interface for a parking spot that provides space for vehicles to be parked
 * @author Shail Shah
 */
public interface IParkingSpot {

	/**
	 * @return the id of the parking spot
	 */
	int getId();

	/**
	 * @return the maximum size of the vehicle that can be accommodated
	 */
	Size getSize();

	/**
	 * @return true if this parking spot is for cars with handicap parking permits only
	 */
	boolean isForHandicap();

	/**
	 * @return the Vehicle that is currently parked in this parking spot
	 */
	IVehicle getCurrentVehicle();

	/**
	 * @return true if no Vehicle is parked in this parking spot
	 */
	boolean isVacant();

	/**
	 * Park a vehicle in this parking spot
	 * @param vehicle the vehicle to park
	 */
	void parkVehicle(IVehicle vehicle) throws ParkingException;

	/**
	 * Remove the currently parked vehicle from this parking spot
	 */
	void removeCurrentVehicle();
}

package com.shail.parking;

import com.shail.parking.Enums.VehicleSize;
import com.shail.parking.Exceptions.VehicleNotFoundException;

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
	VehicleSize getSize();

	/**
	 * @return true if this parking spot is for cars with hadicap parking permits only
	 */
	boolean isForHandicap();

	/**
	 * @return the com.shail.parking.Vehicle that is currently parked in this parking spot
	 */
	Vehicle getCurrentVehicle();

	/**
	 * @return true if no com.shail.parking.Vehicle is parked in this parking spot
	 */
	boolean isVacant();

	/**
	 * Park a vehicle in this parking spot
	 * @param vehicle the vehicle to park
	 */
	void parkVehicle(Vehicle vehicle);

	/**
	 * Remove the currently parked vehicle from this parking spot
	 * @throws VehicleNotFoundException if there is no vehicle in this parking spot
	 */
	void removeCurrentVehicle() throws VehicleNotFoundException ;
}

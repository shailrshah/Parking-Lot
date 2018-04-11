package com.shail.parking.interfaces;

import com.shail.parking.enums.Size;

/**
 * A VehicleType enum value represents the type of vehicle.
 * @author Shail Shah
 */
public interface IVehicleType {
	/**
	 * Get the size of the vehicle.
	 * @return the size of the vehicle.
	 */
	Size getSize();
}

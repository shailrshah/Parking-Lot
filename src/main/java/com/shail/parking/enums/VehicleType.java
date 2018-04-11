package com.shail.parking.enums;

import com.shail.parking.interfaces.IVehicleType;

/**
 * A VehicleType enum value represents the type of vehicle.
 * @author Shail Shah
 */
public enum VehicleType implements IVehicleType{
	BIKE(Size.SMALL),
	CAR(Size.MEDIUM),
	BUS(Size.LARGE);

	private final Size size;

	/**
	 * Constructor for making  a new VehicleType.
	 *
	 * @param size the size of the vehicle.
	 */
	VehicleType(Size size) {
		this.size = size;
	}

	/**
	 * Get the size of the vehicle.
	 *
	 * @return the size of the vehicle.
	 */
	public Size getSize(){
		return size;
	}
}

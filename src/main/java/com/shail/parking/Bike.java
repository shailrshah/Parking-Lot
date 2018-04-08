package com.shail.parking;

/**
 * A Bike is a small-sized vehicle
 * @author Shail shah
 */
public class Bike extends Vehicle{

	/**
	 * Constructor for creating a com.shail.parking.Bike instance
	 * @param licensePlate the license plate number
	 * @param hasHandicapLabel true iff the bike has a handicap label
	 */
	Bike(String licensePlate, boolean hasHandicapLabel) {
		super(licensePlate, hasHandicapLabel);
	}

	/**
	 * @return the size of this com.shail.parking.Bike
	 */
	@Override
	public VehicleSize getSize() {
		return VehicleSize.SMALL;
	}
}

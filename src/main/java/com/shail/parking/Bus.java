package com.shail.parking;

/**
 * A Bus is a large-sized vehicle
 * @author Shail Shah
 */
public class Bus extends Vehicle {

	/**
	 * Constructor for creating a com.shail.parking.Bus instance
	 * @param licensePlate the license plate number
	 * @param hasHandicapLabel true iff the bike has a handicap label
	 */
	Bus(String licensePlate, boolean hasHandicapLabel) {
		super(licensePlate, hasHandicapLabel);
	}

	/**
	 * @return the size of this com.shail.parking.Bus
	 */
	@Override
	public VehicleSize getSize() {
		return VehicleSize.LARGE;
	}
}

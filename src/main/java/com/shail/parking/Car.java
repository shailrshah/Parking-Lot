package com.shail.parking;

/**
 * A Car is a medium-sized vehicle
 * @author Shail Shah
 */
public class Car extends Vehicle {

	/**
	 * Constructor for creating a com.shail.parking.Car instance
	 * @param licensePlate the license plate number
	 * @param hasHandicapLabel true iff the bike has a handicap label
	 */
	Car(String licensePlate, boolean hasHandicapLabel) {
		super(licensePlate, hasHandicapLabel);
	}

	/**
	 * @return the size of this com.shail.parking.Car
	 */
	@Override
	public VehicleSize getSize() {
		return VehicleSize.MEDIUM;
	}
}

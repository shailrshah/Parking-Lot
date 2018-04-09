package com.shail.parking;

/**
 * An com.shail.parking.VehicleNotFoundException is thrown when
 * a vehicle is not found in the parking spot or the entire lot
 * @author Shail Shah
 */
public class VehicleNotFoundException extends Exception {

	/**
	 * Constructor for com.shail.parking.VehicleNotFoundException
	 * @param message the message to print out
	 */
	VehicleNotFoundException(String message) {
		super(message);
	}
}

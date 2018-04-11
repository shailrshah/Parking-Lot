package com.shail.parking.exceptions;

/**
 * An ParkingSpotNotFoundException is thrown when
 * there is no parking space available for the vehicle to use.
 * @author Shail Shah
 */
public class ParkingSpotNotFoundException extends Exception {

	public static final String DEFAULT_MESSAGE = "Parking spot could not be found.";

	/**
	 * Constructor for creating a new ParkingSpotNotFoundException.
	 *
	 * @param message the message to print out.
	 */
	public ParkingSpotNotFoundException(String message) {
		super(message);
	}
}

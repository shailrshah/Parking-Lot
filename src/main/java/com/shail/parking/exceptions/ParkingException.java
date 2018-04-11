package com.shail.parking.exceptions;

/**
 * A ParkingException is thrown
 * when a vehicle tries to park in a spot which is either too small
 * or reserved for handicap.
 * @author Shail Shah
 */
public class ParkingException extends Exception {

	public static final String DEFAULT_MESSAGE = "Count not park the car in the parking spot.";

	/**
	 * Constructor for creating a new ParkingException.
	 *
	 * @param message the message to print out.
	 */
	public ParkingException(String message) {
		super(message);
	}
}

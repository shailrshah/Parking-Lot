package com.shail.parking;

/**
 * An NoParkingSpotAvailableException is thrown when
 * there is no parking space available for the vehicle to use
 * @author Shail Shah
 */
public class NoParkingSpotAvailableException extends Exception {

	/**
	 * Constructor for creating a new com.shail.parking.NoParkingSpotAvailableException
	 * @param message the message to print out
	 */
	NoParkingSpotAvailableException(String message) {
		super(message);
	}
}

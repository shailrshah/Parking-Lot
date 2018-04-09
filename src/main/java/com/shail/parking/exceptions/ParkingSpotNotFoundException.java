package com.shail.parking;

/**
 * An ParkingSpotNotFoundException is thrown when
 * there is no parking space available for the vehicle to use
 * @author Shail Shah
 */
public class ParkingSpotNotFoundException extends Exception {

	/**
	 * Constructor for creating a new com.shail.parking.ParkingSpotNotFoundException
	 * @param message the message to print out
	 */
	ParkingSpotNotFoundException(String message) {
		super(message);
	}
}

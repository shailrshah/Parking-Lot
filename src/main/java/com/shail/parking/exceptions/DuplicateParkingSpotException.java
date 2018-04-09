package com.shail.parking;

/**
 * A DuplicateParkingSpotException is thrown when
 * a parking spot with the same id already exists in the parking lot
 * @author Shail Shah
 */
public class DuplicateParkingSpotException extends Exception {

	/**
	 * The 
	 * @param message
	 */
	DuplicateParkingSpotException(String message) {
		super(message);
	}
}

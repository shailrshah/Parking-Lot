package com.shail.parking.exceptions;

/**
 * A DuplicateParkingSpotException is thrown when
 * a parking spot with the same id already exists in the parking lot.
 * @author Shail Shah
 */
public class DuplicateParkingSpotException extends Exception {

	public static final String DEFAULT_MESSAGE = "A parking spot with the same id already exists.";

	/**
	 * Constructor for creating a new DuplicateParkingSpotException.
	 *
	 * @param message a message to printout.
	 */
	public DuplicateParkingSpotException(String message) {
		super(message);
	}
}

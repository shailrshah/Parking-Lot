package com.shail.parking;

/**
 * com.shail.parking.VehicleSize represents the size of a com.shail.parking.Vehicle
 * @author Shail Shah
 */
public enum VehicleSize {
	SMALL(1),
	MEDIUM(2),
	LARGE(3);

	private int val;

	/**
	 * Constructor for creating a new com.shail.parking.VehicleSize
	 * @param val the numeric value of this enum
	 */
	VehicleSize(int val) {
		this.val = val;
	}

	/**
	 * @return the numeric value of this enum
	 */
	int getVal() {
		return this.val;
	}
}

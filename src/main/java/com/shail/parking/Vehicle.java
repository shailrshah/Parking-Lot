package com.shail.parking;

import java.util.stream.IntStream;

/**
 * A Vehicle represents a vehicle that can be parked in a parking spot
 * @author Shail Shah
 */
public abstract class Vehicle implements Comparable<Vehicle>{
	private String licensePlate;
	private boolean hasHandicapParkingPermit;

	/**
	 * Constructor for making a new com.shail.parking.Vehicle
	 * @param licensePlate the license plate number of the vehicle
	 * @param hasHandicapParkingPermit true iff the vehicle has a handicap parking permit
	 */
	Vehicle(String licensePlate, boolean hasHandicapParkingPermit) {
		this.licensePlate = licensePlate;
		this.hasHandicapParkingPermit = hasHandicapParkingPermit;
	}

	/**
	 * @return this vehicles's license plate number
	 */
	public String getLicensePlate() {
		return licensePlate;
	}

	/**
	 * @return the size of the vehicle
	 */
	abstract VehicleSize getSize();

	/**
	 * @return true iff this vehicle has a handicap parking permit
	 */
	public boolean getHasHandicapParkingPermit() {
		return hasHandicapParkingPermit;
	}

	/**
	 * Compare this vehicle with another one
	 * @param v another vehicle
	 * @return > 0 if this vehicle is 'greater than' the other vehicle, < 0 if the opposite is true.
	 * 0 if both are equal
	 */
	@Override
	public int compareTo(Vehicle v) {
		int bySizeAsc = this.getSize().getVal() - v.getSize().getVal();
		int byHandicapLabelAsc = Boolean.compare(v.getHasHandicapParkingPermit(), this.getHasHandicapParkingPermit());
		int byLicensePlateAsc = this.getLicensePlate().compareTo(v.getLicensePlate());

		if(bySizeAsc != 0) return bySizeAsc;
		if(byHandicapLabelAsc != 0) return byHandicapLabelAsc;
		return byLicensePlateAsc;

	}
}

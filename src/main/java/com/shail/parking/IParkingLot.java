package com.shail.parking;

/**
 * An interface for a parking lot that has parking spaces for vehicles
 * @author Shail Shah
 */
public interface IParkingLot {

	/**
	 * Add a parking spot to the parking lot
	 * @param parkingSpot a parking spot to add
	 */
	void addParkingSpot(ParkingSpot parkingSpot);

	/**
	 * Remove a parking spot from the parking lot
	 * @param id the id of the parking spot
	 */
	void removeParkingSpot(int id);

	/**
	 * Can the given vehicle be accommodated in the parking lot?
	 * @param vehicle a vehicle to park
	 * @return true iff there is a space in the parking lot that can accommodate the vehicle
	 */
	boolean canParkVehicle(Vehicle vehicle);

	/**
	 * Park a vehicle in the parking lot
	 * @param vehicle a vehicle to park
	 * @return the parking lot where the vehicle is parked
	 * @throws NoParkingSpotAvailableException if no parking spot is available for the vehicle to park
	 */
	ParkingSpot parkVehicle(Vehicle vehicle) throws NoParkingSpotAvailableException;

	/**
	 * Remove a vehicle from its parking spot in the parking lot
	 * @param vehicle a vehicle to be removed
	 */
	void removeVehicle(Vehicle vehicle);

	/**
	 * Find which parking spot the given vehicle is parked in
	 * @param vehicle a vehicle to find
	 * @return the location of the parked vehicle
	 * @throws VehicleNotFoundException if the vehicle is not found in any parking spot
	 */
	ParkingSpot findVehicle(Vehicle vehicle) throws VehicleNotFoundException;
}
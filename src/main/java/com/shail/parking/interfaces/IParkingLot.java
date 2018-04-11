package com.shail.parking.interfaces;

import com.shail.parking.exceptions.DuplicateParkingSpotException;
import com.shail.parking.exceptions.ParkingException;
import com.shail.parking.exceptions.ParkingSpotNotFoundException;

import java.util.Collection;

/**
 * An interface for a parking lot that has parking spaces for vehicles.
 * @author Shail Shah
 */
public interface IParkingLot {

	/**
	 * Get a collection of parking spots that are vacant.
	 * @return a collection of parking spots that are vacant.
	 */
	Collection<IParkingSpot> getParkingSpotsVacant();

	/**
	 * Get a collection of parking spots that are occupied.
	 *
	 * @return a collection of parking spots that are occupied.
	 */
	Collection<IParkingSpot> getParkingSpotsOccupied();

	/**
	 * Add a parking spot to the parking lot.
	 *
	 * @param parkingSpot a parking spot to add.
	 * @throws DuplicateParkingSpotException if parking spot already exists.
	 */
	void addParkingSpot(IParkingSpot parkingSpot) throws DuplicateParkingSpotException;

	/**
	 * Remove a parking spot from the parking lot.
	 *
	 * @param id the id of the parking spot.
	 * @throws ParkingSpotNotFoundException if no parking spot is found with the specified id.
	 */
	void removeParkingSpot(int id) throws ParkingSpotNotFoundException;

	/**
	 * Park a vehicle in the parking lot.
	 *
	 * @param vehicle a vehicle to park.
	 * @return the parking lot where the vehicle is parked.
	 * @throws ParkingSpotNotFoundException if no parking spot is available for the vehicle to park.
	 * @throws ParkingException if the vehicle is unable to park in a parking spot.
	 */
	IParkingSpot parkVehicle(IVehicle vehicle) throws ParkingSpotNotFoundException, ParkingException;

	/**
	 * Remove a vehicle from its parking spot in the parking lot.
	 *
	 * @param vehicle a vehicle to be removed.
	 * @throws ParkingSpotNotFoundException when a the parking spot containing the vehicle is not found.
	 */
	void removeVehicle(IVehicle vehicle) throws ParkingSpotNotFoundException;

	/**
	 * Find which parking spot the given vehicle is parked in.
	 *
	 * @param vehicle a vehicle to find.
	 * @return the location of the parked vehicle.
	 * @throws ParkingSpotNotFoundException when a the parking spot containing the vehicle is not found.
	 */
	IParkingSpot findParkingSpot(IVehicle vehicle) throws ParkingSpotNotFoundException;

	/**
	 * Search for a parking spot by Id.
	 *
	 * @param id the id of the parking spot.
	 * @return the instance of the ParkingSpot that has the mentioned id.
	 * @throws ParkingSpotNotFoundException when a the parking spot containing the vehicle is not found.
	 */
	IParkingSpot findParkingSpot(int id) throws ParkingSpotNotFoundException;
}
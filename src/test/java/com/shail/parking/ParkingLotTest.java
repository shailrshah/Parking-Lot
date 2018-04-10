package com.shail.parking;

import com.shail.parking.enums.Size;
import com.shail.parking.enums.VehicleType;
import com.shail.parking.exceptions.DuplicateParkingSpotException;
import com.shail.parking.exceptions.ParkingException;
import com.shail.parking.exceptions.ParkingSpotNotFoundException;
import com.shail.parking.interfaces.IParkingLot;
import com.shail.parking.interfaces.IParkingSpot;
import com.shail.parking.interfaces.IVehicle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for ParkingLot
 * @author Shail Shah
 */
public class ParkingLotTest {

	private IParkingLot parkingLot;

	/**
	 * Setup for all other tests
	 * @throws DuplicateParkingSpotException when identical parking spots are added
	 */
	@Before
	public void init() throws DuplicateParkingSpotException {
		parkingLot = new ParkingLot();

		parkingLot.addParkingSpot(new ParkingSpot(1, Size.MEDIUM, false));
		parkingLot.addParkingSpot(new ParkingSpot(2, Size.MEDIUM, true));
		parkingLot.addParkingSpot(new ParkingSpot(3, Size.SMALL, false));
		parkingLot.addParkingSpot(new ParkingSpot(4, Size.SMALL, true));
		parkingLot.addParkingSpot(new ParkingSpot(5, Size.LARGE, false));
		parkingLot.addParkingSpot(new ParkingSpot(6, Size.LARGE, true));
	}

	/**
	 * Test adding and removing parking spots
	 * @throws DuplicateParkingSpotException if identical spots are added
	 * @throws ParkingSpotNotFoundException if spot is not found during deletion
	 */
	@Test
	public void addRemoveParkingSpot() throws DuplicateParkingSpotException, ParkingSpotNotFoundException {
		int initialVacantCount = parkingLot.getParkingSpotsVacant().size();
		parkingLot.addParkingSpot(new ParkingSpot(100, Size.MEDIUM, true));
		assertEquals(initialVacantCount+1, parkingLot.getParkingSpotsVacant().size());
		parkingLot.removeParkingSpot(100);
		assertEquals(initialVacantCount, parkingLot.getParkingSpotsVacant().size());
	}

	/**
	 * Test adding duplicate parking spots
	 * @throws DuplicateParkingSpotException if identical spots are added
	 */
	@Test(expected = DuplicateParkingSpotException.class)
	public void addParkingSpotDuplicate() throws DuplicateParkingSpotException {
		parkingLot.addParkingSpot(new ParkingSpot(1, Size.SMALL, false));
	}


	/**
	 * Test parking and removing a vehicle
	 * @throws ParkingSpotNotFoundException if parking spot is not found for the vehicle
	 * @throws ParkingException if the vehicle cannot be parked in a parking spot
	 */
	@Test
	public void parkRemoveVehicle() throws ParkingSpotNotFoundException, ParkingException {
		IVehicle vehicle = new Vehicle("MH1294", VehicleType.CAR, true);
		int initialVacantCount = parkingLot.getParkingSpotsVacant().size();
		int initialOccupiedCount = parkingLot.getParkingSpotsOccupied().size();

		parkingLot.parkVehicle(vehicle);
		assertTrue(parkingLot.getParkingSpotsOccupied().contains(parkingLot.findParkingSpot(vehicle)));
		assertEquals(initialVacantCount-1, parkingLot.getParkingSpotsVacant().size());
		assertEquals(initialOccupiedCount+1, parkingLot.getParkingSpotsOccupied().size());

		parkingLot.removeVehicle(vehicle);
		assertEquals(initialVacantCount, parkingLot.getParkingSpotsVacant().size());
		assertEquals(initialOccupiedCount, parkingLot.getParkingSpotsOccupied().size());
	}

	/**
	 * Test parking when the lot is full
	 * @throws ParkingSpotNotFoundException if parking spot is not found for the vehicle
	 * @throws ParkingException if the vehicle cannot be parked in a parking spot
	 */
	@Test(expected = ParkingSpotNotFoundException.class)
	public void removeVehicle() throws ParkingSpotNotFoundException, ParkingException {
		for(int i = 2000; i < 3000; i++)
			parkingLot.parkVehicle(new Vehicle("MH"+i, VehicleType.BIKE, false));
	}

	/**
	 * Test finding a parking spot by the vehicle
	 * @throws ParkingSpotNotFoundException when the parking spot is not found
	 * @throws ParkingException if the vehicle cannot be parked in a parking spot
	 */
	@Test
	public void findParkingSpotVehicle() throws ParkingSpotNotFoundException, ParkingException {
		IVehicle vehicle = new Vehicle("MH1294", VehicleType.CAR, true);
		IParkingSpot parkingSpot = parkingLot.parkVehicle(vehicle);
		assertEquals(parkingSpot, parkingLot.findParkingSpot(vehicle));
	}

	/**
	 * Test finding a parking spot by its id
	 * @throws ParkingSpotNotFoundException if the parking spot is not found
	 */
	@Test
	public void findParkingSpotId() throws ParkingSpotNotFoundException {
		IParkingSpot parkingSpot = parkingLot.findParkingSpot(1);
		assertEquals(1, parkingSpot.getId());
	}
}
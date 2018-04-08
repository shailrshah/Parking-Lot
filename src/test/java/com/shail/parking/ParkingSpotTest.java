package com.shail.parking;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test ParkingSpot
 * @author Shail Shah
 */
public class ParkingSpotTest {
	private ParkingSpot parkingSpot;

	/**
	 * Setup for the rest of the tests
	 */
	@Before
	public void init() {
		parkingSpot = new ParkingSpot(1, VehicleSize.MEDIUM, true);
	}

	/**
	 * Test for getting Id
	 */
	@Test
	public void getId() {
		assertEquals(1, parkingSpot.getId());
	}

	/**
	 * Test for getting size
	 */
	@Test
	public void getSize() {
		assertEquals(VehicleSize.MEDIUM, parkingSpot.getSize());
	}

	/**
	 * Test for seeing if handicap
	 */
	@Test
	public void isForHandicap() {
		assertTrue(parkingSpot.isForHandicap());
	}

	/**
	 * Test for getting current vehicle
	 */
	@Test
	public void getCurrentVehicle() {
		assertNull(parkingSpot.getCurrentVehicle());
	}

	/**
	 * Test for checking if vacant
	 */
	@Test
	public void isVacant() {
		assertTrue(parkingSpot.isVacant());
	}

	/**
	 * Check for parking and unparking
	 * @throws VehicleNotFoundException if there is no car in the parking
	 */
	@Test
	public void parkVehicle() throws VehicleNotFoundException{
		Vehicle car = new Car("ABC123", true);
		parkingSpot.parkVehicle(car);
		parkingSpot.removeCurrentVehicle();
	}

	@Test(expected = VehicleNotFoundException.class)
	public void removeVehicleNull() throws VehicleNotFoundException {
		parkingSpot.removeCurrentVehicle();
	}
}
package com.shail.parking;

import com.shail.parking.enums.Size;
import com.shail.parking.enums.VehicleType;
import com.shail.parking.exceptions.ParkingException;
import com.shail.parking.interfaces.IParkingSpot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for ParkingSpot
 * @author Shail Shah
 */
public class ParkingSpotTest {

	private IParkingSpot parkingSpot;

	/**
	 * Setup before the rest of the tests
	 */
	@Before
	public void init() {
		parkingSpot = new ParkingSpot(1, Size.MEDIUM, false);
	}

	/**
	 * Test to get Id of the parking spot
	 */
	@Test
	public void getId() {
		assertEquals(1, parkingSpot.getId());
	}

	/**
	 * Test to get the size of the parking spot
	 */
	@Test
	public void getSize() {
		assertEquals(Size.MEDIUM, parkingSpot.getSize());
	}

	/**
	 * Test to check if parking spot is reserved for handicaps
	 */
	@Test
	public void isForHandicap() {
		assertFalse(parkingSpot.isForHandicap());
	}

	/**
	 * Test to get current vehicle in the parking spot
	 */
	@Test
	public void getCurrentVehicle() {
		assertNull(parkingSpot.getCurrentVehicle());
	}

	/**
	 * Test to check if parking spot is vacant
	 */
	@Test
	public void isVacant() {
		assertTrue(parkingSpot.isVacant());
	}

	/**
	 * Test to park vehicle
	 *
	 * @throws ParkingException when vehicle cannot be parked in the parking spot
	 */
	@Test
	public void parkVehicle() throws ParkingException {
		Vehicle car = new Vehicle("MH1283", VehicleType.CAR, true);
		parkingSpot.parkVehicle(car);
		assertEquals(car, parkingSpot.getCurrentVehicle());
		parkingSpot.removeCurrentVehicle();
		assertTrue(parkingSpot.isVacant());
	}

	/**
	 * Test parking a vehicle that is too big to be parked in a parking spot
	 *
	 * @throws ParkingException when the vehicle can't be parked in the parking spot
	 */
	@Test (expected = ParkingException.class)
	public void removeCurrentVehicle() throws ParkingException {
		parkingSpot.parkVehicle(new Vehicle("MH1294", VehicleType.BUS, false));
	}

	/**
	 * Test equality of two parking spots
	 */
	@Test
	public void equals() {
		ParkingSpot duplicateParkingSpot = new ParkingSpot(1, Size.LARGE, true);
		assertEquals(duplicateParkingSpot, parkingSpot);
	}

	/**
	 * Test weather returned hashcode
	 */
	@Test
	public void testHashCode() {
		assertEquals(1,parkingSpot.hashCode());
	}
}
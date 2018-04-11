package com.shail.parking;

import com.shail.parking.enums.Size;
import com.shail.parking.enums.VehicleType;
import com.shail.parking.exceptions.ParkingException;
import com.shail.parking.interfaces.IParkingSpot;
import com.shail.parking.interfaces.IVehicle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

/**
 * Tests for ParkingSpot.
 * @author Shail Shah
 */
public class ParkingSpotTest {

	private IParkingSpot parkingSpot;

	/**
	 * Setup before the rest of the tests.
	 */
	@Before
	public void init() {
		parkingSpot = new ParkingSpot(1, Size.MEDIUM, false);
	}

	/**
	 * Test to get Id of the parking spot.
	 */
	@Test
	public void getId() {
		Assert.assertThat(parkingSpot.getId(), is(1));
	}

	/**
	 * Test to get the size of the parking spot.
	 */
	@Test
	public void getSize() {
		Assert.assertThat(parkingSpot.getSize(), is(Size.MEDIUM));
	}

	/**
	 * Test to check if parking spot is reserved for handicaps.
	 */
	@Test
	public void isForHandicap() {
		Assert.assertThat(parkingSpot.isForHandicap(), is(false));
	}

	/**
	 * Test to get current vehicle in the parking spot.
	 */
	@Test
	public void getCurrentVehicle() {
		Assert.assertThat(parkingSpot.getCurrentVehicle(), nullValue());
	}

	/**
	 * Test to check if parking spot is vacant.
	 */
	@Test
	public void isVacant() {
		Assert.assertThat(parkingSpot.isVacant(), is(true));
	}

	/**
	 * Test to park vehicle.
	 *
	 * @throws ParkingException when vehicle cannot be parked in the parking spot.
	 */
	@Test
	public void parkVehicle() throws ParkingException {
		IVehicle car = new Vehicle("MH1283", VehicleType.CAR, true);
		parkingSpot.parkVehicle(car);
		Assert.assertThat(parkingSpot.getCurrentVehicle(), is(car));
		parkingSpot.removeCurrentVehicle();
		Assert.assertThat(parkingSpot.isVacant(), is(true));
	}

	/**
	 * Test parking a vehicle that is too big to be parked in a parking spot.
	 *
	 * @throws ParkingException when the vehicle can't be parked in the parking spot.
	 */
	@Test (expected = ParkingException.class)
	public void removeCurrentVehicle() throws ParkingException {
		parkingSpot.parkVehicle(new Vehicle("MH1294", VehicleType.BUS, false));
	}

	/**
	 * Test equality of two parking spots.
	 */
	@Test
	public void equals() {
		IParkingSpot duplicateParkingSpot = new ParkingSpot(1, Size.LARGE, true);
		Assert.assertThat(parkingSpot, is(duplicateParkingSpot));
	}

	/**
	 * Test weather returned hashcode.
	 */
	@Test
	public void testHashCode() {
		Assert.assertThat(parkingSpot.hashCode(), is(1));
	}
}
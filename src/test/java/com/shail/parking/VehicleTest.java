package com.shail.parking;

import com.shail.parking.enums.Size;
import com.shail.parking.enums.VehicleType;
import com.shail.parking.exceptions.ParkingSpotNotFoundException;
import com.shail.parking.interfaces.IParkingSpot;
import com.shail.parking.interfaces.IVehicle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.*;

/**
 * Tests for Vehicle
 * @author Shail Shah
 */
public class VehicleTest {
	private IVehicle vehicle;

	/**
	 * Setup for other tests.
	 */
	@Before
	public void init() {
		vehicle = new Vehicle("MH1294", VehicleType.CAR, false);
	}

	/**
	 * Test for getting the license plate number.
	 */
	@Test
	public void getLicensePlate() {
		Assert.assertThat(vehicle.getLicensePlate(), is("MH1294"));
	}

	/**
	 * Test for getting the size of the vehicle.
	 */
	@Test
	public void getSize() {
		Assert.assertThat(vehicle.getSize(), is(Size.MEDIUM));
	}

	/**
	 * Test for getting the hasHandicapParkingPermit boolean value of the vehicle.
	 */
	@Test
	public void hasHandicapParkingPermit() {
		Assert.assertThat(vehicle.hasHandicapParkingPermit(), is(false));
	}

	/**
	 * Test for picking the best parking spot.
	 *
	 * @throws ParkingSpotNotFoundException when a parking spot is not found.
	 */
	@Test
	public void pickBestParking() throws ParkingSpotNotFoundException {
		Collection<IParkingSpot> parkingSpots = new HashSet<>(10);

		parkingSpots.add(new ParkingSpot(1, Size.SMALL, false));
		parkingSpots.add(new ParkingSpot(2, Size.MEDIUM, true));
		parkingSpots.add(new ParkingSpot(3, Size.LARGE, false));
		parkingSpots.add(new ParkingSpot(4, Size.MEDIUM, false));

		Assert.assertThat(vehicle.pickBestParking(parkingSpots).getId(), is(4));
	}

	/**
	 * Test picking the best parking spot when nothing is available.
	 *
	 * @throws ParkingSpotNotFoundException when no parking spot is available for the vehicle.
	 */
	@Test(expected = ParkingSpotNotFoundException.class)
	public void pickBestParkingException() throws ParkingSpotNotFoundException {
		vehicle.pickBestParking(new HashSet<>(10));
	}
}
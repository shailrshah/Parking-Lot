package com.shail.parking;

import com.shail.parking.enums.Size;
import com.shail.parking.enums.VehicleType;
import com.shail.parking.exceptions.ParkingSpotNotFoundException;
import com.shail.parking.interfaces.IParkingSpot;
import com.shail.parking.interfaces.IVehicle;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class VehicleTest {
	private IVehicle vehicle;

	@Before
	public void init() {
		vehicle = new Vehicle("MH1294", VehicleType.CAR, false);
	}

	@Test
	public void getLicensePlate() {
		assertEquals("MH1294", vehicle.getLicensePlate());
	}

	@Test
	public void getSize() {
		assertEquals(Size.MEDIUM, vehicle.getSize());
	}

	@Test
	public void hasHandicapParkingPermit() {
		assertFalse(vehicle.hasHandicapParkingPermit());
	}

	@Test
	public void pickBestParking() throws ParkingSpotNotFoundException {
		Set<IParkingSpot> parkingSpots = new HashSet<>();

		parkingSpots.add(new ParkingSpot(1, Size.SMALL, false));
		parkingSpots.add(new ParkingSpot(2, Size.MEDIUM, true));
		parkingSpots.add(new ParkingSpot(3, Size.LARGE, false));
		parkingSpots.add(new ParkingSpot(4, Size.MEDIUM, false));

		assertEquals(4, vehicle.pickBestParking(parkingSpots).getId());
	}

	@Test(expected = ParkingSpotNotFoundException.class)
	public void pickBestParkingException() throws ParkingSpotNotFoundException {
		vehicle.pickBestParking(new HashSet<>());
	}
}
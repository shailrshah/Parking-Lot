package com.shail.parking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BusTest {

	private Vehicle bus;

	@Before
	public void init() {
		bus = new Bus("NYB0S18", false);
	}

	@Test
	public void getSize() {
		Assert.assertEquals(VehicleSize.LARGE, bus.getSize());
	}

	@Test
	public void getLicensePlate() {
		assertEquals("NYB0S18", bus.getLicensePlate());
	}

	@Test
	public void getHasHandicapParkingPermit() {
		assertFalse(bus.getHasHandicapParkingPermit());
	}
}
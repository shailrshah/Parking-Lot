package com.shail.parking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

	private Vehicle car;

	@Before
	public void init() {
		car = new Car("NHDR173R", true);
	}

	@Test
	public void getSize() {
		Assert.assertEquals(VehicleSize.MEDIUM, car.getSize());
	}

	@Test
	public void getLicensePlate() {
		assertEquals("NHDR173R", car.getLicensePlate());
	}

	@Test
	public void getHasHandicapParkingPermit() {
		assertTrue(car.getHasHandicapParkingPermit());
	}
}
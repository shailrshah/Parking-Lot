package com.shail.parking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BikeTest {
	private Vehicle bike;

	@Before
	public void init() {
		bike = new Bike("MAB1K3R", false);
	}

	@Test
	public void getSize() {
		Assert.assertEquals(VehicleSize.SMALL, bike.getSize());
	}

	@Test
	public void getLicensePlate() {
		assertEquals("MAB1K3R", bike.getLicensePlate());
	}

	@Test
	public void getHasHandicapParkingPermit() {
		assertFalse(bike.getHasHandicapParkingPermit());
	}
}
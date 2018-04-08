package com.shail.parking;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for VehicleSize
 * @author Shail Shah
 */
public class VehicleSizeTest {

	/**
	 * test for checking values of different vehicles
	 */
	@Test
	public void getVal() {
		Vehicle bike = new Bike("MAB1K3R", false);
		Vehicle car = new Car("NHDR173R", true);
		Vehicle bus = new Bus("NYB0S18", false);

		assertEquals(1, bike.getSize().getVal());
		assertEquals(2, car.getSize().getVal());
		assertEquals(3, bus.getSize().getVal());
	}
}
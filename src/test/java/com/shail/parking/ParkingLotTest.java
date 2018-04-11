package com.shail.parking;

import com.shail.parking.enums.Size;
import com.shail.parking.enums.VehicleType;
import com.shail.parking.exceptions.DuplicateParkingSpotException;
import com.shail.parking.exceptions.ParkingException;
import com.shail.parking.exceptions.ParkingSpotNotFoundException;
import com.shail.parking.interfaces.IParkingLot;
import com.shail.parking.interfaces.IParkingSpot;
import com.shail.parking.interfaces.IVehicle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

/**
 * Tests for ParkingLot.
 * @author Shail Shah
 */
public class ParkingLotTest {

	private IParkingLot parkingLot;

	/**
	 * Setup for all other tests.
	 *
	 * @throws DuplicateParkingSpotException when identical parking spots are added.
	 */
	@Before
	public void init() throws DuplicateParkingSpotException {
		parkingLot = new ParkingLot();
		int count = 0;
		for(Size size : Size.values()) {
			parkingLot.addParkingSpot(new ParkingSpot(count++, size, false));
			parkingLot.addParkingSpot(new ParkingSpot(count++, size, false));
		}
	}

	/**
	 * Test adding and removing parking spots.
	 *
	 * @throws DuplicateParkingSpotException if identical spots are added.
	 * @throws ParkingSpotNotFoundException if spot is not found during deletion.
	 */
	@Test
	public void addRemoveParkingSpot() throws DuplicateParkingSpotException, ParkingSpotNotFoundException {
		int initialVacantCount = parkingLot.getParkingSpotsVacant().size();
		parkingLot.addParkingSpot(new ParkingSpot(100, Size.MEDIUM, true));
		Assert.assertThat(parkingLot.getParkingSpotsVacant().size(), is(initialVacantCount + 1));
		parkingLot.removeParkingSpot(100);
		Assert.assertThat(parkingLot.getParkingSpotsVacant().size(), is(initialVacantCount));
	}

	/**
	 * Test adding duplicate parking spots.
	 *
	 * @throws DuplicateParkingSpotException if identical spots are added.
	 */
	@Test(expected = DuplicateParkingSpotException.class)
	public void addParkingSpotDuplicate() throws DuplicateParkingSpotException {
		parkingLot.addParkingSpot(new ParkingSpot(1, Size.SMALL, false));
	}


	/**
	 * Test parking and removing a vehicle.
	 *
	 * @throws ParkingSpotNotFoundException if parking spot is not found for the vehicle.
	 * @throws ParkingException if the vehicle cannot be parked in a parking spot.
	 */
	@Test
	public void parkRemoveVehicle() throws ParkingSpotNotFoundException, ParkingException {
		IVehicle vehicle = new Vehicle("MH1284", VehicleType.CAR, true);
		int initialVacantCount = parkingLot.getParkingSpotsVacant().size();
		int initialOccupiedCount = parkingLot.getParkingSpotsOccupied().size();

		parkingLot.parkVehicle(vehicle);
		Assert.assertThat(parkingLot.getParkingSpotsOccupied(), hasItem(parkingLot.findParkingSpot(vehicle)));
		Assert.assertThat(parkingLot.getParkingSpotsVacant().size(), is(initialVacantCount - 1));
		Assert.assertThat(parkingLot.getParkingSpotsOccupied().size(), is(initialOccupiedCount + 1));

		parkingLot.removeVehicle(vehicle);
		Assert.assertThat(parkingLot.getParkingSpotsVacant().size(), is(initialVacantCount));
		Assert.assertThat(parkingLot.getParkingSpotsOccupied().size(), is(initialOccupiedCount));
	}

	/**
	 * Test parking when the lot is full.
	 *
	 * @throws ParkingSpotNotFoundException if parking spot is not found for the vehicle.
	 * @throws ParkingException if the vehicle cannot be parked in a parking spot.
	 */
	@Test(expected = ParkingSpotNotFoundException.class)
	public void removeVehicle() throws ParkingSpotNotFoundException, ParkingException {
		for(int i = 2000; i < 3000; i++)
			parkingLot.parkVehicle(new Vehicle("MH"+i, VehicleType.BIKE, false));
	}

	/**
	 * Test finding a parking spot by the vehicle.
	 *
	 * @throws ParkingSpotNotFoundException when the parking spot is not found.
	 * @throws ParkingException if the vehicle cannot be parked in a parking spot.
	 */
	@Test
	public void findParkingSpotVehicle() throws ParkingSpotNotFoundException, ParkingException {
		IVehicle vehicle = new Vehicle("MH1212", VehicleType.CAR, true);
		IParkingSpot parkingSpot = parkingLot.parkVehicle(vehicle);
		Assert.assertThat(parkingLot.findParkingSpot(vehicle), is(parkingSpot));
	}

	/**
	 * Test for finding a parking spot of an un-parked car.
	 *
	 * @throws ParkingSpotNotFoundException if the parking spot is not found.
	 */
	@Test(expected = ParkingSpotNotFoundException.class)
	public void findParkingSpotVehicleException() throws ParkingSpotNotFoundException {
		parkingLot.findParkingSpot(new Vehicle("MH1211", VehicleType.CAR, true));
	}

	/**
	 * Test finding a parking spot by its id.
	 *
	 * @throws ParkingSpotNotFoundException if the parking spot is not found.
	 */
	@Test
	public void findParkingSpotId() throws ParkingSpotNotFoundException {
		IParkingSpot parkingSpot = parkingLot.findParkingSpot(1);
		Assert.assertThat(parkingSpot.getId(), is(1));
	}

	/**
	 * Test for trying to find a parking spot with a non-existent id.
	 *
	 * @throws ParkingSpotNotFoundException if the parking spot is not found.
	 */
	@Test(expected = ParkingSpotNotFoundException.class)
	public void findParkingSpotIdException() throws ParkingSpotNotFoundException{
		parkingLot.findParkingSpot(1421);
	}
}

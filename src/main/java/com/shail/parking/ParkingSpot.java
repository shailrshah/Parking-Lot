package com.shail.parking;

import com.shail.parking.enums.Size;
import com.shail.parking.exceptions.ParkingException;
import com.shail.parking.interfaces.IParkingSpot;
import com.shail.parking.interfaces.IVehicle;

/**
 * A ParkingSpot represents a parking spot in the parking lot
 * @author Shail Shah
 */
public class ParkingSpot implements IParkingSpot {

	private final int id;
	private final Size size;
	private final boolean isForHandicap;
	private IVehicle currentVehicle;

	/**
	 * Constructor for creating a new ParkingSpot
	 *
	 * @param id the identifier of the parking spot
	 * @param size the biggest size of vehicle that can be fitted
	 * @param isForHandicap true if only to be used by people with handicap parking permits
	 */
	ParkingSpot(int id, Size size, boolean isForHandicap) {
		super();
		this.id = id;
		this.size = size;
		this.isForHandicap = isForHandicap;
		this.currentVehicle = null;
	}

	/**
	 * @return the id of this parking spot
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the maximum size of the vehicle that can be accommodated
	 */
	public Size getSize() {
		return size;
	}

	/**
	 * @return true if this parking spot is for cars with handicap parking permits only
	 */
	public boolean isForHandicap() {
		return isForHandicap;
	}

	/**
	 * @return the Vehicle that is currently parked in this parking spot
	 */
	public IVehicle getCurrentVehicle() {
		return currentVehicle;
	}

	/**
	 * @return true if no Vehicle is parked in this parking spot
	 */
	public boolean isVacant() {
		return currentVehicle == null;
	}

	/**
	 * Park a vehicle in this parking spot
	 * @param vehicle the vehicle to park
	 * @exception ParkingException when vehicle is not allowed to park here
	 */
	public void parkVehicle(IVehicle vehicle) throws ParkingException {
		if(!canPark(vehicle))
			throw new ParkingException("Cannot park here ");
		currentVehicle = vehicle;
	}

	/**
	 * Remove the currently parked vehicle from this parking spot,
	 * if it is present in this parking spot
	 */
	public void removeCurrentVehicle()  {
		currentVehicle = null;
	}

	/**
	 * Can a vehicle park here?
	 * @param vehicle a vehicle
	 * @return true if the vehicle can park here
	 */
	private boolean canPark(IVehicle vehicle) {
		return (!isForHandicap || vehicle.hasHandicapParkingPermit())
				&& vehicle.getSize().getVal() <= size.getVal();
	}

	/**
	 * Is the given object identical to this ParkingSpot?
	 *
	 * @param o an object
	 * @return true if the given object is identical to this ParkingSpot
	 */
	@Override
	public boolean equals(Object o) {
		return (o instanceof ParkingSpot)
				&& (((ParkingSpot) o).id == this.id);
	}

	/**
	 * @return the hashCode of this parking spot
	 */
	@Override
	public int hashCode() {
		return id;
	}
}

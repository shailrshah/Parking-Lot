package com.shail.parking;

/**
 * A ParkingSpot represents a parking spot in the parking lot
 * @author Shail Shah
 */
public class ParkingSpot implements IParkingSpot{

	private int id;
	private VehicleSize size;
	private boolean isForHandicap;
	private Vehicle currentVehicle;

	/**
	 * Constructor for creating a new ParkingSpot
	 * @param id the identifier of the parking spot
	 * @param size the biggest size of vehicle that can be fitted
	 * @param isForHandicap true if only to be used by people with handicap parking permits
	 */
	ParkingSpot(int id, VehicleSize size, boolean isForHandicap) {
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
	public VehicleSize getSize() {
		return size;
	}

	/**
	 * @return true if this parking spot is for cars with hadicap parking permits only
	 */
	public boolean isForHandicap() {
		return isForHandicap;
	}

	/**
	 * @return the com.shail.parking.Vehicle that is currently parked in this parking spot
	 */
	public Vehicle getCurrentVehicle() {
		return currentVehicle;
	}

	/**
	 * @return true if no com.shail.parking.Vehicle is parked in this parking spot
	 */
	public boolean isVacant() {
		return currentVehicle == null;
	}

	/**
	 * Park a vehicle in this parking spot
	 * @param vehicle the vehicle to park
	 */
	public void parkVehicle(Vehicle vehicle) {
		currentVehicle = vehicle;
	}

	/**
	 * Remove the currently parked vehicle from this parking spot
	 * @throws VehicleNotFoundException if there is no vehicle in this parking spot
	 */
	public void removeCurrentVehicle() throws VehicleNotFoundException {
		if(currentVehicle == null)
			throw new VehicleNotFoundException("There is no vehicle in this parking spot");
		currentVehicle = null;
	}
}

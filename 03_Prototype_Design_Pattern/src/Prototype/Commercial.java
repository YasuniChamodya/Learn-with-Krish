package Prototype;

public class Commercial extends Property{
	private int noOfUnits;
	private int parkingCapacity;
	private int seatingCapacity;
	
	// Getters
	public int getNoOfUnits() {
		return noOfUnits;
	}
	public int getParkingCapacity() {
		return parkingCapacity;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}	
	
	// Setters
	public void setNoOfUnits(int noOfUnits) {
		this.noOfUnits = noOfUnits;
	}
	public void setParkingCapacity(int parkingCapacity) {
		this.parkingCapacity = parkingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	@Override
	public String toString() {
		return "Commercial [noOfUnits=" + noOfUnits + ", parkingCapacity=" + parkingCapacity + ", seatingCapacity="
				+ seatingCapacity + "]";
	}
}


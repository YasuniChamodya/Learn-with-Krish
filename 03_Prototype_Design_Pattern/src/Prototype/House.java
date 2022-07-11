package Prototype;

public class House extends Property {
	
	private int noOfBedrooms;
	private int noOfBathrooms;
	
	// Getters
	public int getNoOfBedroms() {
		return noOfBedrooms;
	}
	public int getNoOfBathrooms() {
		return noOfBathrooms;
	}
	
	// Setters
	public void setNoOfBedroms(int noOfBedroms) {
		this.noOfBathrooms = noOfBedroms;
	}
	public void setNoOfBathrooms(int noOfBathrooms) {
		this.noOfBathrooms = noOfBathrooms;
	}
	@Override
	public String toString() {
		return "House [noOfBedrooms=" + noOfBedrooms + ", noOfBathrooms=" + noOfBathrooms + "]";
	}
}



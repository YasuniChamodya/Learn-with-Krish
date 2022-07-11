package Prototype;

public abstract class Property implements Cloneable {
	
	private double price;
	private String location;
	private int noOfFloors;
	private float landArea;
	
	// Getters
	public double getPrice() {
		return price;
	}
	public String getLocation() {
		return location;
	}
	public int getNoOfFloors() {
		return noOfFloors;
	}
	public float getLandArea() {
		return landArea;
	}
	
	// Setters
	public void setPrice(double price) {
		this.price = price;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setNoOfFloors(int noOfFloors) {
		this.noOfFloors = noOfFloors;
	}
	public void setLandArea(float landArea) {
		this.landArea = landArea;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}



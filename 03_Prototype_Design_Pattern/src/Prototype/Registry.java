package Prototype;

import java.util.Map;
import java.util.HashMap;

public class Registry {
	private Map<PropertyType, Property> properties = new HashMap<>();
	
	public Registry() {
		this.createInitialObjects();
	}

	// Initialize objects
	private void createInitialObjects() {
		House house = new House();
		house.setPrice(75000);
		house.setLocation("Colombo7");
		house.setNoOfFloors(2);
		house.setLandArea(20);
		house.setNoOfBedroms(4);
		house.setNoOfBathrooms(3);
		
		Commercial commertial = new Commercial();
		commertial.setPrice(500000);
		commertial.setLocation("Galle");
		commertial.setNoOfFloors(4);
		commertial.setLandArea(10);
		commertial.setNoOfUnits(12);
		commertial.setParkingCapacity(8);
		commertial.setSeatingCapacity(500);
		
		properties.put(PropertyType.HOUSE, house);
		properties.put(PropertyType.COMMERCIAL, commertial);
	}
	
	// Return cloned objects
	public Property getProperty(PropertyType propertyType) {
		Property property = null;
		try {
			property = (Property) properties.get(propertyType).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} 
		return property;
	}
}

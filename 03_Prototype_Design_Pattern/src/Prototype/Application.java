package Prototype;

public class Application {

	public static void main(String[] args) {
		Registry registry = new Registry();
		
		Commercial commertial = (Commercial) registry.getProperty(PropertyType.COMMERCIAL);
		System.out.println(commertial);
		
		commertial.setParkingCapacity(12);
		System.out.println(commertial);
		
	}
}



package factory;

public class PackageFactory {
	public static LearningPackage createPackage(Code code) {
		
		switch (code) {
			case COMPUTING:
				return new Computing();
			case BUSINESS:
				return new Business();
			case PROFESSIONAL:
				return new Professional();
			default:
				return null;
		}
	}
}



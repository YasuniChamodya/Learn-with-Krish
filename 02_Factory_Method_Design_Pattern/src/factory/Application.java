package factory;

public class Application {
	public static void main(String[] args) {
		
		LearningPackage package1 = PackageFactory.createPackage(Code.COMPUTING);
		System.out.println(package1);
		
		LearningPackage package2 = PackageFactory.createPackage(Code.BUSINESS);
		System.out.println(package2);
		
		LearningPackage package3 = PackageFactory.createPackage(Code.PROFESSIONAL);
		System.out.println(package3);
	}
}



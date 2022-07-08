package factory;

public class Business extends LearningPackage{

	@Override
	protected void createLearningPackage() {
		certificatePrograms.add(new CPMM());
		certificatePrograms.add(new CPDBF());
		certificatePrograms.add(new CPMO());
		certificatePrograms.add(new ECC());
		
	}

}




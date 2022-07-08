package factory;

public class Professional extends LearningPackage{

	@Override
	protected void createLearningPackage() {
		certificatePrograms.add(new CPMO());
		certificatePrograms.add(new ECC());
	}

}



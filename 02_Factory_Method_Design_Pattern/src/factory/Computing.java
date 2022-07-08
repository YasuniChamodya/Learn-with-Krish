package factory;

public class Computing extends LearningPackage {

	@Override
	protected void createLearningPackage() {
		certificatePrograms.add(new CPJP());
		certificatePrograms.add(new CPAD());
		certificatePrograms.add(new CPMO());
		certificatePrograms.add(new ECC());
	}

}



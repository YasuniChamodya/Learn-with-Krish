package factory;

import java.util.ArrayList;
import java.util.List;

public abstract class LearningPackage {
	
	protected List<CertificateProgram> certificatePrograms = new ArrayList<>();

	public LearningPackage() {
		createLearningPackage();
	}
	
	protected abstract void createLearningPackage();

	@Override
	public String toString() {
		return "LearningPackage [certificatePrograms=" + certificatePrograms + "]";
	}
	
}



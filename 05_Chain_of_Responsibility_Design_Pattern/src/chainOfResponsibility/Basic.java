package chainOfResponsibility;

public class Basic extends Handler {

	@Override
	public double calculateBill(Quota quota) {
		return successor.calculateBill(quota);
	}

}



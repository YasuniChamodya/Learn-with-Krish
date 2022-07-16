package chainOfResponsibility;

public class LastQuotaPack extends Handler {

	@Override
	public double calculateBill(Quota quota) {
		
		quota.setBillAmount(quota.getBasicPrice() + 6.0);
		System.out.println("Calculated bill for last 4GB");
		return quota.getBillAmount();
		
	}

}


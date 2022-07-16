package chainOfResponsibility;

public class FirstQuotaPack extends Handler {

	@Override
	public double calculateBill(Quota quota) {
		
		quota.setBillAmount(quota.getBasicPrice() + 3.0);
		System.out.println("Calculated bill for first 3GB");
		
		if ((quota.getUsedQuota()-quota.getBasicQuota()) <= 3)
			return quota.getBillAmount();
		else
			return successor.calculateBill(quota);
	}

}



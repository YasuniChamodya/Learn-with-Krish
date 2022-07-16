package chainOfResponsibility;

public class SecondQuotaPack extends Handler {

	@Override
	public double calculateBill(Quota quota) {
		
		quota.setBillAmount(quota.getBasicPrice() + 5.0);
		System.out.println("Calculated bill for second 3GB");
		
		if ((quota.getUsedQuota()-quota.getBasicQuota()) <= 6)
			return quota.getBillAmount();
		else
			return successor.calculateBill(quota);
	}

}



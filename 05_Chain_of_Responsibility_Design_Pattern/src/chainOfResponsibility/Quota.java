package chainOfResponsibility;

public class Quota {
	private int userId;
	private double basicQuota;
	private double usedQuota;
	private double basicPrice;
	private double billAmount;
	
	public Quota(int userId, double basicQuota, double usedQuota, double basicPrice) {
		this.userId = userId;
		this.basicQuota = basicQuota;
		this.usedQuota = usedQuota;
		this.basicPrice = basicPrice;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public double getBasicQuota() {
		return basicQuota;
	}
	
	public double getUsedQuota() {
		return usedQuota;
	}
	
	public double getBasicPrice() {
		return basicPrice;
	}
	
	public double getBillAmount() {
		return billAmount;
	}
		
}

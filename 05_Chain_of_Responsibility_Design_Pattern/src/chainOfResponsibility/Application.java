package chainOfResponsibility;

public class Application {

	public static void main(String[] args) {
		FirstQuotaPack firstQuotaPack = new FirstQuotaPack();
		SecondQuotaPack secondQuotaPack = new SecondQuotaPack();
		LastQuotaPack lastQuotaPack = new LastQuotaPack();
		
		Basic basic = new Basic();
		
		basic.setSuccessor(firstQuotaPack);
		firstQuotaPack.setSuccessor(secondQuotaPack);
		secondQuotaPack.setSuccessor(lastQuotaPack);
		
		Quota quota1 = new Quota(1, 10, 13, 5);
		System.out.println(basic.calculateBill(quota1));
		
		Quota quota2 = new Quota(1, 8, 14, 5);
		System.out.println(basic.calculateBill(quota2));
		
		Quota quota3 = new Quota(1, 12, 22, 5);
		System.out.println(basic.calculateBill(quota3));
	
	}
}



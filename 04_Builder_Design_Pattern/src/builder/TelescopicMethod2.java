package builder;

public class TelescopicMethod2 {

	String water, sugar, salt, orange, grapes, apple, lime;
	
	public TelescopicMethod2(String water, String sugar, String salt, String orange, String grapes, String apple, String lime) {
		this.water = water;
		this.sugar = sugar;
		this.salt = salt;
		this.orange = orange;
		this.grapes = grapes;
		this.apple = apple;
		this.lime = lime;
	}
	
	public TelescopicMethod2(String water, String sugar, String salt, String orange, String grapes, String apple) {
		this(water, sugar, salt, orange, grapes, apple, null);
	}
	
	public TelescopicMethod2(String water, String sugar, String salt, String orange, String grapes) {
		this(water, sugar, salt, orange, grapes, null);
	}
	
	public TelescopicMethod2(String water, String sugar, String salt, String orange) {
		this(water, sugar, salt, orange, null);
	}
	
	public TelescopicMethod2(String water, String sugar, String salt) {
		this(water, sugar, salt, null);
	}
	
	public TelescopicMethod2(String water, String sugar) {
		this(water, sugar, null);
	}
	
	public TelescopicMethod2(String water) {
		this(water, null);
	}

	@Override
	public String toString() {
		return "TelescopicMethod2 [water=" + water + ", sugar=" + sugar + ", salt=" + salt + ", orange=" + orange
				+ ", grapes=" + grapes + ", apple=" + apple + ", lime=" + lime + "]";
	}
}




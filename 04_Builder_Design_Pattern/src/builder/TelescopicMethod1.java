package builder;

public class TelescopicMethod1 {
	
	String water, sugar, salt, orange, grapes, apple, lime;
	
	public TelescopicMethod1(String water) {
		this.water = water;
	}
	
	public TelescopicMethod1(String water, String sugar) {
		this(water);
		this.sugar = sugar;
	}
	
	public TelescopicMethod1(String water, String sugar, String salt) {
		this(water, sugar);
		this.salt = salt;
	}
	
	public TelescopicMethod1(String water, String sugar, String salt, String orange) {
		this(water, sugar, salt);
		this.orange = orange;
	}	
	
	public TelescopicMethod1(String water, String sugar, String salt, String orange, String grapes) {
		this(water, sugar, salt, orange);
		this.grapes = grapes;
	}	

	public TelescopicMethod1(String water, String sugar, String salt, String orange, String grapes, String apple) {
		this(water, sugar, salt, orange, grapes);
		this.apple = apple;
	}	
	
	public TelescopicMethod1(String water, String sugar, String salt, String orange, String grapes, String apple, String lime) {
		this(water, sugar, salt, orange, grapes, apple);
		this.lime = lime;
	}

	@Override
	public String toString() {
		return "TelescopicMethod1 [water=" + water + ", sugar=" + sugar + ", salt=" + salt + ", orange=" + orange
				+ ", grapes=" + grapes + ", apple=" + apple + ", lime=" + lime + "]";
	}
}





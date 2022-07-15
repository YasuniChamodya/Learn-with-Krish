package builder;

public class Juice {

	final String water, sugar, salt, orange, grapes, apple, lime;
	
	public Juice(JuiceBuilder juiceBuilder) {
		this.water = juiceBuilder.water;
		this.sugar = juiceBuilder.sugar;
		this.salt = juiceBuilder.salt;
		this.orange = juiceBuilder.orange;
		this.grapes = juiceBuilder.grapes;
		this.apple = juiceBuilder.apple;
		this.lime = juiceBuilder.lime;
	}

	static class JuiceBuilder {
		String water, sugar, salt, orange, grapes, apple, lime;
		
		public JuiceBuilder(String water, String sugar, String salt) {
			this.water = water;
			this.sugar = sugar;
			this.salt = salt;
		}
		
		public JuiceBuilder orange (String orange) {
			this.orange = orange;
			return this;
		}
		
		public JuiceBuilder grapes (String grapes) {
			this.grapes = grapes;
			return this;
		}
		
		public JuiceBuilder apple (String apple) {
			this.apple = apple;
			return this;
		}
		
		public JuiceBuilder lime (String lime) {
			this.lime = lime;
			return this;
		}
		
		public Juice juiceBuild () {
			return new Juice (this);
		}
	}

	@Override
	public String toString() {
		return "Juice [water=" + water + ", sugar=" + sugar + ", salt=" + salt + ", orange=" + orange + ", grapes="
				+ grapes + ", apple=" + apple + ", lime=" + lime + "]";
	}
	
}




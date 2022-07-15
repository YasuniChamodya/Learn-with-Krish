package builder;

public class Application {

	public static void main(String[] args) {
		TelescopicMethod1 telescopic1 = new TelescopicMethod1("water");
		System.out.println(telescopic1);
		
		TelescopicMethod2 telescopic2 = new TelescopicMethod2("water");
		System.out.println(telescopic2);
		
		// Using builder pattern
		Juice.JuiceBuilder juiceBuilder = new Juice.JuiceBuilder("water","sugar","salt");
		Juice juice = juiceBuilder.orange("orange").lime("lime").juiceBuild();
		System.out.println(juice);
	}
}



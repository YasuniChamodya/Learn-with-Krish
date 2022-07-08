package singleton;

import java.sql.Connection;

public class Application {
	public static void main(String[] args) {
		
		long start, end;
		
		Printer printer1 = Printer.getPrinter();
		System.out.println(printer1);
		
		start = System.currentTimeMillis();
		Connection connection1 = printer1.getConnection();
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		Printer printer2 = Printer.getPrinter();
		System.out.println(printer2);
		
		start = System.currentTimeMillis();
		Connection connection2 = printer2.getConnection();
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		
	}
}

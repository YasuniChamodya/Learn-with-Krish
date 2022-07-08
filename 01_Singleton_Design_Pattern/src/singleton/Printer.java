package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Printer {
	//Printer variable
	private static volatile Printer printer;
	// Connection variable
	private static volatile Connection connection;
	
	// Private constructor to restrict creating instances from other classes
	private Printer() {
		
		// Block reflection frameworks
		if (printer != null) {
			throw new RuntimeException("Please use getPrinter");
		}
	}
	
	// Getter to return the printer instance
	public static Printer getPrinter () {
		if (printer == null) {
			// Acquire a lock to avoid multiple threads creating the instances
			synchronized (Printer.class) {
				// double-checking
				if (printer == null) {
					printer = new Printer();
				}
			}
		}
		return printer;
	}
	
	// Method to return the connection
	public Connection getConnection () {
		if (connection == null) {
			synchronized (Printer.class) {
				if (connection == null) {
					String url = "jdbc:derby:memory:printer;create=true";
					try {
						connection = DriverManager.getConnection(url);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return connection;
	}
} 

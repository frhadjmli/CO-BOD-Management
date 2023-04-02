package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
	
     Connection c = null;
	 
	 Statement st = null;
	
	  Database(){
		
		try {
			  Class.forName("org.postgresql.Driver");
			
			 c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBname",
			            "user", "password");
			
			System.out.println("connected successfully!");
			
			
		} catch (Exception e) {
			
			System.out.println("Error_1:" + e.getMessage());
		}
	}
	
	
	public void closeConnection() {
		
		try {
			
			c.close();
			
		} catch (Exception e) {
			
			
		
	  }

	}
}
package application;

import java.sql.Connection;
import java.sql.DriverManager;


public class PostgresqlAccess {
	
	
  public static final String HOST_URL = "jdbc:postgresql://localhost/dbName";
	
	   public static final String USER = "user";
	
	   public static final String PASSWORD = "password";
	
	
	   public static Connection connector() {
		
		try {
			
			return DriverManager.getConnection(HOST_URL, USER, PASSWORD);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

 }

package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	
	static Connection connection;
	
	
	public static Connection createC() {
		
		try {
			// step 1 : load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// step 2 : create the connection
			String rootString = "root";
			String passowrdString = "onepiece";
			String urlString = "jdbc:mysql://localhost:3306/mkp";
			
			
			connection = DriverManager.getConnection(urlString,rootString,passowrdString);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return connection;
		
	}
}

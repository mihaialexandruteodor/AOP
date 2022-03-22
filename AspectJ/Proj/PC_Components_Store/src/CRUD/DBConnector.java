package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector implements Runnable {
	
	public DBConnector() {
	
	 dbURL = "jdbc:mysql://localhost:3308/products";
	 username = "root";
	 password = "helloworld";
	}
	
	Connection conn;
	String dbURL;
	String username;
	String password;
	
	
	@Override
	public void run() {
		try {
			 
		    conn = DriverManager.getConnection(dbURL, username, password);
		 
		    if (conn != null) {
		        System.out.println("Connected");
		    }
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
	}
	
	public void disconnect()
	{
		try
		{
			conn.close();
			System.out.println("Disonnected");
		}
		catch (SQLException ex) {
		    ex.printStackTrace();
		}
	}

}

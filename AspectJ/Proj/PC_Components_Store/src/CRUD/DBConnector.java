package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Product;

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
	
	public void addProduct(Product product) throws SQLException
	{
		String sql = "INSERT INTO product (id, product_name, product_price, product_quantity) VALUES (?, ?, ?, ?)";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, Integer.toString(product.getId()));
		statement.setString(2, product.getProduct_name());
		statement.setString(3, Integer.toString(product.getProduct_price()));
		statement.setString(4, Integer.toString(product.getProduct_quantity()));
		
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("A new product was inserted successfully!");
		}
	}

}

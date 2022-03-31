package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Product;
import model.Shop;

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
	
	public int getNumberOfProducts() throws SQLException
	{
		String sql = "SELECT COUNT(*) AS prodCount FROM product";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet r = statement.executeQuery();
		r.next();
	    int result = r.getInt("prodCount");
		return result;
	}
	
	public int getNumberOfShops() throws SQLException
	{
		String sql = "SELECT COUNT(*) AS shopCount FROM shop";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet r = statement.executeQuery();
		r.next();
	    int result = r.getInt("shopCount");
		return result;
	}
	
	public int addProduct(Product product) throws SQLException
	{
		String sql = "INSERT INTO product (id, product_name, product_price, product_quantity) VALUES (?, ?, ?, ?)";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		Integer id = getNumberOfProducts()+1;
		statement.setString(1, Integer.toString(id));
		statement.setString(2, product.getProduct_name());
		statement.setString(3, Integer.toString(product.getProduct_price()));
		statement.setString(4, Integer.toString(product.getProduct_quantity()));
		
		return statement.executeUpdate();
		
	}
	
	public int addShop(Shop shop) throws SQLException
	{
		String sql = "INSERT INTO shop (id, shop_name) VALUES (?, ?)";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		Integer id = getNumberOfShops()+1;
		statement.setString(1, Integer.toString(id));
		statement.setString(2, shop.getShopName());

		
		return statement.executeUpdate();
		
	}
}

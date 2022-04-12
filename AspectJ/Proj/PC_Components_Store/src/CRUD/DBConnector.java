package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.Shop;
import utils.DataSingleton;

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
	
	public int getMaxIDProducts() throws SQLException
	{
		String sql = "SELECT MAX(id) AS MaxID FROM product";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet r = statement.executeQuery();
		r.next();
	    int result = r.getInt("MaxID");
		return result;
	}
	
	public List<Product> getProducts() throws SQLException
	{
		List<Product> products = new ArrayList<>();
		String sql = "SELECT * FROM product";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			Product pr = new Product();
			pr.setId(rs.getInt("id"));
			pr.setProduct_name(rs.getString("product_name"));
			pr.setProduct_price(rs.getInt("product_price"));
			pr.setProduct_quantity(rs.getInt("product_quantity"));
			products.add(pr);
			}
		
		return products;
	}
	
	public int getMaxIDShops() throws SQLException
	{
		String sql = "SELECT MAX(id) AS MaxID FROM shop";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet r = statement.executeQuery();
		r.next();
	    int result = r.getInt("MaxID");
		return result;
	}
	
	public Product addProduct(Product product) throws SQLException
	{
		String sql = "INSERT INTO product (id, product_name, product_price, product_quantity) VALUES (?, ?, ?, ?)";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		Integer id = getMaxIDProducts()+1;
		statement.setString(1, Integer.toString(id));
		statement.setString(2, product.getProduct_name());
		statement.setString(3, Integer.toString(product.getProduct_price()));
		statement.setString(4, Integer.toString(product.getProduct_quantity()));

		statement.executeUpdate();
		
		return product;
		
	}
	
	public Product updateProduct(Product product) throws SQLException
	{
		String sql = "UPDATE product SET product_name ='"+product.getProduct_name()
		+"', product_price="+product.getProduct_price()
		+", product_quantity="+Integer.toString(product.getProduct_quantity())
		+" WHERE id="+Integer.toString(product.getId());
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.executeUpdate();
		
		return product;
		
	}
	
	
	public int addShop(Shop shop) throws SQLException
	{
		String sql = "INSERT INTO shop (id, shop_name) VALUES (?, ?)";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		Integer id = getMaxIDShops()+1;
		statement.setString(1, Integer.toString(id));
		statement.setString(2, shop.getShopName());

		//DataSingleton.getInstance().get
		
		return statement.executeUpdate();
		
	}
	
	public Product removeProduct(Product product) throws SQLException
	{
		String sql = "DELETE FROM product WHERE id=" + product.getId();
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.executeUpdate();
		
		return product;
	}
}

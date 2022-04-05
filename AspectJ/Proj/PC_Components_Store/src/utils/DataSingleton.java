package utils;

import java.util.List;

import AOP.GuiController;
import CRUD.DBConnector;
import model.Product;

public class DataSingleton {
	private static DataSingleton single_instance = null;

	GuiController guiController;
	String connectionString;
	List<Product> products;
	DBConnector dbConn;
	Product currentProduct;
	

	private DataSingleton() {
		
		guiController = new GuiController();
		
	}

	public static DataSingleton getInstance() {
		if (single_instance == null)
			single_instance = new DataSingleton();

		return single_instance;
	}

	public GuiController getGuiController() {

		return guiController;
	}

	public void setGuiController(GuiController guiController) {
		this.guiController = guiController;
	}

	public void setProducts(List<Product> _products) {
		products = _products;
		
	}
	
	public List<Product> getProducts()
	{
		return products;
	}

	public void setDBConnection(DBConnector _dbConn) {
		dbConn = _dbConn;
		
	}
	
	public DBConnector getDBConnection()
	{
		return dbConn;
	}
	
	public void setCurrentProduct(Product _product)
	{
		currentProduct = _product;
	}
	
	public Product getCurrentProduct()
	{
		return currentProduct;
	}
	
}

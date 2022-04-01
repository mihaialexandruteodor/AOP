package utils;

import java.util.List;

import AOP.GuiController;
import model.Product;

public class DataSingleton {
	private static DataSingleton single_instance = null;

	GuiController guiController;
	String connectionString;
	List<Product> products;
	

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
}

package AOP;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	
	public Shop(String _shopName)
	{
		shopName = _shopName;
		products = new ArrayList<>();
	}
	
	public void addProductToShop(Product product)
	{
		products.add(product);
	}

	String shopName;
	List<Product> products;
}

package model;

import java.util.*;

public class Shop {

	private String shopName;
	private List<Product> products = new ArrayList<>();
	
	public void addProduct(Product product)
	{
		products.add(product);
	}
	
	public void removeProduct(Product product)
	{
		products.remove(product);
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
}

package aspects;

import CRUD.DBConnector;
import model.Shop;
import utils.DataSingleton;
import model.Product;

public aspect CRUDAspect {
	
	 pointcut callProductInserted(): call(* DBConnector.addProduct(Product));
	 
	 pointcut callProductUpdated(): call(* DBConnector.updateProduct(Product));
	 
	 pointcut callShopInserted(): call(* DBConnector.addShop(Shop));
	 
	 pointcut callProductRemoved(): call(* DBConnector.removeProduct(Product));

	 after() returning (Product product): callProductInserted() {
		System.out.println("A new product was inserted successfully!");
		DataSingleton.getInstance().getProducts().add(product);
	    }
	 
	 after() returning (Product product): callProductUpdated() {
			System.out.println("A product was updated successfully!");
		    }
	 

	 after() returning (Integer rowsInserted): callShopInserted() {
		 if(rowsInserted > 0)
			 System.out.println("A new shop was inserted successfully!");
	    }
	 
	 after() returning (Product product): callProductRemoved() {
		System.out.println("A product was removed successfully!");
		DataSingleton.getInstance().getProducts().remove(product);
	    }
}

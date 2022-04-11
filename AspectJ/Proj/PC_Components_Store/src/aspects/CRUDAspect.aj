package aspects;

import CRUD.DBConnector;
import model.Shop;
import utils.DataSingleton;
import model.Product;

public aspect CRUDAspect {
	
	 pointcut callProductInserted(): call(* DBConnector.addProduct(Product));
	 
	 pointcut callShopInserted(): call(* DBConnector.addShop(Shop));
	 
	 pointcut callProductRemoved(): call(* DBConnector.removeProduct(Product));

	 after() returning (Product product): callProductInserted() {
		// if(rowsInserted > 0)
			 System.out.println("A new product was inserted successfully!");
			 DataSingleton.getInstance().getProducts().add(product);
	    }
	 

	 after() returning (Integer rowsInserted): callShopInserted() {
		 if(rowsInserted > 0)
			 System.out.println("A new shop was inserted successfully!");
	    }
	 
	 after() returning (Integer rowsRemoved): callProductRemoved() {
		 if(rowsRemoved > 0)
			 System.out.println("A product was removed successfully!");
	    }
}

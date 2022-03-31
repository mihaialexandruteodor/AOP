package aspects;

import CRUD.DBConnector;
import model.Shop;
import model.Product;

public aspect CRUDAspect {
	
	 pointcut callProductInserted(): call(* DBConnector.addProduct(Product));
	 
	 pointcut callShopInserted(): call(* DBConnector.addShop(Shop));

	 after() returning (Integer rowsInserted): callProductInserted() {
		 if(rowsInserted > 0)
			 System.out.println("A new product was inserted successfully!");
	    }
	 

	 after() returning (Integer rowsInserted): callShopInserted() {
		 if(rowsInserted > 0)
			 System.out.println("A new shop was inserted successfully!");
	    }
}

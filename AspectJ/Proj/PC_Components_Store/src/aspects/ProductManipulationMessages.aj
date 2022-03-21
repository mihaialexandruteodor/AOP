package aspects;

import AOP.Product;

public aspect ProductManipulationMessages {
	 
	pointcut addedProduct() :
        execution(* addProductToShop(Product));
    
    after() : addedProduct()  {
        System.out.println("New Product added to the Shop!");
    }
}

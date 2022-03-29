package aspects;

import model.Shop;
import model.Product;

public aspect ConstructorCallMessage {

    before() :initialization(Shop.new(..)) {
        System.out.println("PC Components shop created!");
    }

    before() :initialization(Product.new(..)) {
        System.out.println("New Product created!");
    }




	    

}

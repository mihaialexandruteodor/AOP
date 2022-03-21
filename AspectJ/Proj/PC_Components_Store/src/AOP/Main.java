package AOP;

public class Main {

	public static void main(String[] args) {
		
		Shop shop = new Shop("Galaxy Components");
		Product product = new Product("Mac Studio");
		shop.addProductToShop(product);

	}

}

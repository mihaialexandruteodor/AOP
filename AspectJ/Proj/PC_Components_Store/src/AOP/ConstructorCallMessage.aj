package AOP;

public aspect ConstructorCallMessage {
	

    before() :initialization(Shop.new(..)) {
        System.out.println("PC Components shop created!");
    }



	    

}

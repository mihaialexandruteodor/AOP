package AOP;

public aspect ConstructorCallMessage {
	

	pointcut Anything() : 
        cflow(!within(ConstructorCallMessage)) && !within(ConstructorCallMessage);

    before() :initialization(Shop.new(..)) {
        System.out.println("PC Components shop created!");
    }



	    

}

package AOP;

import java.io.Serializable;

public aspect ProductManipulationMessages {
	 
	pointcut returnsSerializable() :
        execution((Serializable+ ||  byte || short || int || long || float || double || char || boolean || void || Product) *(Product)/*<-param type*/);

    pointcut hasNonSerializableArguments() :
        execution(* *(.., !(Serializable+  || byte || short || int || long || float || double || char || boolean || void || Product), Product));

    after() : returnsSerializable() && !hasNonSerializableArguments() {
        System.out.println("New Product added to the Shop!");
    }
}

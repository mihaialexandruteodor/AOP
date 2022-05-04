package com.unibuc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class InsertionChecks {

    @Pointcut("execution(* com.unibuc.service.ProductManager.createProduct(..))")
    public void createProductCall() {}

    @Pointcut("execution(* com.unibuc.service.ProductManager.updateProduct(..))")
    public void updateProductCall() {}

    @Around("createProductCall()")
    public Object checkBeforeInsertingProduct(ProceedingJoinPoint joinPoint) throws Throwable {
        for (Object prod : joinPoint.getArgs()) {
           if(prod == null)
               throw new RuntimeException("*** Cannot insert a null object!");
        }
        return joinPoint.proceed();
    }

    @Around("updateProductCall()")
    public Object checkBeforeUpdatingProduct(ProceedingJoinPoint joinPoint) throws Throwable {
        for (Object prod : joinPoint.getArgs()) {
            if(prod == null)
                throw new RuntimeException("*** Cannot update a null object!");
        }
        return joinPoint.proceed();
    }
}

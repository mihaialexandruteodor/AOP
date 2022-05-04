package com.unibuc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class InsertionChecks {

    @Pointcut("execution(* com.unibuc.service.ProductManager.createProduct(..))")
    public void createProductCall() {}

    @Pointcut("execution(* com.unibuc.service.ProductManager.updateProduct(..))")
    public void updateProductCall() {}

    @Pointcut("execution(* com.unibuc.service.ProductManager.deleteProduct(..))")
    public void deleteProductCall() {}

    @Pointcut("createProductCall() || updateProductCall() || deleteProductCall()")
    public void crudCall() {}

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

    @Around("deleteProductCall()")
    public Object checkBeforeDeletingProduct(ProceedingJoinPoint joinPoint) throws Throwable {
        for (Object prod : joinPoint.getArgs()) {
            if(prod == null)
                throw new RuntimeException("*** Cannot delete a null object!");
        }
        return joinPoint.proceed();
    }

    @After("crudCall()")
    public void crudCallCheckLog(JoinPoint joinPoint)
    {
        System.out.println("****LoggingAspect.crudCallLog() : " + joinPoint.getSignature().getName());
    }
}

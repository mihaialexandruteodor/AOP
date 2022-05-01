package com.unibuc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.unibuc.service.ProductManager.*(..))")
    public void logBeforeAllMethods(JoinPoint joinPoint)
    {
        System.out.println("****LoggingAspect.logBeforeAllMethods() : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.unibuc.service.ProductManager.getProductById(..))")
    public void logBeforeGetProduct(JoinPoint joinPoint)
    {
        System.out.println("****LoggingAspect.logBeforeGetProduct() : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.unibuc.service.ProductManager.createProduct(..))")
    public void logBeforeCreateProduct(JoinPoint joinPoint)
    {
        System.out.println("****LoggingAspect.logBeforeCreateProduct() : " + joinPoint.getSignature().getName());
    }
}
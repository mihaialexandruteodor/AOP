package com.unibuc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.unibuc.service.impl.EmployeeManagerImpl.*(..))")
    public void logBeforeAllMethods(JoinPoint joinPoint)
    {
        System.out.println("****LoggingAspect.logBeforeAllMethods() : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.unibuc.service.impl.EmployeeManagerImpl.getEmployeeById(..))")
    public void logBeforeGetEmployee(JoinPoint joinPoint)
    {
        System.out.println("****LoggingAspect.logBeforeGetEmployee() : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.unibuc.service.impl.EmployeeManagerImpl.createEmployee(..))")
    public void logBeforeCreateEmployee(JoinPoint joinPoint)
    {
        System.out.println("****LoggingAspect.logBeforeCreateEmployee() : " + joinPoint.getSignature().getName());
    }
}
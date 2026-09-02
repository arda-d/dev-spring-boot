package com.app.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    //this is where we add all our related advices for logging
    //@Before
    //@Before("execution(public void addAccount())")
    //@Before("execution(public void com.app.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(* com.app.aopdemo.dao.*.*(..))")
    @Pointcut("execution(* com.app.aopdemo.dao.*.*(..))")
    private void anyMethod() {}

    @Before("anyMethod()")
    public void beforeAddAccount() {
        System.out.println("\n=====> Executing @Before advice on addAccount()");
    }
}

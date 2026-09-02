package com.app.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(15)
public class BeforeAddAccount {

    @Before("com.app.aopdemo.aspect.AopExpression.anyMethodButGetAndSet()")
    public void beforeAddAccount() {
        System.out.println("\n=====> Executing @Before advice on addAccount()");
    }
}

package com.app.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class ApiAnalytics {

    @Before("com.app.aopdemo.aspect.AopExpression.anyMethodButGetAndSet()")
    public void performApiAnalytics()
    {
        System.out.println("\n=====> Peforming API Analytics");
    }
}

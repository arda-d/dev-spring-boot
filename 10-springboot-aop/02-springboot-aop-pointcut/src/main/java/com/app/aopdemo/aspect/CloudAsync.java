package com.app.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-10)
public class CloudAsync {

    @Before("com.app.aopdemo.aspect.AopExpression.anyMethodButGetAndSet()")
    public void logToCloudAsync() {
        System.out.println("\n=====> Logging Cloud Async");
    }
}

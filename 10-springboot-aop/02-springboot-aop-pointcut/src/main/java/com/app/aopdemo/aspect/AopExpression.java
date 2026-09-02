package com.app.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpression {
    @Pointcut("execution(* com.app.aopdemo.dao.*.*(..))")
    public void anyMethod() {}

    @Pointcut("execution(* com.app.aopdemo.dao.*.get*(..))")
    public void getMethod() {}

    @Pointcut("execution(* com.app.aopdemo.dao.*.set*(..))")
    public void setMethod() {}

    @Pointcut("anyMethod() && !(getMethod() || setMethod())")
    public void anyMethodButGetAndSet() {}
}

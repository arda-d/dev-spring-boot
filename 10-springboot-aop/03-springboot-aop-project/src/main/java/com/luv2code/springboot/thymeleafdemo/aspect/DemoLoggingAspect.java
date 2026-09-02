package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
    //setup logger
    private Logger logger = Logger.getLogger(this.getClass().getName());

    //setup pointcut
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forController() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDAO(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forService(){}


    @Pointcut("forController() ||forService() || forDAO()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        //display  method
        String method = joinPoint.getSignature().toShortString();
        logger.info("======> in @Before method: " + method);
        //display the arguments

        //get the arguments
        Object[] args = joinPoint.getArgs();
        //loop through and display
        for(Object arg : args){
            logger.info("======> Argument: " + arg);
        }
    }

    //add afterreturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result){
        //display method we are running
        String method = joinPoint.getSignature().toShortString();
        logger.info("======> in @AfterReturning method: " + method);
        //display data
        logger.info("======> result: " + result);
    }
}

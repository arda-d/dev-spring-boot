package com.app.aopdemo.aspect;

import com.app.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // Referencing a shared pointcut method declaration from AopExpression class
    @Before("com.app.aopdemo.aspect.AopExpression.anyMethodButGetAndSet()")
    public void perform(JoinPoint joinPoint) {
        System.out.println("\n =======> Executing @Before advice");

        // 1. Display method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // 2. Display method arguments
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            System.out.println("Arguments:");
            for (Object tempArg : args) {
                System.out.println("  -> " + tempArg);
            }
        } else {
            System.out.println("No arguments passed.");
        }
    }

    //add a new advice for @AfterReturning
    @AfterReturning(
            pointcut = "execution(* com.app.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, List<Account> result) {
        //print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=======> Executing @AfterReturning advice on method: " + method);
        //print out results of the method called
        System.out.println("\n=======> Result: " + result);

        //modify the data
        //convert the account name to uppercase
        convertAccountNamesToUppercase(result);
        System.out.println("\n=======> Result: " + result);
    }

    private void convertAccountNamesToUppercase(List<Account> result) {
        // loop through accounts
        for(Account tempAccount : result) {
            String upperName =  tempAccount.getName().toUpperCase();

            tempAccount.setName(upperName);
        }
        //get uppercase version of names

        //update the names
    }

    @AfterThrowing(
            pointcut = "execution(* com.app.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint,Throwable theExc) {
        //print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=======> Executing @AfterThrowing advice on method: " + method);
        //log the exception
        System.out.println("\n=======> Exception: " + theExc);

    }

    @After("execution(* com.app.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=======> Executing @After advice on method: " + method);
    }

    @Around("execution(* com.app.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
        //print out method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @Around advice on method: " + method);
        //get begin timestamp
        long start = System.currentTimeMillis();
        //execute method
        Object result = null;
        try {
            result = joinPoint.proceed();
        }catch (Exception e) {
            // log the exception
            System.out.println(e.getMessage());
            //give user a custom message
            throw e;
        }
        //get end timestamp
        long end = System.currentTimeMillis();
        //compute duration
        long executionTime = end - start;
        System.out.println("\n ========> Duration: " + executionTime/1000 + " s");
        return result;
    }
    }
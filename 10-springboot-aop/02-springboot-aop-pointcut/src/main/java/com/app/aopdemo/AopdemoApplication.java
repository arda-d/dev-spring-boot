package com.app.aopdemo;

import com.app.aopdemo.dao.AccountDAO;
import com.app.aopdemo.dao.MembershipDAO;
import com.app.aopdemo.dao.MembershipDAOImpl;
import com.app.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	private final MembershipDAOImpl membershipDAOImpl;

	public AopdemoApplication(MembershipDAOImpl membershipDAOImpl) {
		this.membershipDAOImpl = membershipDAOImpl;
	}

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService) {
		return runner->{
			//demoTheBeforeAdvice(accountDAO,membershipDAO);
			//demoTheAfterReturningAdvice(accountDAO);
			//demoTheAfterThrowingAdvice(accountDAO);
			//demoTheAfterAdvice(accountDAO);
			//demoTheAroundService(trafficFortuneService);

			demoTheAroundAdviceHandleException(trafficFortuneService);
		};
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortune()");
		boolean tripwire = true;
		String data = trafficFortuneService.getFortune(tripwire);
		System.out.println("My fortune: " + data);
		System.out.println("Finished");
	}

	private void demoTheAroundService(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		String data = trafficFortuneService.getFortune();
		System.out.println("My fortune: " + data);
		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		//call method to find accounts
		List<Account> accounts = accountDAO.findAccounts();
		try{
			//add boolean flag to stimulate exception
			boolean flag = false;
			accounts = accountDAO.findAccounts(flag);
		}catch(Exception e)
		{
			System.out.println("\nMain program: ... caught error.." + e);
		}
		//display accounts
		System.out.println("\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("----------------");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		//call method to find accounts
		List<Account> accounts = accountDAO.findAccounts();
		try{
			//add boolean flag to stimulate exception
			boolean flag = true;
			accounts = accountDAO.findAccounts(flag);
		}catch(Exception e)
		{
			System.out.println("\nMain program: ... caught error.." + e);
		}
		//display accounts
		System.out.println("\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("----------------");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		//call method to find accounts
		List<Account> accounts = accountDAO.findAccounts();
		//display accounts
		System.out.println("\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----------------");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO,MembershipDAO membershipDAO) {
		//call the business
		Account account = new Account();
		accountDAO.addAccount(account,true);
		accountDAO.doWork();
		System.out.println("\nCalling again\n");
		membershipDAOImpl.addAccount();
		membershipDAO.goToSleep();
		accountDAO.setName("Ali");
		accountDAO.setServiceCode("silver");
		String name = accountDAO.getName();
		String service = accountDAO.getServiceCode();
	}
}

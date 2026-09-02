package com.app.aopdemo.dao;

import com.app.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;
    @Override
    public void addAccount(Account account,boolean vipFlag) {
        System.out.println( getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public String getName() {
        System.out.println(getClass() + ": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()");
        this.name = name;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean flag) {

        List<Account> accounts = new ArrayList<>();
        Account account = new Account("Ali", "silverfish");
        Account account1 = new Account("Bob", "bobcut");
        Account account2 = new Account("John", "axolotl");
        accounts.add(account);
        accounts.add(account1);
        accounts.add(account2);
        return accounts;
    }
}

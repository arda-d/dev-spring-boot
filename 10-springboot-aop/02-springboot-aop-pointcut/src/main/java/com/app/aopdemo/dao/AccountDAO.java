package com.app.aopdemo.dao;

import com.app.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.List;


public interface AccountDAO {
    void addAccount(Account account,boolean vipFlag);

    boolean doWork();

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    public String getName();

    public void setName(String name);

    List<Account> findAccounts();

    List<Account> findAccounts(boolean flag);
}

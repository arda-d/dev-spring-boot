package com.app.aopdemo.dao;

import com.app.aopdemo.Account;
import org.springframework.stereotype.Component;


public interface AccountDAO {
    void addAccount(Account account,boolean vipFlag);
    boolean doWork();
}

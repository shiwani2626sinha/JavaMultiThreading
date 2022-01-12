package com.info.client;

import com.info.model.Account;
import com.info.worker.AccountHolder;

public class ClientTest {
    public static void main(String[] args){
        Account account = new Account();
        AccountHolder accountHolder = new AccountHolder(account);
        Thread t1 = new Thread(accountHolder);
        Thread t2 = new Thread(accountHolder);
        t1.setName("Alice");
        t2.setName("Jacob");

        t1.start();
        t2.start();
    }
}

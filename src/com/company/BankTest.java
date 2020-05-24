package com.company;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    Bank bank;
    static int accounts = 100000;
    static int threads = 100;
    static int transactions = 1000000;
    ExecutorService executorService = Executors.newFixedThreadPool(threads);

    @org.junit.jupiter.api.BeforeEach
    void setBank(){
        bank = new Bank("MONOBANK");
        for(int i = 0; i < accounts; i++){
            Account account = new Account("ACC" + i);
            account.makeDeposit((int)Math.random()*100000);
            bank.addAccount(account);

        }
    }
}
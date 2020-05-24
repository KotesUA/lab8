package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    Bank bank;
    static int accounts = 1000000;
    static int threads = 100;
    static int transactions = 1000000;
    ExecutorService executorService = Executors.newFixedThreadPool(threads);


    void setBank(){
        bank = new Bank("MONOBANK");
        for(int i = 0; i < accounts; i++){
            Account account = new Account("Acc" + i);
            account.makeDeposit(100 + (int) (Math.random() * 10000));
            bank.addAccount(account);
        }
    }

    @Test
    public ArrayList<Future> makeTransactions(){
        ArrayList<Future> futures = new ArrayList<>();
        for (int i = 0; i < transactions; i++){
            futures.add(executorService.submit(() -> bank.Transfer(
                    bank.getAccounts().get((int)(Math.random()*accounts)),
                    bank.getAccounts().get((int)(Math.random()*accounts)),
                    (int)(Math.random()*10000))));
        }
        return futures;
    }

    @Test
    void testBank() throws ExecutionException, InterruptedException {
        setBank();
        long startBalance = bank.getBankBalance();

        for (Future future: makeTransactions()){
            future.get();
        }
        
        long endBalance = bank.getBankBalance();
        System.out.println("Start bank balance: " + startBalance + "; end bank balance: " + endBalance);
        assertEquals(startBalance, endBalance);
    }
}
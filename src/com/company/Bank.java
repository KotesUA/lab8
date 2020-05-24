package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

public class Bank {
    //these are class fields
    private String Name;
    private ArrayList<Account> Accounts;
    private UUID ID;

    //this is class constructor
    public Bank(String name){
        this.Name = name;
        this.Accounts = new ArrayList<Account>();
        this.ID = UUID.randomUUID();
    }

    //these are getters for class fields
    public String getName(){return Name;}
    public ArrayList<Account> getAccounts(){return Accounts;}
    public UUID getID(){return ID;}

    //void for adding an account
    public void addAccount(Account account){
        Accounts.add(account);
    }

    //void to make transfer
    public void Transfer(Account to, Account from, int Sum){
        if (to.getID() != from.getID()){
            synchronized (to){
                synchronized (from){
                    if (from.makeWithdrawal(Sum)) to.makeDeposit(Sum);
                }
            }
            System.out.println("Transaction from " + from.getName() + " to " + to.getName() + " completed, sum: " + Sum);
        }
        else{
            System.out.println("It's the same account (" + from.getName() + ")!");
        }
    }

    //void to count total bank balance
    public int getBankBalance(){
        int balance = 0;
        for (Account account:Accounts
             ) {
            balance += account.getBalance();
        }
        return balance;
    }
}

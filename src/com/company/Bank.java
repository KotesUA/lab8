package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

public class Bank {
    private String Name;
    private ArrayList<Account> Accounts;
    private UUID ID;

    public Bank(String name){
        this.Name = name;
        this.Accounts = new ArrayList<Account>();
        this.ID = UUID.randomUUID();
    }

    public String getName(){return Name;}
    public ArrayList<Account> getAccounts(){return Accounts;}
    public UUID getID(){return ID;}

    public void addAccount(Account account){
        Accounts.add(account);
    }

    public void Transfer(Account to, Account from, int Sum){

    }
}

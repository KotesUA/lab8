package com.company;

import java.util.UUID;

public class Account {
    //class fields
    private String Name;
    private UUID ID;
    private int Balance;
    private boolean isLocked;

    //class constructor
    public Account(String name){
        this.Name = name;
        this.ID = UUID.randomUUID();
        this.Balance = 0;
        this.isLocked = false;
    }

    //these are getters for class fields
    public String getName(){return Name;}
    public int getBalance(){return Balance;}
    public UUID getID() {return ID;}

    //void for making deposit (add money)
    public boolean makeDeposit(int sum){
        Balance += sum;
        return true;
    }

    //void for making withdrawal
    public boolean makeWithdrawal(int sum){
        if (Balance >= sum){
            Balance -= sum;
            return true;
        }
        else{
            System.out.println("Not enough money in " + ID + " account!");
            return false;
        }
    }

    //override toString() to easy print account info
    @Override
    public String toString() {
        return "Account name: " + Name + "; account balance: " + Balance + ";";
    }
}

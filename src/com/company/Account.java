package com.company;

import java.util.UUID;

public class Account {
    private String Name;
    private UUID ID;
    private int Balance;
    private boolean isLocked;

    public Account(String name){
        this.Name = name;
        this.ID = UUID.randomUUID();
        this.Balance = 0;
        this.isLocked = false;
    }

    public String getName(){return Name;}
    public int getBalance(){return Balance;}
}

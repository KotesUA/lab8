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

    
}

package com.company;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("PrivatBank");
        Account acc1 = new Account("acc1");
        Account acc2 = new Account("acc2");

        acc1.makeDeposit(200);
        acc2.makeDeposit(300);

        bank.addAccount(acc1);
        bank.addAccount(acc2);

        bank.Transfer(acc2, acc1, 100);

        System.out.println(acc1);
        System.out.println(acc2);
    }
}

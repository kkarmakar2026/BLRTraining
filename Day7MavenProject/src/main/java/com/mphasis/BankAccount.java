package com.mphasis;

public class BankAccount {

    private double balance = 15000;

    public void withdraw(double amount) {
        synchronized (this) {
            if (amount > balance) {
                System.out.println(Thread.currentThread().getName() + " - insufficient balance");
            } else {
                System.out.println(Thread.currentThread().getName() + " withdrawing " + amount);
                balance = balance - amount;
                System.out.println("Remaining balance: " + balance);
            }
        }
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount();

        Runnable r = () -> {
            acc.withdraw(10000);
        };

        Thread t1 = new Thread(r, "user1");
        Thread t2 = new Thread(r, "user2");

        t1.start();
        t2.start();
    }
}

package com.mphasis;

public class App {
    public static void main(String[] args) {
        Payment p1 = new CreditCardPayment();
        p1.processPayment(1000);

        Payment p2 = new PayPalPayment();
        p2.processPayment(2000);

        Payment p3 = new UpiPayment();
        p3.processPayment(500);
    }
}

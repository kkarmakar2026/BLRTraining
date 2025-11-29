package com.mphasis;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }

    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    public int[] checkArrays() {
        return new int[]{1, 2, 3, 4, 5};
    }
    
    public ArithmeticException checkAE() {
        return new ArithmeticException("Division by zero occurred");
    }

}

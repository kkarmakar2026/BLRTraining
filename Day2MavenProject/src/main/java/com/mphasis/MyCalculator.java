package com.mphasis;

public class MyCalculator {

    public static void main(String[] args) {
        
        // Lambda expression implementing the add method
        Calculator cal = (a, b) ->  a + b;
        

        // Or even shorter: Calculator cal = (a, b) -> a + b;

        System.out.println("Sum: " + cal.add(4, 5));
    }
}

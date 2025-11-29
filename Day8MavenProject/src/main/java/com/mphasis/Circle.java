package com.mphasis;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle shape");
    }

    // Extra method for testing
    public double area(double radius) {
        return Math.PI * radius * radius;
    }
}

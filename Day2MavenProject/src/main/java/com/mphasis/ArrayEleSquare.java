package com.mphasis;

// Functional interface
@FunctionalInterface
interface ArraySquare {
    void numSquare();
}

public class ArrayEleSquare {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // Lambda expression implementing numSquare()
        ArraySquare ni = () -> {
            for (int num : arr) {
                System.out.println("Square of " + num + " = " + (num * num));
            }
        };

        // Call the method
        ni.numSquare();
    }
}

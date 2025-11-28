package com.mphasis;

import java.util.Arrays;
import java.util.function.Consumer;

public class DemoOnConsumer {

    public static void main(String[] args) {

        // Consumer that prints the square of a number
        Consumer<Integer> squareConsumer = (num1) -> {
            System.out.println("Square: " + (num1 * num1));
        };
        squareConsumer.accept(5);

        // Consumer that sorts an Integer array
        Consumer<Integer[]> sortConsumer = (arr) -> {
            Arrays.sort(arr);
            System.out.println("Sorted Array: " + Arrays.toString(arr));
        };

        Integer arr[] = {45, 23, 56, 42};
        sortConsumer.accept(arr);
    }
}

package com.mphasis;

import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 56, 23, 45};

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a key element to search:");
        int key = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                System.out.println("Element found at " + (i + 1) + "th position");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Element not found");
        }

        sc.close();
    }
}

package com.mphasis;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {23, 10, 15, 45, 62, 27, 9, 89, 13};
        int n = arr.length;

        // Insertion Sort
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        // Print sorted array
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

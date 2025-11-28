package com.mphasis;

public class SelectionSort {

    public static void main(String[] args) {
        int arr[] = {23, 10, 15, 45, 62, 27, 9, 89, 13};
        int n = arr.length;

        // Selection Sort
        for (int i = 0; i < n - 1; i++) {
            int mi = i; // assume current index is minimum
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[mi]) {
                    mi = j; // update minimum index
                }
            }
            // swap arr[i] and arr[mi]
            int temp = arr[i];
            arr[i] = arr[mi];
            arr[mi] = temp;
        }

        // Print sorted array
        System.out.println("Sorted array:");
        for (int k = 0; k < n; k++) {
            System.out.print(arr[k] + " ");
        }
    }
}

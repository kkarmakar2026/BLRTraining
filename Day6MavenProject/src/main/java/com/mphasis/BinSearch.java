package com.mphasis;

public class BinSearch {
	public static void main(String[] args) {
		
	

	int arr[] = {10, 20, 30, 40, 50, 60, 70, 80, 90};
	
	int low = 0;
	int high = arr.length - 1;
	int key = 70;

	while (low <= high) {
	    int mid = (low + high) / 2;

	    if (arr[mid] == key) {
	        System.out.println("The key is found at " + (mid + 1) + "th position");
	        break;
	    } else if (arr[mid] > key) {
	        high = mid - 1;  // move left
	    } else {
	        low = mid + 1;  // move right
	    }
	}
	}
}

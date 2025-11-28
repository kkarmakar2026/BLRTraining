package com.mphasis;

import java.util.function.Function;

public class DemoOnFunction {

	public static void main(String[] args) {
		
		Function<Integer,Integer> squareFunction=(num) -> (num*num);
		int arr []= {3,2,5,7,6};
		for(int i =0; i<arr.length;i++) {
			System.out.println(squareFunction.apply(arr[i]));
		}
	}
	
}

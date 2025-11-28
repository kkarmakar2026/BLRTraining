package com.mphasis;

interface ReverseAString {
	
	public void stringReverse(String str);

}

public  class ReverseString{
	public static void main(String a[] ){
		
		ReverseAString string =(String s)->{
			System.out.println(new StringBuffer(s).reverse().toString());
			
		};
		string.stringReverse("Koushik");
	}
}

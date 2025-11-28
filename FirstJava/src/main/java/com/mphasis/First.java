package com.mphasis;
import java.util.Scanner;

public class First {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner (System.in);
    	String phno = sc.next();
        
        if (phno.length() == 10 && 
            (phno.charAt(0) == '6' || phno.charAt(0) == '7' || 
             phno.charAt(0) == '8' || phno.charAt(0) == '9')) {
            
            System.out.println("Valid Number");
        } else {
            System.out.println("Invalid Number");
        }
    }
}

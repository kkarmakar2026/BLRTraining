package com.mphasis;
import java.util.Scanner;

public class First2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input two numbers
        System.out.print("Enter two numbers: ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        // Input operator
        System.out.print("Enter a valid operator (+, -, *, /): ");
        char op = sc.next().charAt(0);

        int result = 0;

        // Switch-case for operator
        switch(op) {
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            case '/':
                if (n2 != 0) {
                    result = n1 / n2;
                } else {
                    System.out.println("Division by zero is not allowed!");
                    return; // exit program
                }
                break;
            default:
                System.out.println("Invalid operator!");
                return; // exit program
        }

        // Print result
        System.out.println("Result: " + result);

        sc.close();
    }
}

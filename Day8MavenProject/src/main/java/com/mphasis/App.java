package com.mphasis;

/**
 * Hello world!
 */
public class App {
	
	public  String sayHello() {
		return "Hello";
	}
	
	public String checkText() {
		String str = "Koushik";
		return str;
	
	}
	
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        App app = new App();
        app.sayHello();
    }
}

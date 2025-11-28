package com.mphasis;

import java.util.function.Supplier;

public class DemoOnObjectMethodReference {

    public static void main(String[] args) {
        
        String myname = "Koushik Karmakar";
        Supplier<Integer> lengthUsingLambda = () -> myname.length();
        Supplier<Integer> lengthUsingMR = myname::length;
        
        System.out.println(lengthUsingLambda.get());
        System.out.println(lengthUsingMR.get());
        
        Hello h = new Hello();
        Supplier<String> helloUsingLambda = () -> h.sayHello();
        Supplier<String> helloUsingMR = h::sayHello;
        
        System.out.println(helloUsingLambda.get());
        System.out.println(helloUsingMR.get());
    }
    
    static class Hello {
        public String sayHello() {
            return "hello .....";
        }
    }
}

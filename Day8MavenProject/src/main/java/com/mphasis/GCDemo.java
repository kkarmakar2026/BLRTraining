package com.mphasis;

public class GCDemo {
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test = null; 

        System.out.println("GC requested manually");
        System.gc();

        
        Runtime.getRuntime().gc();
    }
}

class Test {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Test memory destroyed");
    }
}

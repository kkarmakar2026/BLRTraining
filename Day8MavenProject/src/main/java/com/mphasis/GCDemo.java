package com.mphasis;

public class GCDemo {
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test = null; // remove reference

        System.out.println("GC requested manually");
        System.gc();

//        Thread.sleep(1000); // give GC some time
//        System.out.println("completed");
        
        Runtime.getRuntime().gc();
    }
}

class Test {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Test memory destroyed");
    }
}

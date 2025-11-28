package com.mphasis;

public class ThreadExtendsThread extends Thread {

    @Override
    public void run() {
        System.out.println(getName() + " is running");
    }

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println("Main Thread Details:");
        System.out.println("Name: " + mainThread.getName());
        System.out.println("Id: " + mainThread.getId());
        System.out.println("Priority: " + mainThread.getPriority());
        System.out.println("State: " + mainThread.getState());
        System.out.println("Alive: " + mainThread.isAlive());
        System.out.println("Daemon: " + mainThread.isDaemon());

        ThreadExtendsThread t1 = new ThreadExtendsThread();
        t1.setName("Thread-1");

        ThreadExtendsThread t2 = new ThreadExtendsThread();
        t2.setName("Thread-2");

        ThreadExtendsThread t3 = new ThreadExtendsThread();
        t3.setName("Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}

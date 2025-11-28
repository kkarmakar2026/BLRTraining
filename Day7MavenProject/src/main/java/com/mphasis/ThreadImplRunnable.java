package com.mphasis;

public class ThreadImplRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("thread1 is running");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        Thread thread = Thread.currentThread();
        System.out.println("Name: " + thread.getName());
        System.out.println("Id: " + thread.getId());
        System.out.println("Priority: " + thread.getPriority());
        System.out.println("State: " + thread.getState());
        System.out.println("Alive: " + thread.isAlive());
        System.out.println("Daemon: " + thread.isDaemon());
        System.out.println("Interrupted: " + thread.isInterrupted());

        Thread t1 = new Thread(new ThreadImplRunnable(),"thread1");
        System.out.println("New Thread Name: " + t1.getName());
        System.out.println("New Thread Id: " + t1.getId());

        t1.start();
    }
}

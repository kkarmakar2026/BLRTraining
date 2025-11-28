package com.mphasis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChefES implements Runnable {

    private String order;

    public ChefES(String order) {
        this.order = order;
    }

    @Override
    public void run() {
        System.out.println("Chef is preparing: " + order);
        try {
            Thread.sleep(1000); // simulate cooking time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Chef finished: " + order);
    }

    public static void main(String[] args) {
        ExecutorService manager = Executors.newFixedThreadPool(4);

        String[] menu = {"biriyani", "chicken 65", "fish curry", "paneer fry", "fried rice"};
        for (String item : menu) {
            ChefES chefThread = new ChefES(item);
            manager.submit(chefThread);
        }
        manager.shutdown();
    }
}

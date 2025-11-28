package com.mphasis;

// Custom resource class that implements AutoCloseable
public class MyResource implements AutoCloseable {

    // Constructor
    public MyResource() {
        System.out.println("Resource created");
    }

    // Method to simulate using the resource
    public void useResource() {
        System.out.println("Using resource...");
    }

    // Overriding close() method from AutoCloseable
    @Override
    public void close() throws Exception {
        System.out.println("Resource closed successfully");
    }

    // Main method to test try-with-resources
    public static void main(String[] args) {
        // try-with-resources automatically calls close() at the end
        try (MyResource resource = new MyResource()) {
            resource.useResource();
            System.out.println("Inside try block");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("Program finished");
    }
}

package com.mphasis;

public class CircularQueue {

    private static int front = -1;
    private static int rear = -1;
    private static int[] cq = new int[10]; // fixed size queue

    // Check if queue is empty
    public static boolean isEmpty() {
        return front == -1;
    }

    // Check if queue is full
    public static boolean isFull() {
        return (rear + 1) % cq.length == front;
    }

    // Insert element into circular queue
    public static void insert(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }

        if (front == -1) { // first insertion
            front = 0;
            rear = 0;
            cq[rear] = data;
        } else {
            rear = (rear + 1) % cq.length;
            cq[rear] = data;
        }
        System.out.println(data + " inserted successfully");
    }

    // Delete element from circular queue
    public static void delete() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println(cq[front] + " deleted successfully");

        if (front == rear) { // only one element left
            front = rear = -1;
        } else {
            front = (front + 1) % cq.length;
        }
    }

    // Peek at the front element
    public static void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front element: " + cq[front]);
        }
    }

    // Display all elements in the queue
    public static void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(cq[i] + " ");
            if (i == rear) break;
            i = (i + 1) % cq.length;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        insert(10);
        insert(20);
        insert(30);
        display();   // prints 10 20 30
        peek();      // prints 10

        delete();    // removes 10
        display();   // prints 20 30

        insert(40);
        insert(50);
        display();   // prints 20 30 40 50

        delete();    // removes 20
        display();   // prints 30 40 50
    }
}

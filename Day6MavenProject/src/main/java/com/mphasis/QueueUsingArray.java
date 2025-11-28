package com.mphasis;

import java.util.Scanner;

public class QueueUsingArray {

    private static int[] queue = new int[10];
    private static int front = -1;
    private static int rear = -1;

    // Check if queue is empty
    public static boolean isEmpty() {
        return (front == -1 || front > rear);
    }

    // Check if queue is full
    public static boolean isFull() {
        return rear == queue.length - 1;
    }

    // Insert element into queue
    public static void insert(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow");
        } else if (rear == -1) { // first element
            front = 0;
            queue[++rear] = data;
        } else {
            queue[++rear] = data;
        }
    }

    // Remove element from queue
    public static int pop() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        } else {
            int element = queue[front++];
            return element;
        }
    }

    // Peek at the front element
    public static void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front element: " + queue[front]);
        }
    }

    // Display all elements in the queue
    public static void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue elements:");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    // Main method to test
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        insert(10);
        insert(20);
        insert(30);
        display();   // prints 10 20 30
        peek();      // prints 10

        System.out.println("Popped: " + pop()); // removes 10
        display();   // prints 20 30

        System.out.println("Popped: " + pop()); // removes 20
        display();   // prints 30

        sc.close();
    }
}

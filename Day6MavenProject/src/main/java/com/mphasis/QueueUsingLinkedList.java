package com.mphasis;

public class QueueUsingLinkedList {

	private static int [] queue = new int [10];
	private static int front = -1;
	private static int rear = -1;
	
	public static void isEmpty() {
		if(front == -1 || front>rear)
			System.out.println("Queue Underflow");
	}
	
	public static void isFull() {
		if(rear==queue.length-1)
			System.out.println("Queue Workflow");
	}
	
//	public static void insert(int data) {
//		Node element = 
//	}
}

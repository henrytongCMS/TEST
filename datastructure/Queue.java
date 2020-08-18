package com.datastructure;

import java.util.OptionalDouble;

public class Queue {
	
	private int rear = 0;
	private int front = 0;
	private int queueNo = 0;	
	private int capacity;
	private double [] queue;

	public Queue(int capacity) {	
		this.capacity = capacity;
		queue = new double[this.capacity];
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void enQueue(double data) {
		
		if ( queueNo < capacity ) {
			rear = (rear+1) % capacity;	
			queue[rear] = data;
			queueNo ++;
			System.out.printf("[INFO] Data add to queue: %.2f%n", data);
		} else {
			System.out.println("[INFO] Queue is full");
		}
		
	}
	
	public OptionalDouble deQueue() {
		
		double data;
		
		if ( queueNo > 0 ) {
			front = (front+1) % capacity;
			data = queue[front];
			queueNo --;
			System.out.printf("[INFO] Data delete from queue: %.2f%n", data);
		} else {
			System.out.println("[INFO] Queue is empty");
			return OptionalDouble.empty();
		}
		
		return OptionalDouble.of(data);

	}
	
	public void printQueue() {
		
		System.out.print("[INFO] Queue: ");
		for (int i = 1; i <= queueNo; i++) {
			System.out.printf("%.2f  ", queue[(front+i) % capacity]);
		}
		System.out.println();
		
	}

}


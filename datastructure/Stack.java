package com.datastructure;

import java.util.OptionalDouble;

public class Stack {
	
	private int top = -1;
	private int capacity;
	private double [] stack;

	public Stack(int capacity) {	
		this.capacity = capacity;
		stack = new double[this.capacity];
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void push(double data) {
		
		if( top < capacity - 1 ) {
			top ++;
			stack[top] = data;
			System.out.printf("[INFO] Data push to stack: %.2f%n", data);
		} else {
			System.out.println("[INFO] Stack is full");
		}

	}
	
	public OptionalDouble pop() {
		
		double data;
		
		if (top > -1) {
			data = stack[top];
			top --;
			System.out.printf("[INFO] Data pop from stack: %.2f%n", data);
		} else {
			System.out.println("[INFO] Stack is empty");
			return OptionalDouble.empty();
		}
		
		return OptionalDouble.of(data);
		
	}
	
	public void printSatck() {
		
		System.out.print("[INFO] Stack: ");
		for (int i = 0; i <= top; i++) {
			System.out.printf("%.2f  ", stack[i]);
		}
		System.out.println();
		
	}

}

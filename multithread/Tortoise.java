package com.multithread;

public class Tortoise implements Runnable {

	private int totalStep;
	private int step;

	public Tortoise(int totalStep) {
		this.totalStep = totalStep;
	}

	@Override
	public void run() {
		while (step < totalStep) {
			step++;
			System.out.printf("Tortoise run %d step...%n", step);
		}
	}
	
}
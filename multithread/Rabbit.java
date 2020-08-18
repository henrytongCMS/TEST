package com.multithread;

public class Rabbit implements Runnable {

	private int totalStep;
	private int step;

	public Rabbit(int totalStep) {
		this.totalStep = totalStep;
	}

	@Override
	public void run() {
		while (step < totalStep) {
			if (new Random().nextBoolean()) {
				System.out.println("Rabbit is slepping...");
			} else {
				step += 2;
				System.out.printf("Rabbit run %d step...%n", step);
			}
		}
	}

}

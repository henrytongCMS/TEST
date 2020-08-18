package com.multithread;

public class Race {

	public static void main(String[] args) {

		Tortoise tortoise = new Tortoise(100);
		Rabbit rabbit = new Rabbit(100);

		Thread tortoiseThread = new Thread(tortoise);
		Thread rabbitThread = new Thread(rabbit);

		tortoiseThread.start();
		rabbitThread.start();

	}

}

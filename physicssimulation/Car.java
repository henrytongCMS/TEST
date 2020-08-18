package com.physicssimulation;

public class Car {

	private double acceleration;
	private double velocity;
	private double position;

	Car() {
		this.acceleration = 0;
		this.velocity = 0;
		this.position = 0;
	}

	public void run(double acc, double maxV) {

		this.acceleration = acc;
		double dt = 0;

		while (dt <= 50) {
			if (this.velocity > maxV)
				this.acceleration = 0.0;
			this.velocity = this.velocity + this.acceleration * dt;
			this.position = this.velocity * dt + 0.5 * this.acceleration * dt * dt;
			System.out.printf("time=%.1fs, position=%.1fm, velocity=%.1fm/s%n", dt, this.position, this.velocity);
			dt += 1;
		}

	}

}
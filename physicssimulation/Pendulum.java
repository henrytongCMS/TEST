package com.physicssimulation;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Pendulum extends JPanel {

	final double g = 9.834;
	final int offset = 150;

	private double size;
	private double length;
	private double theta_0;
	private double dt;
	private double x;
	private double y;

	public Pendulum(double size, double length, double theta_0, double dt) {

		this.size = size;
		this.length = length;
		this.theta_0 = theta_0;
		this.dt = dt;

	}

	public void swing(double decay) throws InterruptedException {

		double time = 0.0;

		while (true) {

			double theta = theta_0 * Math.cos(Math.sqrt(g / length) * time);

			x = length * Math.sin(theta) + offset;
			y = length * Math.cos(theta) + offset;

			repaint();
			System.out.printf("[x, y] = [%.3f, %.3f]%n", x, y);
			Thread.sleep(1);

			time += dt;

		}

	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		g.fillOval((int) x, (int) y, (int) size, (int) size);

	}

}

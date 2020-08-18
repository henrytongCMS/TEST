package com.physicssimulation;

import javax.swing.JFrame;

public class OscillatorRun {
	
	public static void main(String[] args) throws InterruptedException {
	
		double k = 0.50; // spring constant
		double q = 0.01; // decay constant
		double b = 0.01; // non-linearity constant
		double m = 1.00; // mass
		double f = 10.0; // external force
		double w = 1.00; // angular frequency
		double x = 50.0; // initial position x
		double v = 0.00; // initial velocity
		double t = 0.00; // initial time
		double h = 0.01; // RK4 step
		
		Oscillator oscillator = new Oscillator(k, q, b, m, f, w, x, v, t, h);
	
		JFrame frame = new JFrame();
		frame.add(oscillator);
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while( oscillator.getRkT() < 10000 ) {
			oscillator.rk4();
			oscillator.repaint();
			Thread.sleep(1);
		}

	}

}

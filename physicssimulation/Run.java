package com.physicssimulation;

import javax.swing.*;

public class Run  {
    
	public static void main(String[] args) throws InterruptedException {

		Ball ball = new Ball(10, 10, 100, 15, 0, 0.1);
//		Pendulum pendulum = new Pendulum(10, 100, 0.5, 0.01);

		JFrame frame = new JFrame();

		frame.add(ball);
//		frame.add(pendulum);
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ball.bounch(0.005);
//		pendulum.swing(0.);

	}

}
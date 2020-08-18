package com.bounceball;

import java.awt.EventQueue;

import javax.swing.*;

public class Run {

	public static void main(String[] args) {
		new Run();
	}

	public Run() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame();
				Balls balls = new Balls();
				frame.add(balls);
				frame.setSize(400, 400);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				new Thread(new Bounce(balls)).start();
			}
		});
	}

}
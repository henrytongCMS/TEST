package com.physicssimulation;

import javax.swing.JFrame;

public class RandomWalkRun {

	public static void main(String[] args) throws InterruptedException {

		RandomWalk rw = new RandomWalk();
		
		JFrame frame = new JFrame();
		frame.add(rw);
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while( rw.getSteps() < 100000 ) {
			rw.randomWalk();
			rw.repaint();
			Thread.sleep(2);
		}

	}

}

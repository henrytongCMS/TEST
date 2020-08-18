package com.physicssimulation;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RandomWalk extends JPanel {
	
	private final int offset = 300;
	private final int step = 1;
	private int rwx = 0;
	private int rwy = 0;
	
	private int steps = 0;

	public int getSteps() {
		return steps;
	}

	public void randomWalk() {
		
		Random rand = new Random();
		
		double random = rand.nextDouble();
			
		if( random >= 0.00 && random < 0.25 ) {
			rwx += step;
		} else if ( random >= 0.25 && random < 0.50 ) {
			rwy += step;
		} else if ( random >= 0.5 && random < 0.75 ) {
			rwx -= step;
		} else if ( random >= 0.75 && random < 1.00 ){
			rwy -= step;
		}	
		
		steps ++;
		
		System.out.printf("[INFO] step=%d, x=%d, y=%d%n", steps, rwx, rwy);
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.fillOval(rwx+offset, rwy+offset, 2, 2);
	}
	
}

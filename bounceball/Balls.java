package com.bounceball;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Balls extends JPanel {

	private List<Ball> balls;

	public Balls() {
		balls = new ArrayList<Ball>();
		balls.add(new Ball(10, 10, 100, 20, 0, 0.1));
		balls.add(new Ball(10, 20, 80, 15, 0, 0.1));
		balls.add(new Ball(10, 30, 60, 10, 0, 0.1));
		balls.add(new Ball(10, 40, 40, 5, 0, 0.1));
	}
	
	public List<Ball> getBalls() {
		return balls;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (Ball ball : balls) {
			ball.paint(g2d);
		}
		g2d.dispose();
	}

}
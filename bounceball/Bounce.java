package com.bounceball;

import javax.swing.SwingUtilities;

public class Bounce implements Runnable {

	private Balls balls;

	public Bounce(Balls balls) {
		this.balls = balls;
	}

	public Balls getBalls() {
		return balls;
	}

	@Override
	public void run() {
		while (getBalls().isVisible()) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					getBalls().repaint();
				}
			});
			for (Ball ball : getBalls().getBalls()) {
				try {
					bounce(ball);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void bounce(Ball ball) throws InterruptedException {

		double g = 9.834;

		double r = ball.getR();
		double x = ball.getX();
		double y = ball.getY();
		double dx = ball.getDx();
		double dy = ball.getDy();
		double dt = ball.getDt();

		x += dx * dt;
		y += dy * dt + 0.5 * g * dt * dt;

		dy += g * dt;

		if (x + r >= 350 || x - r <= 0)
			dx = -dx;

		if (y + r >= 350)
			dy = -dy;

		ball.setX(x);
		ball.setY(y);
		ball.setDx(dx);
		ball.setDy(dy);
		ball.setDt(dt);

	}

}
package com.bounceball;

import java.awt.*;

public class Ball {

	private double r;
	private double x;
	private double y;
	private double dx;
	private double dy;
	private double dt;

	/**
	 * Class constructor
	 * 
	 * @param r  radius
	 * @param x  position x
	 * @param y  position y
	 * @param dx velocity x
	 * @param dy velocity y
	 * @param dt time-step
	 */
	public Ball(double r, double x, double y, double dx, double dy, double dt) {

		this.r = r;
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.dt = dt;

	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public double getDt() {
		return dt;
	}

	public void setDt(double dt) {
		this.dt = dt;
	}

	protected void paint(Graphics2D g2d) {
		g2d.fillOval((int) x, (int) y, (int) r, (int) r);
	}

}
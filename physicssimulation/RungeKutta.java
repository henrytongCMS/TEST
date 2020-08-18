package com.physicssimulation;

import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class RungeKutta extends JPanel {
	
	private int i = 0;
	private int offset = 200;
	private double h, x, v, t;
	
	public RungeKutta(double h, double x, double v, double t) {
		this.h = h;
		this.x = x;
		this.v = v;
		this.t = t;
	}

	public double getRkH() {
		return h;
	}

	public void setRkH(double h) {
		this.h = h;
	}

	public double getRkX() {
		return x;
	}

	public void setRkX(double x) {
		this.x = x;
	}

	public double getRkV() {
		return v;
	}

	public void setRkV(double v) {
		this.v = v;
	}

	public double getRkT() {
		return t;
	}

	public void setRkT(double t) {
		this.t = t;
	}

	public void rk4() {
		
		double k1x, k2x, k3x, k4x;
		double k1v, k2v, k3v, k4v;
	
		k1x = f1(t, x, v);
		k1v = f2(t, x, v);
		
		k2x = f1(t+h/2, x+h*k1x/2, v+h*k1v/2);
		k2v = f2(t+h/2, x+h*k1x/2, v+h*k1v/2);
		
		k3x = f1(t+h/2, x+h*k2x/2, v+h*k2v/2);
		k3v = f2(t+h/2, x+h*k2x/2, v+h*k2v/2);
		
		k4x = f1(t+h, x+h*k3x, v+h*k3v);
		k4v = f2(t+h, x+h*k3x, v+h*k3v);
		
		x += (h/6.)*(k1x + 2*k2x + 2*k3x + k4x);
		v += (h/6.)*(k1v + 2*k2v + 2*k3v + k4v);
		
		t += h;
		i ++;
		
		System.out.printf("[INFO] i=%d, t=%.2f, x=%.3f, v=%.3f%n", i, t, x, v);

	}
	
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		g.fillOval((int)x+offset, offset-50, 10, 10);
		
	}
	
	/**
	 * 
	 * @param t time
	 * @param x position
	 * @param v velocity
	 * @return dx/dt
	 */
	public abstract double f1(double t, double x, double v);
	
	/**
	 * 
	 * @param t time
	 * @param x position
	 * @param v velocity
	 * @return dv/dt
	 */
	public abstract double f2(double t, double x, double v);

}

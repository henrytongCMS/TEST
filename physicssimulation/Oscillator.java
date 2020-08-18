package com.physicssimulation;

@SuppressWarnings("serial")
public class Oscillator extends RungeKutta {
	
	private double k, q, b, m, f, w;
	
	/**
	 * Class constructor
	 * 
	 * @param k spring constant
	 * @param q decay constant
	 * @param b non-linearity constant
	 * @param m mass
	 * @param f external force
	 * @param w angular frequency
	 * @param x initial position x
	 * @param v initial velocity
	 * @param t initial time
	 * @param h RK4 step
	 */
	public Oscillator(double k, double q, double b, double m, double f, double w, double x, double v, double t, double h) {
		super(h, x, v, t);
		this.k = k;
		this.q = q;
		this.b = b;
		this.m = m;
		this.f = f;
		this.w = w;
	}

	public double getK() {
		return k;
	}

	public void setK(double k) {
		this.k = k;
	}
	
	public double getQ() {
		return q;
	}

	public void setQ(double q) {
		this.q = q;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getM() {
		return m;
	}

	public void setM(double m) {
		this.m = m;
	}

	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	@Override
	public double f1(double t, double x, double v) {
		return v;
	}
	
	@Override
	public double f2(double t, double x, double v) {
		return -k/m*x -q/m*v -b*x*x*x +f*Math.cos(w*t);
	}

}

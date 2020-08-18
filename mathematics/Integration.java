package com.mathematics;

public abstract class Integration {

	// To integrate function from a to b with nPoints

	private int nPoints = 10000;

	public double integrationByMidPointRule(double a, double b) {

		double dth = (b - a) / nPoints;
		double output = 0;

		for (int i = 0; i < nPoints; i++) {
			output += function(a + (0.5 + i) * dth);
		}

		return output * dth;

	}

	public double integrationByTrapzoidalRule(double a, double b) {

		double dth = (b - a) / (nPoints - 1);
		double output = 0;

		for (int i = 0; i < nPoints - 1; i++) {
			output += function(a + i * dth);
		}

		return output * dth;

	}

	public abstract double function(double x);

}

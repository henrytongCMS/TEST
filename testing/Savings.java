package com.testing;

import java.util.Calendar;

public class Savings {

	public static void main(String[] args) {
		double save = 50000;
		double target = 200000 - save;
		double income = 49000;
		double outcome = 25000;
		double month = savings(target, income, outcome);
		System.out.printf("target left: %.0f%n", target);
		System.out.printf("%.0f months or %.2f years%n", month, month / 12);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, (int) month);
		System.out.println(calendar.getTime());
	}

	private static double savings(double target, double income, double outcome) {
		double month = 0;
		double result = 0;
		while (result < target) {
			result += income - outcome;
			month++;
		}
		return month;
	}

}

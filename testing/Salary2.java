package com.testing;

public class Salary2 {

	public static void main(String[] args) {
		double yearSalary = 700000;
		double increment = 1.025;
		double year = 20;
		result(yearSalary, increment, year);
	}

	private static void result(double yearSalary, double increment, double year) {
		double monthSalary;
		double sum = 0;
		for (int i = 1; i <= year; i++) {
			yearSalary *= increment;
			monthSalary = yearSalary / 14;
			sum += yearSalary;
			System.out.printf("year %d, year=%.0f, month=%.0f, sum=%.0f%n", i, yearSalary, monthSalary, sum);
		}
	}

}

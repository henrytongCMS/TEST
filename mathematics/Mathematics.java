package com.mathematics;

import java.util.Arrays;

public class Mathematics {

	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	public int[][] randomBinaryMatrix(int size) {
		int[][] binaryMatrix = new int[size][size];
		for (int i = 0; i < binaryMatrix.length; i++)
			for (int j = 0; j < binaryMatrix[i].length; j++)
				binaryMatrix[i][j] = (int) Math.round(Math.random());
		System.out.println(Arrays.deepToString(binaryMatrix).replace("],", "]\n").replace("[[", " [").replace("]]", "]"));
		return binaryMatrix;
	}

	public int[][] transpose(int[][] matrix) {
		int[][] transpose = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				transpose[i][j] = matrix[j][i];
		return transpose;
	}

	public int powerOfTwo(int power) {
		return 1 << power;
	}

	public int abs(int number) {
		return number < 0 ? -number : number;
	}

	public int factorial(double number) {
		int output = 1;
		for (int i = 1; i <= number; i++) {
			output *= i;
		}
		return output;
	}

	public double circumferencesOfEllipse(double longAx, double shortAx) {
		double h = (longAx - shortAx) * (longAx - shortAx) / (longAx + shortAx) / (longAx + shortAx);
		double seriesSum = 1 + (h / 4);
		for (int i = 2; i < 10; i++) {
			seriesSum += Math.pow(h, i) / Math.pow(4, i + 1);
		}
		return Math.PI * (longAx + shortAx) * seriesSum;
	}

	public double[] quadraticEquation(double a, double b, double c) {
		double[] roots = new double[2];
		if (a == 0) {
			if (b != 0) {
				System.out.println("[INFO] Linear equation, single root.");
				roots[0] = -c / b;
			} else {
				System.out.println("[INFO] Invalid parameters. Both A and B are zero.");
			}
		} else {
			double discriminant = b * b - 4 * a * c;
			if (discriminant < 0) {
				System.out.println("[INFO] Complex conjugate roots.");
				roots[0] = -b / (2 * a);
				roots[1] = Math.sqrt(-discriminant) / (2 * a);
			} else {
				System.out.println("[INFO] Real roots.");
				roots[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
				roots[1] = (-b - Math.sqrt(discriminant)) / (2 * a);
			}
		}
		return roots;
	}

}

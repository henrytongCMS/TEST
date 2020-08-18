package com.mathematics;

public class Run {

	public static void main(String[] args) {

//		Integration ig = new Integration() {
//			@Override
//			public double function(double x) {
//				return (2 * Math.sin(x) + 1) / (x + 5) / (x + 5);
//			}
//		};
//
//		double mpRule = ig.integrationByMidPointRule(0, 13);
//		double tpRule = ig.integrationByTrapzoidalRule(0, 13);
//
//		System.out.printf("[INFO] mpRule=%f, tpRule=%f%n", mpRule, tpRule);

//		for (int i = 0; i < 10; i++) {
//			new Mathematics().randomBinaryMatrix(10);
//			System.out.println();
//		}

		int a = 1;
		int b = 2;

		System.out.printf("a=%d, b=%d%n", a, b);

		Mathematics.swap(a, b);

		System.out.printf("a=%d, b=%d%n", a, b);

	}

}

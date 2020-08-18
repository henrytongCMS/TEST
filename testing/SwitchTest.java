package com.testing;

public class SwitchTest {

	public static void main(String[] args) {

		switchCaseTest(0);
		switchCaseTest(1);
		switchCaseTest(2);

	}

	private static void switchCaseTest(int key) {
		switch (key) {
		case 0:
		case 1:
			System.out.println("case");
			break;
		default:
			System.out.println("default");
			break;
		}
	}

}

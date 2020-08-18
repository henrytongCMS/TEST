package com.testing;

import java.text.NumberFormat;

public class KOZcalculator {

	public static void main(String[] args) {
		listRating();
	}

	private static void listRating() {
		final double TWD_rate = 30.38; // twd bought rate was 31.763
		final double USD_BUY = 32000;
		final double KOZ = 46660;
		double KOZ_rate = 0.3;
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(true);
		while (true) {
			double USD = KOZ * KOZ_rate - USD_BUY;
			double TWD = USD * TWD_rate;
			System.out.printf("KOZrate=%.2f\t USD=%s\t TWD=%s%n", KOZ_rate, nf.format((int) USD), nf.format((int) TWD));
			KOZ_rate += 0.01;
			if (USD > 1000000) {
				break;
			}
		}
	}

}

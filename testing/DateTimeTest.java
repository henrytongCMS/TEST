package com.testing;

import java.util.Date;

public class DateTimeTest {

	public static void main(String[] args) {

		Date now = new Date();

		System.out.println(now);
		System.out.println(now.getTime() + " ms since 1/1/1970 00:00:00 GMT");

		double minutes = 60;

		Date later = new Date((long) (now.getTime() + minutes * 60 * 1000));

		System.out.println(later);

	}

}

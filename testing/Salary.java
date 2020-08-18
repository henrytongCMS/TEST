package com.testing;

//import java.io.BufferedWriter;
//import java.io.FileWriter;
import java.io.IOException;

public class Salary {
	public static void main(String[] args) throws IOException {
//		BufferedWriter writer = new BufferedWriter(new FileWriter("./output.txt"));
		double yearSalary = 1000000.;
		double monthSalary;
		while (true) {
			monthSalary = yearSalary / 14.;
			String str = String.format("year salary = %.0f, month salary = %.0f%n", yearSalary, monthSalary);
//			System.out.println("[INFO] Write to file...");
//			writer.write(str);
			System.out.print(str);
			yearSalary -= 20000;
			if (monthSalary < 40000)
				break;
		}
//		writer.close();
//		System.out.println("[INFO] Done!");
	}	
}
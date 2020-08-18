package com.physicssimulation;

import java.math.BigDecimal;
import java.math.MathContext;

public class PiGenerator {
	
	public static void PiByMonteCarlo() {

		long inside = 0;
		long total = 0;
		
		BigDecimal pi;
		
		while( total < 1000000L ) {
			
			if( Math.sqrt(Math.pow(Math.random(),2) + Math.pow(Math.random(),2)) <= 1.0 )
				inside++;
			
			total++;
			
			pi = new BigDecimal( 4.0 * inside / total, MathContext.UNLIMITED);
			
			if( total % 100000 == 0 )
				System.out.printf("[INFO] iteration: %d; pi = %.20f%n", total, pi);
			 
		}
		
	}

}

package com.testing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestNull {

	public static void main(String[] args) {

		List<String> strings = new ArrayList<String>();

		strings.add("hello");
		strings.add("hi");
		strings.add("welcome");
		strings.add("dummy");

		Iterator<String> iterator = strings.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		for(String s : strings) {
			System.out.println(s);
		}
		
		strings.forEach(s -> {
			System.out.println(s.toUpperCase());
		});
		
		strings.clear();
		
		System.out.println(strings.size());
		
	}

}

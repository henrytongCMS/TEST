package com.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayListLambdaTest {

	public static void main(String[] args) {

		List<String> dicts = new ArrayList<String>();

		dicts.add("Arthur");
		dicts.add("Alan");
		dicts.add("Benjamin");
		dicts.add("Bobby");
		dicts.add("Charlie");
		dicts.add("David");
		dicts.add("Dexter");
		dicts.add("Evan");
		dicts.add("Finley");

		List<String> names = new ArrayList<String>();

		names.add("Alan");
		names.add("Bob");
		names.add("Charlie");
		names.add("Duke");
		names.add("Evan");
		names.add("Finley");

		List<String> filterList = names.stream().filter(name -> {
			for (String dict : dicts) {
				if (dict.equals(name))
					return true;
			}
			return false;
		}).collect(Collectors.toList());

		System.out.println(Arrays.toString(filterList.toArray()));

		// ------------------------------------------------------------

		List<Person> person = new ArrayList<Person>();

		person.add(new Person("Alan", 54));
		person.add(new Person("Bob", 12));
		person.add(new Person("Charlie", 23));
		person.add(new Person("Duke", 47));

		person.forEach(p -> {
			p.setAge(p.getAge() + 10);
		});

		System.out.println(Arrays.toString(person.toArray()));

		person = person.stream().sorted(Comparator.comparing(Person::getAge, (d1, d2) -> {
			return d1.compareTo(d2);
		})).collect(Collectors.toList());

		System.out.println(Arrays.toString(person.toArray()));

		// ------------------------------------------------------------

		Integer a = 2;
		Integer b = 3;
		Integer c = 3;

		System.out.println(a.compareTo(b));
		System.out.println(b.compareTo(a));
		System.out.println(b.compareTo(c));
		
		// ------------------------------------------------------------
		
		Map<String, List<Person>> map = new HashMap<String, List<Person>>();
		map.put("A", person);
		map.put("B", person);
		map.put("C", person);
		
		String key = "B";
		System.out.println(map.get(key));
		map.get(key).add(new Person("Zara", 10));
		System.out.println(map.get(key));
		
	}

	public static class Person {

		private String name;
		private int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getAge() {
			return age;
		}

		@Override
		public String toString() {
			return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
		}

	}

}

package com.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListAdjust {

	public static void main(String[] args) {

		Inventory in1 = new Inventory();
		in1.setId("A");
		in1.setQuantity(20);

		Inventory in2 = new Inventory();
		in2.setId("B");
		in2.setQuantity(40);

		Inventory in3 = new Inventory();
		in3.setId("C");
		in3.setQuantity(30);

		Inventory in4 = new Inventory();
		in4.setId("A");
		in4.setQuantity(50);

		Inventory in5 = new Inventory();
		in5.setId("B");
		in5.setQuantity(10);

		Inventory in6 = new Inventory();
		in6.setId("D");
		in6.setQuantity(10);

		List<Inventory> inventories = new ArrayList<Inventory>();
		inventories.add(in1);
		inventories.add(in2);
		inventories.add(in3);

		List<Inventory> anotherInventories = new ArrayList<Inventory>();
		anotherInventories.add(in4);
		anotherInventories.add(in5);
		anotherInventories.add(in6);
		
		inventories.forEach(inv -> System.out.println(inv.getId() + "\t" + inv.getQuantity()));
		anotherInventories.forEach(inv -> System.out.println(inv.getId() + "\t" + inv.getQuantity()));
		System.out.println("-------------------");

		// update exist
		inventories = inventories.stream().map(inv -> {
			return anotherInventories.stream().filter(ano -> inv.getId().equals(ano.getId())).findFirst().orElse(inv);
		}).collect(Collectors.toList());
		
		// add new
		inventories = Stream.concat(inventories.stream(), anotherInventories.stream()).distinct().collect(Collectors.toList());

		inventories.forEach(inv -> System.out.println(inv.getId() + "\t" + inv.getQuantity()));

	}

	public static class Inventory {

		private String id;
		private double quantity;
		private String name;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public double getQuantity() {
			return quantity;
		}

		public void setQuantity(double quantity) {
			this.quantity = quantity;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

}

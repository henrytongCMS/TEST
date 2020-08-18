package com.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupSum {

	public static void main(String[] args) {

		Inventory in1 = new Inventory();
		in1.setId("A");
		in1.setQuantity(20);

		Inventory in2 = new Inventory();
		in2.setId("B");
		in2.setQuantity(40);

		Inventory in3 = new Inventory();
		in3.setId("A");
		in3.setQuantity(30);

		Inventory in4 = new Inventory();
		in4.setId("A");
		in4.setQuantity(50);

		Inventory in5 = new Inventory();
		in5.setId("B");
		in5.setQuantity(10);
		
		Inventory in6 = new Inventory();
		in6.setId("C");
		in6.setQuantity(10);

		List<Inventory> inventories = new ArrayList<Inventory>();
		inventories.add(in1);
		inventories.add(in2);
		inventories.add(in3);
		
		List<Inventory> anotherInventories = new ArrayList<Inventory>();
		anotherInventories.add(in4);
		anotherInventories.add(in5);
		anotherInventories.add(in6);
		
		inventories.addAll(anotherInventories);

		Map<String, Double> map = inventories.stream().collect(Collectors.groupingBy(inv -> inv.getId(), Collectors.summingDouble(inv -> inv.getQuantity())));

		map.forEach((id, sum) -> System.out.println(id + "\t" + sum));
		
	}

	public static class Inventory {

		private String id;
		private double quantity;

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

	}


}

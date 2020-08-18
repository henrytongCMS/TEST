package com.testing;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class JSONTest {

	public static void main(String[] args) {

		Parent parent = new Parent();

		Child child1 = new Child();
		child1.setParent(parent);

		Child child2 = new Child();
		child2.setParent(parent);

		List<Child> childs = new ArrayList<Child>();
		childs.add(child1);
		childs.add(child2);

		parent.setChilds(childs);
		
		JSONObject result = new JSONObject();
		result.put("data", childs); // stack over flow error here

		System.out.println(result.get("data"));

	}

	public static class Parent {

		private List<Child> childs;

		public List<Child> getChilds() {
			return childs;
		}

		public void setChilds(List<Child> childs) {
			this.childs = childs;
		}

	}

	public static class Child {

		private Parent parent;

		public Parent getParent() {
			return parent;
		}

		public void setParent(Parent parent) {
			this.parent = parent;
		}

	}
}

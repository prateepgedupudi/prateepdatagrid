package com.prateep.util;

public class Item {
	private int id;
	private String item;
	private int quantity;
	private int cost;
	private int total;
public Item(int id, String item, int quantity, int cost) {
		this.id = id;
		this.item = item;
		this.quantity = quantity;
		this.cost = cost;
		this.total=this.quantity * this.cost;
	}


}

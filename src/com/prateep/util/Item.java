package com.prateep.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Item {
	Logger logger = LoggerFactory.getLogger(Item.class);
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

/**
 * @return the id
 */
public int getId() {
	logger.debug("Item:getId: Debug");
	logger.error("Item:getId: Error");
	logger.info("Item:getId: Info");
	logger.trace("Item:getId: Trace");
	logger.warn("Item:getId: Warn");
	return id;
}

/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}

/**
 * @return the item
 */
public String getItem() {
	return item;
}

/**
 * @param item the item to set
 */
public void setItem(String item) {
	this.item = item;
}

/**
 * @return the quantity
 */
public int getQuantity() {
	return quantity;
}

/**
 * @param quantity the quantity to set
 */
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

/**
 * @return the cost
 */
public int getCost() {
	return cost;
}

/**
 * @param cost the cost to set
 */
public void setCost(int cost) {
	this.cost = cost;
}

/**
 * @return the total
 */
public int getTotal() {
	return total;
}

/**
 * @param total the total to set
 */
public void setTotal(int total) {
	this.total = total;
}





}

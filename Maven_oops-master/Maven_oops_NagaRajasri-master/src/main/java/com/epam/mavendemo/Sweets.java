package com.epam.mavendemo;

public class Sweets implements NewYearGift{
	public int weight;
	public int price;
	public Sweets(int weight, int price) {
		super();
		this.weight = weight;
		this.price = price;
	}
	public int getWeight() {
		return weight;
	}
	public int getPrice() {
		return price;
	}
	public void weight(int weight) {
		this.weight = weight;
	}
	public void setPrice(int sweetPrice) {
		this.price = sweetPrice;
	}
	

}

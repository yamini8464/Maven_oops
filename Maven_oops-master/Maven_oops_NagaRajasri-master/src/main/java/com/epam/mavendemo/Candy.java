package com.epam.mavendemo;

public class Candy extends Choclate implements NewYearGift{
	public String name;

	public Candy(int price, int weight, String name) {
		super(price, weight);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}

package com.epam.mavendemo;

public class Wafer extends Choclate{
	public String name;

	public Wafer(int price, int weight, String name) {
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

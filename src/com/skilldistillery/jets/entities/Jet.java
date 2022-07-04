package com.skilldistillery.jets.entities;

public abstract class Jet {
//getsimplename    instance of
	private String model;
	private int speed;
	private int range;
	private double price;

	public void fly() {

	}

	public Jet(String model, int speed, int range, double price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	@Override
	public String toString() {
		return "[Model: " + model + ", Speed in mph: " + speed + ", Range in miles: " + range + ", Price: " + price
				+ "]";
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}

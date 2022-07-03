package com.skilldistillery.jets.entities;

public class Passenger extends Jet{

	public Passenger(String model, int speed, int range, double price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public String toString() {
//		return "Passenger [toString()=" + super.toString() + ", getModel()=" + getModel() + ", getSpeed()=" + getSpeed()
//				+ ", getRange()=" + getRange() + ", getPrice()=" + getPrice() + ", getClass()=" + getClass()
//				+ ", hashCode()=" + hashCode() + "]";
//	}

	@Override
	public void fly() {
		System.out.println( "Model: " + getModel() + ", Speed: "
				+ getSpeed() + ", Range: " + getRange() + ", Price: " + getPrice());
		System.out.println("Time until fuel is out: " + (getRange()/getSpeed())+ " hours");
		System.out.println();
	}

	
}

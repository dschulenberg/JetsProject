package com.skilldistillery.jets.entities;

public class CargoJet extends Jet implements CargoLoad {

	public CargoJet(String model, int speed, int range, double price) {
		super(model, speed, range, price);
	}

	public void fly() {
		System.out.println("Model: " + getModel() + ", Speedin mph: " + getSpeed() + ", Range in miles: " + getRange()
				+ ", Price: " + getPrice());
		System.out.println("Time until fuel is out: " + (getRange() / getSpeed()) + " hours");
		System.out.println();
	}

	@Override
	public void loadCargo() {
		System.out.println("Loading CargoJet: " + getModel() + ". Please Hold wait for tansfer.");
	}

}

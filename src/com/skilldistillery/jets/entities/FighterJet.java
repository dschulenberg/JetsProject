package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, int speed, int range, double price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.println("Model: " + getModel() + ", Speed in mph: " + getSpeed() + ", Range in miles: " + getRange()
				+ ", Price: " + getPrice());
		System.out.println("Time until fuel is out: " + (getRange() / getSpeed()) + " hours");
		System.out.println();
	}

	@Override
	public void fight() {
		System.out.println("Combat iniatiated for:" + getModel() + "!" + " Pew Pew!");

	}

}

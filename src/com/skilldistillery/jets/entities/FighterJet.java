package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, int speed, int range, double price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	
//	@Override
//	public String toString() {
//		return "FighterJet [toString()=" + super.toString() + ", getModel()=" + getModel() + ", getSpeed()="
//				+ getSpeed() + ", getRange()=" + getRange() + ", getPrice()=" + getPrice() + ", getClass()="
//				+ getClass() + ", hashCode()=" + hashCode() + "]";
//	}


	@Override
	public void fly() {
		System.out.println( "Model: " + getModel() + ", Speed: "
				+ getSpeed() + ", Range: " + getRange() + ", Price: " + getPrice());
		System.out.println("Time until fuel is out: " + (getRange()/getSpeed())+ " hours");
		System.out.println();
	}

	@Override
	public void fight() {
		System.out.println("Combat iniatiated for:" +getModel() + "!" + " Pew Pew!");
		
	}

}

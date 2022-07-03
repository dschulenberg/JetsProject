package com.skilldistillery.jets.entities;

public class CargoJet extends Jet implements CargoLoad {

	public CargoJet(String model, int speed, int range, double price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}
	
//	@Override
//	public String toString() {
//		return "CargoJet [toString()=" + super.toString() + ", getModel()=" + getModel() + ", getSpeed()=" + getSpeed()
//				+ ", getRange()=" + getRange() + ", getPrice()=" + getPrice() + ", getClass()=" + getClass()
//				+ ", hashCode()=" + hashCode() + "]";
//	}


	public void fly() {
		System.out.println( "Model: " + getModel() + ", Speed: "
				+ getSpeed() + ", Range: " + getRange() + ", Price: " + getPrice());
		System.out.println("Time until fuel is out: " + (getRange()/getSpeed())+ " hours");
		System.out.println();
	}

	@Override
	public void loadCargo() {
		System.out.println("Loading CargoJet: " + getModel() + ". Please Hold wait for tansfer.");
	}

}

package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {
	public List<Jet> getFleet() {
		return createFleet(fleet);
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}

	private List<Jet> fleet =new ArrayList<>();
	
	public List<Jet> createFleet(List<Jet> fleet){
	   try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
	        String line;
	        while ((line = bufIn.readLine()) != null) {
	          String[] jetRecord = line.split(",");
	          String type = jetRecord[0];
	          String model = jetRecord[1];
	          int speed = Integer.parseInt(jetRecord[2]);
	          int range = Integer.parseInt(jetRecord[3]);
	          double price = Double.parseDouble(jetRecord[4]);
	          if(type.equals("cargo")) {
	        	  Jet c = new CargoJet(model, speed,range,price);
	        	 fleet.add(c);
	        	  
	          }
	          if(type.equals("fighter")) {
	        	  Jet f = new FighterJet(model, speed,range,price);
	        	  fleet.add(f);
	          }
	          if(type.equals("passenger")) {
	          Jet p = new Passenger(model, speed,range,price);
	          fleet.add(p);
	          }
	          
	        }
	      }
	      catch (IOException e) {
	        System.err.println(e);
	      } 
	   return fleet;
	}
	public void launch() {
		getFleet();
	}
	public void listFleet() {
		
		for (Jet each : fleet) {
			System.out.println(each);
		}

	}
	public void removeJet() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to remove by 'number' or 'model'?");  //User must type in the string number or model.
		System.out.println();
		String userInput = scan.nextLine();
		if(userInput.equals("number")) {
			System.out.println("Which jet would you like to remove by number?");
			System.out.println();
		for (Jet each : fleet) {
			System.out.println("Number: " + fleet.indexOf(each) + " "+each);
		}
		int numRemoved = scan.nextInt();
		fleet.remove(numRemoved);
		}
		if(userInput.equals("model")) {
			System.out.println("Which jet would you like to remove by Model?");
			System.out.println();
			for (Jet each : fleet) {
				System.out.println("Number: " + fleet.indexOf(each) + " "+each);
			}
		String modRemoved = scan.nextLine();
		int index = 0;
		for (Jet each : fleet) {
			if(each.getModel().equals(modRemoved)) {
				break;
			}
			index++;
		}
		fleet.remove(index);
		}
		
		scan.close();
	}
	
	public void addJet() {
		char p = '\u2708';
		boolean start = true;
		Jet newJet = null;
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the model of your Jet.");
		String model = scan.nextLine();

		System.out.println("Enter the speed of your Jet.");
		int speed = scan.nextInt();
		System.out.println("Enter the range of your Jet.");
		int range = scan.nextInt();
		System.out.println("Enter the price of your Jet.");
		double price = scan.nextDouble();
		System.out.println();
		
		while (start) {
			System.out.println(p + "  " + p + "  " + p + "  " + p + "  " + p + "  " + p + "  " + p + "  " + p + "  " + p
					+ "  " + p + "  " + p + "  " + p + "  " + p + "  ");
			System.out.println("Enter the number of the type of jet:");
			System.out.println("1. Cargo Jet.");
			System.out.println("2. Fighter Jet.");
			System.out.println("3. Passenger Jet");
			System.out.println(p + "  " + p + "  " + p + "  " + p + "  " + p + "  " + p + "  " + p + "  " + p + "  " + p
					+ "  " + p + "  " + p + "  " + p + "  " + p + "  ");
			int choice = scan.nextInt();
		
			switch (choice) {
			case 1:
				newJet = new CargoJet(model, speed, range, price);
				start = false;
				break;
			case 2:
				newJet = new FighterJet(model, speed, range, price);
				start = false;
				break;
			case 3:
				newJet = new Passenger(model, speed, range, price);
				start = false;
				break;
			default:
				System.out.println("Incorrect input. Please input '1', '2', or '3'.");
				break;
			}
		}
		scan.close();
		fleet.add(newJet);
	}
	public void loadCargoJets() {
		for (Jet each : fleet) {
			if (each instanceof CargoJet) {
				((CargoJet) each).loadCargo();
			}
		}

	}
	public void fightFighterJets() {
		for (Jet each : fleet) {
			if (each instanceof FighterJet) {
				((FighterJet) each).fight();
			}
		}

	}
}


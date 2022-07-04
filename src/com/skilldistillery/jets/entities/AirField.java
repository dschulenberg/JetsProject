package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.app.JetsApplication;

public class AirField {
	public List<Jet> getFleet() {
		return createFleet(fleet);
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}

	private List<Jet> fleet = new ArrayList<>();

	public List<Jet> createFleet(List<Jet> fleet) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetRecord = line.split(",");
				String type = jetRecord[0];
				String model = jetRecord[1];
				int speed = Integer.parseInt(jetRecord[2]);
				int range = Integer.parseInt(jetRecord[3]);
				double price = Double.parseDouble(jetRecord[4]);
				if (type.equals("cargo")) {
					Jet c = new CargoJet(model, speed, range, price);
					fleet.add(c);

				}
				if (type.equals("fighter")) {
					Jet f = new FighterJet(model, speed, range, price);
					fleet.add(f);
				}
				if (type.equals("passenger")) {
					Jet p = new Passenger(model, speed, range, price);
					fleet.add(p);
				}

			}
		} catch (IOException e) {
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

	public void flyAll() {
		for (Jet each : fleet) {
			each.fly();
		}

	}

	public void listFastest() {
		int highest = 0;
		for (Jet each : fleet) {
			if (each.getSpeed() > highest) {
				highest = each.getSpeed();
			}
		}
		for (Jet each : fleet) {
			if (each.getSpeed() == highest) {
				System.out.println(each);
			}
		}
	}

	public void listLongest() {
		int longest = 0;
		for (Jet each : fleet) {
			if (each.getRange() > longest) {
				longest = each.getRange();
			}
		}
		for (Jet each : fleet) {
			if (each.getRange() == longest) {
				System.out.println(each);
			}
		}
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

	public int tryCatchInt(int number) {
		JetsApplication ja = new JetsApplication();
		Scanner scan = ja.getScan();
		boolean start = true;
		do {
			try {
				number = scan.nextInt();
				start = false;
			} catch (Exception e) {
				System.out.println("You must a number. Try again.");
				scan.nextLine();
				System.out.println();
			}
		} while (start);
		return number;
	}

	public double tryCatchDouble(double number) {
		JetsApplication ja = new JetsApplication();
		Scanner scan = ja.getScan();
		boolean start = true;
		do {
			try {
				number = scan.nextInt();
				start = false;
			} catch (Exception e) {
				System.out.println("You must a number. Try again.");
				scan.nextLine();
				System.out.println();
			}
		} while (start);
		return number;
	}

	public void addJet() {
		char p = '\u2708';
		boolean start = true;
		Jet newJet = null;
		JetsApplication ja = new JetsApplication();
		Scanner scan = ja.getScan();

		System.out.println("Enter the model of your Jet.");
		String model = scan.nextLine();

		int speed = 0;
		System.out.println("Enter the speed of your Jet.");
		speed = tryCatchInt(speed);

		System.out.println("Enter the range of your Jet.");
		int range = 0;
		range = tryCatchInt(range);

		System.out.println("Enter the price of your Jet.");
		double price = 0;
		price = tryCatchDouble(price);

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
			int choice = 0;
			choice = tryCatchInt(choice);

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
		fleet.add(newJet);

	}

	public void removeJet() {

		if (fleet.size() == 0) {
			System.out.println("No more Jets. Please add more before removing more.");
			return;

		}
		String userInput = null;
		userInput = removeHelp(userInput);

		if (userInput.equals("number")) {
			System.out.println("Which jet would you like to remove by number?");
			System.out.println();
			for (Jet each : fleet) {
				System.out.println("Number: " + fleet.indexOf(each) + " " + each);
			}
			tryCatchNumber();

		} else if (userInput.equals("model")) {
			System.out.println("Which jet would you like to remove by Model?");
			System.out.println();
			for (Jet each : fleet) {
				System.out.println(each);
			}
			tryCatchModel();

		}

	}

	public String removeHelp(String userInput) {
		JetsApplication ja = new JetsApplication();
		Scanner scan = ja.getScan();
		boolean start = true;
		System.out.println("Would you like to remove by 'number' or 'model'?");
		System.out.println();
		userInput = scan.nextLine();
		while (start) {
			if (!userInput.equals("number") && !userInput.equals("model")) {
				System.out.println("ERROR!! You must type either 'model' or 'number' to start.");
				userInput = scan.nextLine();
			}
			if (userInput.equals("number") || userInput.equals("model")) {
				start = false;
			}
		}
		return userInput;
	}

	public void tryCatchModel() {
		JetsApplication ja = new JetsApplication();
		Scanner scan = ja.getScan();
		boolean start = true;
		do {
			try {
				int index = 0;
				String modRemoved = scan.nextLine();
				for (Jet each : fleet) {
					if (each.getModel().equals(modRemoved)) {
						break;
					}
					index++;
				}
				fleet.remove(index);
				start = false;
			} catch (Exception e) {
				System.out.println("You must enter the model of a jet listed.");
				System.out.println();
			}
		} while (start);

	}

	public void tryCatchNumber() {
		JetsApplication ja = new JetsApplication();
		Scanner scan = ja.getScan();
		boolean start = true;
		do {
			try {
				int numRemoved = scan.nextInt();
				fleet.remove(numRemoved);
				start = false;
			} catch (Exception e) {
				System.out.println("You must enter the number of a jet listed.");
				scan.nextLine();
				System.out.println();
			}
		} while (start);

	}
}

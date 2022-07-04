package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;

public class JetsApplication {
	private Scanner scan = new Scanner(System.in);
	private AirField af = new AirField();

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	public AirField getAf() {
		return af;
	}

	public void setAf(AirField af) {
		this.af = af;
	}

	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.menuLoop();

	}

	public void menuLoop() {
		boolean start = true;
		AirField af = new AirField();
		af.launch();

		do {
			System.out.println();
			displayMenu();
			System.out.println();
			int choice = 0;
			try {

				choice = scan.nextInt();

			} catch (Exception e) {
				System.out.println("Please enter a number.");
				scan.nextLine();
			}
			switch (choice) {

			case 1:
				af.listFleet();
				break;
			case 2:
				af.flyAll();
				break;
			case 3:
				af.listFastest();
				break;
			case 4:
				af.listLongest();
				break;
			case 5:
				af.loadCargoJets();
				break;
			case 6:
				af.fightFighterJets();
				break;
			case 7:
				af.addJet();
				break;
			case 8:
				af.removeJet();
				break;
			case 9:
				System.out.println("Thank you for using our app. Goodbye");
				start = false;
				break;
			default:
				System.out.println("Error. Please enter a listed number.");
				break;

			}
		} while (start);

		scan.close();

	}

	public void displayMenu() {
		char p = '\u2708';
		System.out.println(p + "  " + p + "  " + p + "  " + p + "  " + p + "  " + p + "  " + p + "  " + p + "  " + p
				+ "  " + p + "  " + p + "  " + p + "  " + p + "  ");
		System.out.println("Please choose a number from the following:");
		System.out.println("1. List fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. View fastest jet");
		System.out.println("4. View jet with longest range");
		System.out.println("5. Load all Cargo Jets");
		System.out.println("6. Dogfight!");
		System.out.println("7. Add a jet to Fleet");
		System.out.println("8. Remove a jet from Fleet");
		System.out.println("9. Quit");
		System.out.println(p + "  " + p + "  " + p + "  " + p + "  " + p + "  " + p + "  " + p + "  " + p + "  " + p
				+ "  " + p + "  " + p + "  " + p + "  " + p + "  ");

	}

}

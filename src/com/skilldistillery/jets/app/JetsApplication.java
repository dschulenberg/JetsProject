package com.skilldistillery.jets.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoJet;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.Passenger;

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
		AirField af = new AirField();
		af.launch();
		af.listFleet();
	//	 af.loadCargoJets();
		 af.fightFighterJets();
	
	//	ja.removeJet(currentFleet);
	//	af.addJet();
	//	af.removeJet();

	}



	public void listFastest(List<Jet> currentFleet) {
		int highest = 0;
		for (Jet each : currentFleet) {
			if (each.getSpeed() > highest) {
				highest = each.getSpeed();
			}
		}
		for (Jet each : currentFleet) {
			if (each.getSpeed() == highest) {
				System.out.println(each);
			}
		}
	}

	public void listLongest(List<Jet> currentFleet) {
		int longest = 0;
		for (Jet each : currentFleet) {
			if (each.getRange() > longest) {
				longest = each.getRange();
			}
		}
		for (Jet each : currentFleet) {
			if (each.getRange() == longest) {
				System.out.println(each);
			}
		}
	}


	public void flyAll(List<Jet> currentFleet) {
		for (Jet each : currentFleet) {
			each.fly();
		}

	}

}

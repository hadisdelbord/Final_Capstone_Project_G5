package CapstoneProject.managers;

import CapstoneProject.models.Battery;

import java.util.ArrayList;
import java.util.List;

public class BatteryManager {

	public static final int PROGRESSBAR_LENGTH = 20;
	public static final List<Battery> batteries = new ArrayList<>();

	public static void initialize() throws Exception {
		batteries.clear();
		batteries.add(new Battery("Battery 1", 400, 50));
		batteries.add(new Battery("Battery 2", 300, 70));
		batteries.add(new Battery("Battery 3", 200, 25));
		batteries.add(new Battery("Battery 4", 100, 30));
		batteries.add(new Battery("Battery 5", 500));
	}

	public static List<Battery> getBatteries() {
		return batteries;
	}

	public static void showBatteryStatus() {
		System.out.println("\nBattery Status:");
		for (Battery battery : batteries) {
			int charge = battery.getChargePercentage();
			StringBuilder statusBar = new StringBuilder("[");

			// Create a 20-character status bar
			int filledLength = charge / 5; // Each '=' represents 5%
			for (int i = 0; i < BatteryManager.PROGRESSBAR_LENGTH; i++) {
				if (i < filledLength) {
					statusBar.append("="); // Filled portion
				} else {
					statusBar.append(" "); // Unfilled portion
				}
			}
			statusBar.append("]"); // Close the status bar

			System.out.println(battery.getName() + ": " + statusBar + " " + charge + "% ");
		}
	}
}
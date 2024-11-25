package CapstoneProject.managers;

import CapstoneProject.models.Battery;

import java.util.ArrayList;
import java.util.List;

public class BatteryManager {
	private static final List<Battery> batteries = new ArrayList<>();
//	private static final Object lock = new Object();

	public static void initialize() {
		batteries.add(new Battery("Battery 1", 40, 80));
		batteries.add(new Battery("Battery 2", 25, 30));
		batteries.add(new Battery("Battery 3", 30, 60));
		batteries.add(new Battery("Battery 4", 50, 90));
		batteries.add(new Battery("Battery 5", 100, 80));
		batteries.add(new Battery("Battery 6", 50, 70));
	}

	public static List<Battery> getBatteries() {
		return batteries;
	}

	public static void showBatteryStatus() {
		System.out.println("\nBattery Status:");
		for (Battery battery : batteries) {
			int charge = battery.getCharge();
			StringBuilder statusBar = new StringBuilder("[");

			// Create a 20-character status bar
			int filledLength = charge / 5; // Each '#' represents 5%
			for (int i = 0; i < 20; i++) {
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
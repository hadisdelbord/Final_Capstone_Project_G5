package CapstoneProject.managers;
import java.util.HashMap;
import java.util.Map;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;

import CapstoneProject.models.EnergySource;
//import CapstoneProject.managers.BatteryManager;



public class EnergySourceManager {

	private static final Map<String, EnergySource> energySources = new HashMap<>();

	public static void initialize() {
		energySources.put("summer", new EnergySource("Solar" , 2000));
		energySources.put("windy", new EnergySource("Wind", 3000));
		energySources.put("rainy", new EnergySource("Electricity", 4000));
	}
	
//	public void charge() {
//
//		if (this.energySource == null) {
//
//			System.err.println("The Energy Source does not exist!");
//			return;
//
//		}
//
//		double amount = this.energySource.getPower() / 3600;
//
//		ExecutorService executor = Executors.newFixedThreadPool(10);
//
//		executor.submit(new Runnable() {
//
//			@Override
//			public void run() {
//
//				while (true) {
//
//					if (amount <= 0) {
//						System.err.println("Amount charge is invalid!");
//						return;
//
//					}
//					if (amount + (currentCharge * capacity /100) <= capacity) {
//						currentCharge += amount;
//						// System.out.println(Thread.currentThread().getName() + " charged battery by " + amount
//							//	+ ", current charge: " + currentCharge);
//						try {
//							ProgressBar();
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						
//					} else {
//						if (amount + (currentCharge * capacity /100) > capacity) {
//							currentCharge = capacity;
//							System.out.println("Battery full! Current charge: " + currentCharge + "%");
//							return;
//
//						}
//					}
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						System.err.println("Interrupted!");
//					}
//
//				}
//			}
//		});
//		
//		executor.shutdown();
//
//	}
	

}

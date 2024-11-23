package CapstoneProject.managers;

import java.util.ArrayList;
import java.util.List;

import CapstoneProject.models.Battery;

public class BatteryManager {

	private static List<Battery> batteries = new ArrayList<Battery>();
	
	public static void initialize() {
        batteries.add(new Battery("Battery 1", 200, 80));
        batteries.add(new Battery("Battery 2", 300, 30));
        batteries.add(new Battery("Battery 3", 100, 60));
        batteries.add(new Battery("Battery 4", 200, 90));
        batteries.add(new Battery("Battery 5", 170, 80));
        batteries.add(new Battery("Battery 6", 80, 70));

//        startRechargeThread();
    }
	
	

}

package CapstoneProject.managers;

import CapstoneProject.models.Battery;

import java.util.ArrayList;
import java.util.List;

public class BatteryManager {
    private static final List<Battery> batteries = new ArrayList<>();
    private static final Object lock = new Object();

    public static void initialize() {
        batteries.add(new Battery("Battery 1", 80));
        batteries.add(new Battery("Battery 2", 30));
        batteries.add(new Battery("Battery 3", 60));
        batteries.add(new Battery("Battery 4", 90));
        batteries.add(new Battery("Battery 5", 80));
        batteries.add(new Battery("Battery 6", 70));

        startRechargeThread();
    }

    public static List<Battery> getBatteries() {
        return batteries;
    }

    public static void showBatteryStatus() {
        System.out.println("\nBattery Status:");
        for (Battery battery : batteries) {
            System.out.println(battery.getName() + ": " + battery.getCharge() + "%");
        }
    }

    private static void startRechargeThread() {
        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    for (Battery battery : batteries) {
                        if (battery.getCharge() < 30) {
                            battery.recharge(30);
                            System.out.println(battery.getName() + " recharging.... Current: " + battery.getCharge() + "%");
                        }
                    }
                }
                try {
                    Thread.sleep(2000); // Simulate recharge time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}

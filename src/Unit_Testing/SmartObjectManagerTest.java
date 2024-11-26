package Unit_Testing;
import CapstoneProject.managers.*;
import CapstoneProject.models.Battery;
import CapstoneProject.models.SmartObject;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import java.util.concurrent.TimeUnit;

public class SmartObjectManagerTest {

    @Before
    public void setUp() {
        // Clear existing objects and batteries
        SmartObjectManager.smartObjects.clear();
        BatteryManager.getBatteries().clear();
    }

    @Test
    public void testAddSmartObject() {
        SmartObjectManager.addSmartObject("Lamp", 10);
        assertEquals(1, SmartObjectManager.smartObjects.size());
        assertEquals("Lamp", SmartObjectManager.smartObjects.get(0).getName());
    }

    @Test
    public void testToggleSmartObject() {
        SmartObjectManager.addSmartObject("Fan", 15);
        SmartObjectManager.toggleSmartObjects("Fan");

        SmartObject object = SmartObjectManager.smartObjects.get(0);
        assertTrue(object.isActive());
    }

    @Test
    public void testToggleInvalidSmartObject() {
        SmartObjectManager.addSmartObject("Heater", 20);
        SmartObjectManager.toggleSmartObjects("NonExistentObject");

        SmartObject object = SmartObjectManager.smartObjects.get(0);
        assertFalse(object.isActive()); // Heater should remain inactive
    }

    @Test
    public void testEnergyConsumptionWithAvailableBattery() throws InterruptedException {
        Battery battery = new Battery("Battery1", 100, 80);
        BatteryManager.batteries.add(battery);

        SmartObjectManager.addSmartObject("AC", 30);
        SmartObjectManager.toggleSmartObjects("AC");

        TimeUnit.SECONDS.sleep(2); // Allow consumption to proceed

        assertTrue(battery.getCharge() < 100); // Battery should discharge
    }

    @Test
    public void testMultipleSmartObjects() throws InterruptedException {
        Battery battery1 = new Battery("Battery1", 100, 80);
        Battery battery2 = new Battery("Battery2", 500, 70);
        BatteryManager.batteries.add(battery1);
        BatteryManager.batteries.add(battery2);

        SmartObjectManager.addSmartObject("Light", 20);
        SmartObjectManager.addSmartObject("Fan", 30);

        SmartObjectManager.toggleSmartObjects("Light,Fan");

        TimeUnit.SECONDS.sleep(3); // Allow consumption to proceed

        assertTrue(battery1.getCharge() < 100 || battery2.getCharge() < 100);
    }
}


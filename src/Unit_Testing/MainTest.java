package Unit_Testing;

import CapstoneProject.managers.*;
import CapstoneProject.models.Battery;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import static org.junit.Assert.*;

public class MainTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        // Redirect System.out for testing purposes
        System.setOut(new PrintStream(outputStream));
        BatteryManager.initialize();
        EnergySourceManager.initialize();
    }


    @Test
    public void testChargingWeatherSunny() {
        String weather = "sunny";
        EnergySourceManager.chargeBatteries(weather);

        // Assuming sunny weather generates enough charge
        assertTrue(BatteryManager.getBatteries().stream().anyMatch(battery -> battery.getCharge() > 0));
    }

    @Test
    public void testShowBatteryStatus() {
    	Battery battery1 = new Battery("Battery1", 100, 50);
        BatteryManager.batteries.add(battery1); // Adding a battery for testing
        BatteryManager.showBatteryStatus();

        String output = outputStream.toString();
        assertTrue(output.contains("Battery1"));
        assertTrue(output.contains("50%")); // Check charge percentage
    }

    @Test
    public void testViewEnergySourceLogs() {
        ESLogManager.addESLog("SolarPanel", "Battery1", "Test log entry");
        ESLogManager.viewESLogs();

        String output = outputStream.toString();
        assertTrue(output.contains("SolarPanel"));
        assertTrue(output.contains("Test log entry"));
    }

    @Test
    public void testFilterLogsByDate() {
        LogManager.addLog("Lamp", "Battery1", "Initial log");
        LogManager.viewLogsByDate(new Date());

        String output = outputStream.toString();
        assertTrue(output.contains("Lamp"));
        assertTrue(output.contains("Initial log"));
    }
}

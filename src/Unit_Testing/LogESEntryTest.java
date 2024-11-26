package Unit_Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import CapstoneProject.managers.LogESEntry;

import static org.junit.Assert.*;

import org.junit.Test;

public class LogESEntryTest {

    // Test 1: Constructor initializes fields correctly
    @Test
    public void testConstructorInitialization() {
        LogESEntry log = new LogESEntry("Solar", "Battery 1", "80%", "2023-11-25 12:30:00");

        assertEquals("Energy source should be 'Solar'.", "Solar", log.getEnergySource());
        assertEquals("Battery name should be 'Battery 1'.", "Battery 1", log.getBatteryName());
        assertEquals("Current charge should be '80%'.", "80%", log.getCurrentCharge());
        assertEquals("Timestamp should be '2023-11-25 12:30:00'.", "2023-11-25 12:30:00", log.getTimestamp());
    }

    // Test 2: Getters return correct energy source
    @Test
    public void testGetEnergySource() {
        LogESEntry log = new LogESEntry("Wind", "Battery 2", "60%", "2023-11-25 15:45:00");

        assertEquals("Energy source should be 'Wind'.", "Wind", log.getEnergySource());
    }

    // Test 3: Getters return correct battery name
    @Test
    public void testGetBatteryName() {
        LogESEntry log = new LogESEntry("Hydro", "Battery 3", "70%", "2023-11-26 08:00:00");

        assertEquals("Battery name should be 'Battery 3'.", "Battery 3", log.getBatteryName());
    }

    // Test 4: Getters return correct current charge
    @Test
    public void testGetCurrentCharge() {
        LogESEntry log = new LogESEntry("Geothermal", "Battery 4", "50%", "2023-11-26 09:15:00");

        assertEquals("Current charge should be '50%'.", "50%", log.getCurrentCharge());
    }

    // Test 5: Getters return correct timestamp
    @Test
    public void testGetTimestamp() {
        LogESEntry log = new LogESEntry("Nuclear", "Battery 5", "90%", "2023-11-26 10:30:00");

        assertEquals("Timestamp should be '2023-11-26 10:30:00'.", "2023-11-26 10:30:00", log.getTimestamp());
    }

    // Test 6: All fields combined in a meaningful test
    @Test
    public void testLogESEntryData() {
        LogESEntry log = new LogESEntry("Solar", "Battery 1", "80%", "2023-11-25 12:30:00");

        assertEquals("Solar", log.getEnergySource());
        assertEquals("Battery 1", log.getBatteryName());
        assertEquals("80%", log.getCurrentCharge());
        assertEquals("2023-11-25 12:30:00", log.getTimestamp());
    }
}


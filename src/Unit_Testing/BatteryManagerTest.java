package Unit_Testing;

import CapstoneProject.managers.BatteryManager;
import CapstoneProject.models.Battery;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BatteryManagerTest {

    @Before
    public void setUp() {
        // Clear the batteries list before each test
        BatteryManager.batteries.clear();
    }

    @Test
    public void testGetBatteries() throws Exception {
        // Arrange
        BatteryManager.initialize();

        // Act
        List<Battery> batteries = BatteryManager.getBatteries();

        // Assert
        assertNotNull(batteries);
        assertFalse(batteries.isEmpty());
    }

    @Test
    public void testShowBatteryStatus() throws Exception {
        // Arrange
    	BatteryManager.batteries.add(new Battery("Battery A", 400, 50));
    	BatteryManager.batteries.add(new Battery("Battery B", 300,  70));
    	BatteryManager.batteries.add(new Battery("Battery C", 200, 25));

        // Redirect System.out to capture printed output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        // Act
        BatteryManager.showBatteryStatus();

        // Assert
        String output = outContent.toString();
        assertTrue(output.contains("Battery A: [==                  ] 12%"));
        assertTrue(output.contains("Battery B: [====                ] 23%"));
        assertTrue(output.contains("Battery C: [==                  ] 12%"));

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
    public void testEmptyBatteryList() {
        // Arrange & Act
        List<Battery> batteries = BatteryManager.getBatteries();

        // Assert
        assertTrue(batteries.isEmpty());
    }
}


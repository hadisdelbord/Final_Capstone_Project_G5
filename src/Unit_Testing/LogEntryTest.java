package Unit_Testing;

import org.junit.Test;

import CapstoneProject.managers.LogEntry;

import static org.junit.Assert.*;

public class LogEntryTest {

    @Test
    public void testLogEntryConstructor() {
        // Arrange
        String objectName = "SmartLight";
        String batteryName = "Battery1";
        String action = "Activated";
        String timestamp = "2024-11-26 15:30:00";

        // Act
        LogEntry logEntry = new LogEntry(objectName, batteryName, action, timestamp);

        // Assert
        assertNotNull(logEntry);
        assertEquals(objectName, logEntry.getObjectName());
        assertEquals(batteryName, logEntry.getBatteryName());
        assertEquals(action, logEntry.getAction());
        assertEquals(timestamp, logEntry.getTimestamp());
    }

    @Test
    public void testGetObjectName() {
        // Arrange
        LogEntry logEntry = new LogEntry("SmartFan", "Battery2", "Deactivated", "2024-11-26 16:00:00");

        // Act
        String objectName = logEntry.getObjectName();

        // Assert
        assertEquals("SmartFan", objectName);
    }

    @Test
    public void testGetBatteryName() {
        // Arrange
        LogEntry logEntry = new LogEntry("SmartLight", "Battery1", "Activated", "2024-11-26 15:45:00");

        // Act
        String batteryName = logEntry.getBatteryName();

        // Assert
        assertEquals("Battery1", batteryName);
    }

    @Test
    public void testGetAction() {
        // Arrange
        LogEntry logEntry = new LogEntry("SmartSpeaker", "Battery3", "Activated", "2024-11-26 17:00:00");

        // Act
        String action = logEntry.getAction();

        // Assert
        assertEquals("Activated", action);
    }

    @Test
    public void testGetTimestamp() {
        // Arrange
        LogEntry logEntry = new LogEntry("SmartThermostat", "Battery4", "Deactivated", "2024-11-26 18:00:00");

        // Act
        String timestamp = logEntry.getTimestamp();

        // Assert
        assertEquals("2024-11-26 18:00:00", timestamp);
    }

    @Test
    public void testMultipleLogEntries() {
        // Arrange
        LogEntry log1 = new LogEntry("SmartLight", "Battery1", "Activated", "2024-11-26 15:30:00");
        LogEntry log2 = new LogEntry("SmartFan", "Battery2", "Deactivated", "2024-11-26 16:00:00");

        // Act & Assert
        assertNotEquals(log1.getObjectName(), log2.getObjectName());
        assertNotEquals(log1.getBatteryName(), log2.getBatteryName());
        assertNotEquals(log1.getAction(), log2.getAction());
        assertNotEquals(log1.getTimestamp(), log2.getTimestamp());
    }
}


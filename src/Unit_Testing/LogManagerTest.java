package Unit_Testing;

import org.junit.Before;
import org.junit.Test;

import CapstoneProject.managers.LogEntry;
import CapstoneProject.managers.LogManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class LogManagerTest {

    @Before
    public void setUp() {
        // Clear all logs before each test
        LogManager.getLogs().clear();
    }

    @Test
    public void testAddLog() {
        // Arrange
        String objectName = "SmartLight";
        String batteryName = "Battery1";
        String action = "Activated";

        // Act
        LogManager.addLog(objectName, batteryName, action);

        // Assert
        assertEquals(1, LogManager.getLogs().size());
        LogEntry log = LogManager.getLogs().get(0);
        assertEquals(objectName, log.getObjectName());
        assertEquals(batteryName, log.getBatteryName());
        assertEquals(action, log.getAction());
        assertNotNull(log.getTimestamp());
    }

    @Test
    public void testViewLogsByFilter_Object() {
        // Arrange
        LogManager.addLog("SmartLight", "Battery1", "Activated");
        LogManager.addLog("SmartFan", "Battery2", "Deactivated");

        // Act
        LogManager.viewLogsByFilter("object", "SmartLight");

        // Assert
        List<LogEntry> logs = LogManager.getLogs();
        assertEquals(2, logs.size());
        assertEquals("SmartLight", logs.get(0).getObjectName());
    }

    @Test
    public void testViewLogsByDate() throws Exception {
        // Arrange
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        LogManager.addLog("SmartLight", "Battery1", "Activated");
        LogManager.addLog("SmartFan", "Battery2", "Deactivated");

        // Act
        LogManager.viewLogsByDate(today);

        // Assert
        List<LogEntry> logs = LogManager.getLogs();
        assertEquals(2, logs.size()); // Both logs should match today's date
        assertTrue(logs.get(0).getTimestamp().startsWith(dateFormat.format(today)));
        assertTrue(logs.get(1).getTimestamp().startsWith(dateFormat.format(today)));
    }

    @Test
    public void testDeleteLog() {
        // Arrange
        LogManager.addLog("SmartLight", "Battery1", "Activated");
        LogManager.addLog("SmartFan", "Battery2", "Deactivated");

        // Act
        LogManager.deleteLog(0);

        // Assert
        assertEquals(1, LogManager.getLogs().size());
        assertEquals("SmartFan", LogManager.getLogs().get(0).getObjectName());
    }

    @Test
    public void testExportLogs() throws IOException {
        // Arrange
        LogManager.addLog("SmartLight", "Battery1", "Activated");
        LogManager.addLog("SmartFan", "Battery2", "Deactivated");
        String filePath = "test_logs.csv";

        // Act
        LogManager.exportLogs(filePath);

        // Assert
        File file = new File(filePath);
        assertTrue(file.exists());
        List<String> lines = Files.readAllLines(file.toPath());
        assertEquals(3, lines.size()); // Header + 2 logs
        assertEquals("Object,Battery,Action,Timestamp", lines.get(0)); // Header
        file.delete(); // Clean up test file
    }

    @Test
    public void testViewLogsWithNoLogs() {
        // Act & Assert
        LogManager.viewLogs();
        assertTrue(LogManager.getLogs().isEmpty()); // No logs should exist
    }
}


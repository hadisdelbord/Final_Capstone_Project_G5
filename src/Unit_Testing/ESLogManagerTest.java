package Unit_Testing;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import CapstoneProject.managers.ESLogManager;
import CapstoneProject.managers.LogESEntry;

public class ESLogManagerTest {

    // Set up before each test
    @Before
    public void setUp() {
        ESLogManager.getESLogs().clear(); // Clear logs before each test
    }

    // Test 1: Adding a new log
    @Test
    public void testAddESLog() {
        ESLogManager.addESLog("Solar", "Battery 1", "80%");
        List<LogESEntry> logs = ESLogManager.getESLogs();
        
        assertEquals("The log count should be 1 after adding a single log.", 1, logs.size());
        LogESEntry log = logs.get(0);
        assertEquals("The energy source should match the added log.", "Solar", log.getEnergySource());
        assertEquals("The battery name should match the added log.", "Battery 1", log.getBatteryName());
        assertEquals("The current charge should match the added log.", "80%", log.getCurrentCharge());
    }

    // Test 2: Viewing logs by source filter
    @Test
    public void testViewESLogsBySourceFilter() {
        ESLogManager.addESLog("Solar", "Battery 1", "80%");
        ESLogManager.addESLog("Wind", "Battery 2", "50%");
        List<LogESEntry> logs = ESLogManager.getESLogs();
        
        long solarLogsCount = logs.stream()
                                  .filter(log -> log.getEnergySource().equalsIgnoreCase("Solar"))
                                  .count();
        assertEquals("There should be exactly one Solar energy source log.", 1, solarLogsCount);
    }

    // Test 3: Viewing logs by date
    @Test
    public void testViewESLogsByDate() {
        Date today = new Date();
        String todayFormatted = new SimpleDateFormat("yyyy-MM-dd").format(today);
        
        ESLogManager.addESLog("Solar", "Battery 1", "90%");
        ESLogManager.addESLog("Wind", "Battery 2", "60%");
        
        List<LogESEntry> logs = ESLogManager.getESLogs();
        long logsForToday = logs.stream()
                                .filter(log -> log.getTimestamp().startsWith(todayFormatted))
                                .count();
        assertEquals("There should be exactly 2 logs for today's date.", 2, logsForToday);
    }

    // Test 4: Deleting a log entry
    @Test
    public void testDeleteESLog() {
        ESLogManager.addESLog("Solar", "Battery 1", "70%");
        ESLogManager.addESLog("Wind", "Battery 2", "30%");
        List<LogESEntry> logs = ESLogManager.getESLogs();
        
        assertEquals("The log count should be 2 before deletion.", 2, logs.size());
        ESLogManager.deleteESLog(0);
        assertEquals("The log count should be 1 after deleting one log.", 1, logs.size());
        assertEquals("The remaining log should belong to the 'Wind' energy source.", "Wind", logs.get(0).getEnergySource());
    }


    // Test 5: Viewing logs by invalid filter
    @Test
    public void testViewESLogsByInvalidFilter() {
        ESLogManager.addESLog("Solar", "Battery 1", "70%");
        List<LogESEntry> logs = ESLogManager.getESLogs();
        
        long invalidFilterCount = logs.stream()
                                      .filter(log -> log.getEnergySource().equalsIgnoreCase("Hydro"))
                                      .count();
        assertEquals("No logs should match the invalid energy source 'Hydro'.", 0, invalidFilterCount);
    }
}

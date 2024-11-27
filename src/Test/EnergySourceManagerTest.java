package Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import CapstoneProject.managers.*;


public class EnergySourceManagerTest {
	
	
	@Before
    public void setUp() {
		
		EnergySourceManager.initialize();
        
    }

    @After
    public void tearDown() {
       
    }
    
    @Test
    public void testInitialize() {
    	
    	String esName = "sunny";
    	assertNotNull(EnergySourceManager.getEnergySources().get(esName.toLowerCase()));
    	assertEquals("Solar",EnergySourceManager.getEnergySources().get(esName).getName());
    	
    	esName = "SuNny";
    	assertNotNull(EnergySourceManager.getEnergySources().get(esName.toLowerCase()));
    	assertEquals("Solar",EnergySourceManager.getEnergySources().get(esName.toLowerCase()).getName());
    	
    	esName = "wiNdy";
    	assertNotNull(EnergySourceManager.getEnergySources().get(esName.toLowerCase()));
    	assertEquals("Windy",EnergySourceManager.getEnergySources().get(esName.toLowerCase()).getName());
    	
    	esName = "raIny";
    	assertNotNull(EnergySourceManager.getEnergySources().get(esName.toLowerCase()));
    	assertEquals("Electricity",EnergySourceManager.getEnergySources().get(esName.toLowerCase()).getName());
  
    	esName = "xxx";
    	assertNull(EnergySourceManager.getEnergySources().get(esName.toLowerCase()));
    	
    }

}
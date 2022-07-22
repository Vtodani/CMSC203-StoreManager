

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany mgmtco ; 
	Property prop1;
	Property prop2;
	Property prop3;
	@Before
	public void setUp() throws Exception {
		//student create a management company
		mgmtco=new ManagementCompany("test","12345",50);
		//student add three properties, with plots, to mgmt co
		prop1 = new Property ("Zana", "Nowhere",500, "Tester",2,1,2,2);
		prop2 = new Property ("Jack", "Rockville", 500, "Tester",4,1,2,2);
		prop3 = new Property ("Speed", "Taka", 1500, "Tester",6,1,2,2);
		mgmtco.addProperty(prop1);
		mgmtco.addProperty(prop2);
		mgmtco.addProperty(prop3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null 
		mgmtco=null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		
		//student should add property with 4 args & default plot (0,0,1,1)
		//student should add property with 8 args
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		assertEquals(mgmtco.addProperty(new Property("test","1234",500,"Tester")),3,0);
		assertEquals(mgmtco.addProperty(new Property("test2","1234",700,"Tester2",8,8,1,1)),4,0);
		//6th property thus out of bounds of the array size
		assertEquals(mgmtco.addProperty(new Property("test3","1534",40,"Tester3",10,10,1,1)),-1,0);
		
	}
 
	@Test
	public void testMaxRentProp() {
		
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(mgmtco.maxRentProp(),1500,0);
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(mgmtco.totalRent(),2500,0);
	}

 }

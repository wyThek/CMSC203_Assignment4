
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestSTUDENT {
	Property p1 ,p2,p3,p4,p5,p6;
	ManagementCompany m ; 
	@Before
	public void setUp() throws Exception {
		//student create a management company
		m= new ManagementCompany("Bliss", "8902245",6);
		//student add three properties, with plots, to mgmt co
		p1 = new Property ("Little Haven", "Shadywood", 4500.00, "Hayden Smith",2,1,2,2);
		p2 = new Property ("Pellucid", "Maplewood", 3000, "Emily Sam",4,1,2,2);
		p3 = new Property ("Zaphyr", "Cassiopia", 4200, "Sarah Zaheer",6,1,2,2);
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		p1=p2=p3=p4=p5=p6=null;
		m=null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		p4 = new Property ("Shade", "Franchtown", 3435, "BillyBob Wilson",2,5,2,2);
		assertEquals(m.addProperty(p4),3,0);
		p5 = new Property ("Shakke", "Lakeville", 2322, "Joey BagODonuts",4,5,2,2);
		assertEquals(m.addProperty(p5),4,0);
		p6 = new Property ("Hunt", "ShadyGroove", 1000, "Joey BagODonuts",6,5,2,2);
		assertEquals(m.addProperty(p6),-1,0);

	}
 
	@Test
	public void testMaxRentProp() {
		assertEquals(m.maxRentProp(), 4500, 0);
		
	}

	@Test
	public void testTotalRent() {
		assertEquals(m.totalRent(), 11700, 0);
	}

 }
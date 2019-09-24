package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import RentProperties.RentProperties;
import SaleProperties.SaleProperties;

public class RentPropertiesTests {
	
	RentProperties rp;
	
	@Before
	public void setup() {
		rp = new RentProperties();
	}

	@Test
	public void managementFeeTest() {
		assertEquals(8, rp.managementFee());
		
		rp.negotiateFee();
		assertNotEquals(8, rp.managementFee());
		assertEquals(6, rp.managementFee());
	}
	
	@Test
	public void offerAcceptAfterDueDate() {
		//TODO acceptApplication function needs work after classes are done
		assertFalse(rp.acceptApplication(4, true));
	}

	
	@Test
	public void offerAcceptDuringDueDate() {
		//TODO acceptApplication function needs work after classes are done
		assertTrue(rp.acceptApplication(2, true));
	}
	
	@Test
	public void paiedBond() {
		assertTrue(rp.receivedBond(true));
	}
}

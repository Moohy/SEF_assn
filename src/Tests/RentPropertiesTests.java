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
	}
	
	@Test
	public void offerAcceptAfterDueDate() {
		assertFalse(rp.acceptApplication(4, true));
	}

	
	@Test
	public void offerAcceptDuringDueDate() {
		assertTrue(rp.acceptApplication(2, true));
	}

}

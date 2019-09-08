package Tests;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import org.junit.Assert; 

import org.junit.Before;
import org.junit.Test;

import SaleProperties.SaleProperties;

public class SalePropertiesTests {
	
	SaleProperties sp;
	
	@Before
	public void setup() {
		sp = new SaleProperties();
	}

	@Test
	public void CommissionTest() {
		double salePrice = 120000;		
		double commissionRate = .05;
		
		double commission = salePrice * commissionRate;
		
		double sale = salePrice * sp.commission(.04);

		
		assertNotEquals(commission, sale);
		
		sale = salePrice * sp.commission(.05);
		assertEquals(commission, sale, 0);
	}
	
	@Test
	public void offerAcceptAfterDueDate() {
		assertFalse(sp.isOfferAccepted(4, true));
	}

	
	@Test
	public void offerAcceptDuringDueDate() {
		assertTrue(sp.isOfferAccepted(2, true));
	}
	
	@Test
	public void paiedDeposit() {
		assertTrue(sp.receivedDeposit(true));
	}

}

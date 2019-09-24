package Tests;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import org.junit.Assert; 

import org.junit.Before;
import org.junit.Test;

import Customer.*
;
import Offer.Offer;
import Property.*;

public class SalePropertyTests {
	
	SaleProperty sp;
	Seller Mohammed;
	Buyer Kieth;
	Offer offer;
	
	
	@Before
	public void setup() {
		
		Mohammed = new Seller(1, "Mohammed", "admin@gmail.com");
		
		Kieth = new Buyer(1, "Kieth", "rmit@rmit.rmit");
		
//		sp = new SaleProperty();
	}

	
	//negative
	@Test
	public void offerAcceptAfterDueDate() {
		// add property
		SaleProperty p = Mohammed.addProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 2500);
		
		// kieth intersted in Docklands
		Kieth.addSuburb("Docklands");
		
		// kieth found this unit and liked it and wants to place an offer
		this.offer = new Offer(2500.0);
		Kieth.makeOffer(p, offer); //timer will start
		
		//mohammed gets notified of last offers
		Offer p2 = ((Seller) Mohammed).getOfferByIndex(0);
		
		//checking are there any offer for p property
		assertEquals(p.numberOfOffer(), 1);
		
		//after three day
		offer.oneDay();
		offer.oneDay();
		offer.oneDay();
		offer.oneDay();
		
		//accepting offer after three days wont be accepted
		assertFalse(Mohammed.answerOffer(p, p2));

	}

	
	//positive
	@Test
	public void offerAcceptDuringDueDate() {
		// add property
		SaleProperty p = Mohammed.addProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 3000);
		
		// kieth intersted in Docklands
		Kieth.addSuburb("Docklands");
		
		// kieth found this unit and liked it and wants to place an offer
		this.offer = new Offer(3000.0);
		Kieth.makeOffer(p, offer); //timer will start
		
		//mohammed gets notified of last offers
		Offer p2 = ((Seller) Mohammed).getOfferByIndex(0);
		
		//checking are there any offer for p property
		assertEquals(p.numberOfOffer(), 1);
		
		//after one day
		offer.oneDay();
		
		//accepting offer after one days will be true
		assertTrue(Mohammed.answerOffer(p, p2));
	}
	
	//negative
	@Test
	public void offerAcceptedAndCustumerWithdraw() {
		// add property
		SaleProperty p = Mohammed.addProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 1500);
		
		// kieth intersted in Docklands
		Kieth.addSuburb("Docklands");
		
		// kieth found this unit and liked it and wants to place an offer
		this.offer = new Offer(1500.0);
		Kieth.makeOffer(p, offer); //timer will start
		
		//mohammed gets notified of last offers
		Offer p2 = ((Seller) Mohammed).getOfferByIndex(0);
		
		//checking are there any offer for p property
		assertEquals(p.numberOfOffer(), 1);
		
		
		//a new buyer and another offer to the same property
		Buyer Ali = new Buyer(2, "Ali", "rmit@rmit.rmit");
		
		Ali.makeOffer(p, new Offer(1600.0));
		
		//checking are there any offer for p property
		assertEquals(p.numberOfOffer(), 2);
		
		//after one day
		offer.oneDay();
		
		// Kieth changed his mind and did not like the property
		Kieth.withdrawOffer(p);
		
		//accepting offer after one day but offer does not stand any longer since kieth withdraw it
		//Should return false
		assertFalse(Mohammed.answerOffer(p, p2));
	}
	
	//negative
	@Test
	public void offerAcceptPriceBelowMinimum() {
		// add property
		SaleProperty p = Mohammed.addProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 3000);
		
		// kieth intersted in Docklands
		Kieth.addSuburb("Docklands");
		
		// kieth found this unit and liked it and wants to place an offer
		this.offer = new Offer(2900.0);
		Kieth.makeOffer(p, offer); //timer will start
		
		// we should get null as the price is lower
		assertNull(((Seller) Mohammed).getOfferByIndex(0));
		
		//checking are there any offer for p property which should not be because the price is <
		assertNotEquals(p.numberOfOffer(), 1);
	}
	
	
	//positive
	@Test
	public void offerAcceptPriceHigherMinimum() {
		// add property
		SaleProperty p = Mohammed.addProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 3000);
		
		// kieth intersted in Docklands
		Kieth.addSuburb("Docklands");
		
		// kieth found this unit and liked it and wants to place an offer
		this.offer = new Offer(3100.0);
		Kieth.makeOffer(p, offer); //timer will start
		
		// we should not get null as the price is lower
		assertNotNull(((Seller) Mohammed).getOfferByIndex(0));
		
		//checking are there any offer for p property which should be since the price is >=
		assertEquals(p.numberOfOffer(), 1);
	}

}

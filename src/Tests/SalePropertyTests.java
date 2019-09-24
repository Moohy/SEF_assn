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
	
	Seller Mohammed;
	Buyer Keith;
	Offer offer;
	
	
	@Before
	public void setup() {
		
		Mohammed = new Seller(1, "Mohammed", "admin@gmail.com");
		
		Keith = new Buyer(1, "keith", "rmit@rmit.rmit");
		
	}

	
	//negative
	@Test
	public void testInvalidOfferAcceptanceAfterDueDate() {
		// add property
		SaleProperty property = Mohammed.addProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 2500);
		
		// keith intersted in Docklands
		Keith.addSuburb("Docklands");
		
		// keith found this unit and liked it and wants to place an offer
		this.offer = new Offer(2500.0, property, Keith);
		Keith.makeOffer(property, offer); //timer will start
		
		//checking are there any offer for p property
		assertEquals(property.numberOfOffer(), 1);
		
		//after three days
		offer.oneDay();
		offer.oneDay();
		offer.oneDay();
		offer.oneDay();
		
		//accepting offer after three days wont be accepted and returns false
		assertFalse(Mohammed.answerOffer(offer, true));

	}

	
	//positive
	@Test
	public void testValidOfferAcceptanceDuringDueDate() {
		// add property
		SaleProperty property = Mohammed.addProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 3000);
		
		// keith intersted in Docklands
		Keith.addSuburb("Docklands");
		
		// keith found this unit and liked it and wants to place an offer
		this.offer = new Offer(3000.0, property, Keith);
		Keith.makeOffer(property, offer); //timer will start
		
		//checking are there any offer for p property
		assertEquals(property.numberOfOffer(), 1);
		
		//after one day
		offer.oneDay();
		
		//accepting offer after one day will be true
		assertTrue(Mohammed.answerOffer(offer, true));
	}
	
	//negative
	@Test
	public void testInvalidOfferAcceptanceAfterCustumerWithdraw() {
		// add property
		SaleProperty property = Mohammed.addProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 1500);
		
		// keith intersted in Docklands
		Keith.addSuburb("Docklands");
		
		// keith found this unit and liked it and wants to place an offer
		this.offer = new Offer(1500.0, property, Keith);
		Keith.makeOffer(property, offer); //timer will start
		
		//checking are there any offer for p property
		assertEquals(property.numberOfOffer(), 1);
		
		
		//a new buyer and another offer to the same property
		Buyer Ali = new Buyer(2, "Ali", "rmit@rmit.rmit");
		
		Offer AliOffer = new Offer(1600.0, property, Ali);
		
		Ali.makeOffer(property, AliOffer);
		
		//checking are there any offer for p property
		assertEquals(property.numberOfOffer(), 2);
		
		//after one day
		offer.oneDay();
		
		// keith changed his mind and did not like the property
		Keith.withdrawOffer(property);
		
		//checking number of valid offers after Keith withdrawl 
		assertEquals(property.numberOfValidOffer(), 1);
		
		//checking number of all received offers after Keith withdrawl 
		assertEquals(property.numberOfOffer(), 2);
		
		//accepting offer after one day but offer does not stand any longer since keith withdraw it
		//Should return false
		assertFalse(Mohammed.answerOffer(offer, true));
		
		
	}
	
	//negative
	@Test
	public void testInvalidOfferAcceptancePriceBelowMinimum() {
		// add property
		SaleProperty property = Mohammed.addProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 3000);
		
		// keith intersted in Docklands
		Keith.addSuburb("Docklands");
		
		// keith found this unit and liked it and wants to place an offer
		this.offer = new Offer(2900.0, property, Keith);
		Keith.makeOffer(property, offer); //timer will start
		
		//checking are there any offer for p property which should not be because the price is <
		assertNotEquals(property.numberOfOffer(), 1);
	}
	
	
	//positive
	@Test
	public void testValidOfferAcceptancePriceHigherThanMinimum() {
		// add property
		SaleProperty property = Mohammed.addProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 3000);
		
		// keith intersted in Docklands
		Keith.addSuburb("Docklands");
		
		// keith found this unit and liked it and wants to place an offer
		this.offer = new Offer(2900.0, property, Keith);
		Keith.makeOffer(property, offer); //timer will start
		
		// Ali is also interested
		Buyer Ali = new Buyer(2, "Ali", "rmit@rmit.rmit");
		Offer offer2 = new Offer(2700.0, property, Ali);
		Ali.makeOffer(property, offer2);
		
		//Dev too
		Buyer Dev = new Buyer(3, "Dev", "rmit@rmit.rmit");
		Offer offer3 = new Offer(2000.0, property, Dev);
		Dev.makeOffer(property, offer3);
		
		//and Ahmed
		Buyer Ahmed = new Buyer(4, "Ahmed", "rmit@rmit.rmit");
		Offer offer4 = new Offer(3000.0, property, Ahmed);
		Ahmed.makeOffer(property, offer4);
		
		//Check on number of valid offers will be 1 since Ahmed made an offer >= 3000 and did not withdraw
		assertEquals(property.numberOfValidOffer(), 1);
		
		
		//checking number of all offers should be 1 since none of them are >=
		assertEquals(property.numberOfOffer(), 1);
	}

}

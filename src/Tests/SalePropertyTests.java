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
	
	//valid
	@Test
	public void testAcceptOneOfferFromMaltipleOffers() {
		// add property
		SaleProperty property = Mohammed.addProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 3500);
		
		// keith intersted in Docklands
		Keith.addSuburb("Docklands");
		
		// keith found this unit and liked it and wants to place an offer
		this.offer = new Offer(3400.0, property, Keith, "2019-10-14");
		Keith.makeOffer(property, offer); //timer will start
		
		// Ali is also interested
		Buyer Ali = new Buyer(2, "Ali", "ali@rmit.rmit");
		Offer offer2 = new Offer(3900.0, property, Ali, "2019-10-14");
		Ali.makeOffer(property, offer2);
		assertEquals(property.numberOfValidOffer(), 1); //should not change
		
		//Charles
		Buyer Charles = new Buyer(3, "Charles", "charles@rmit.rmit");
		Offer offer3 = new Offer(4500.0, property, Charles, "2019-10-14");
		Charles.makeOffer(property, offer3);
		assertEquals(property.numberOfValidOffer(), 2);
		
		
		//and Mohammed
		Buyer Mo = new Buyer(4, "Mo", "mohammed@rmit.rmit");
		Offer offer5 = new Offer(3001.0, property, Mo, "2019-10-14");
		Mo.makeOffer(property, offer5);
		assertEquals(property.numberOfValidOffer(), 2);
		
		//after two days
		offer.calculateTime("2019-10-16");
		
		//accepting offer after two days
		assertTrue(Mohammed.answerOffer(offer3, true));
		
		//reject other offers
		assertTrue(Mohammed.answerOffer(offer2, false));
		
	}
	
	//valid
	@Test
	public void testAcceptOnlyOneOffer() {
		// add property
		SaleProperty property = Mohammed.addProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 3500);
		
		// keith intersted in Docklands
		Keith.addSuburb("Docklands");
		
		// keith found this unit and liked it and wants to place an offer
		this.offer = new Offer(3500.0, property, Keith, "2019-10-14");
		Keith.makeOffer(property, offer); //timer will start
		
		// Ali is also interested
		Buyer Ali = new Buyer(2, "Ali", "ali@rmit.rmit");
		Offer offer2 = new Offer(3900.0, property, Ali, "2019-10-14");
		Ali.makeOffer(property, offer2);
		
		//Charles
		Buyer Charles = new Buyer(3, "Charles", "charles@rmit.rmit");
		Offer offer3 = new Offer(4500.0, property, Charles, "2019-10-14");
		Charles.makeOffer(property, offer3);
		
		
		//and Mohammed
		Buyer Mo = new Buyer(4, "Mo", "mohammed@rmit.rmit");
		Offer offer4 = new Offer(3800.0, property, Mo, "2019-10-14");
		Mo.makeOffer(property, offer4);
		
		//after two days
		offer3.calculateTime("2019-10-16");
		
		//accepting offer after two days
		assertTrue(Mohammed.answerOffer(offer3, true));
		
		//accept other offers which should be false since we accept one
		assertFalse(Mohammed.answerOffer(offer2, true));
		assertFalse(Mohammed.answerOffer(offer4, true));
		assertFalse(Mohammed.answerOffer(this.offer, true));
		
	}
	
	//valid
	@Test
	public void testOfferPriceBoundry() {
		// add property
		SaleProperty property = Mohammed.addProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 3000);
		
		// keith intersted in Docklands
		Keith.addSuburb("Docklands");
		
		// keith found this unit and liked it and wants to place an offer
		this.offer = new Offer(9999.0, property, Keith, "2019-10-14");
		Keith.makeOffer(property, offer); //timer will start
		assertEquals(property.numberOfValidOffer(), 1);
		
		// Ali is also interested
		Buyer Ali = new Buyer(2, "Ali", "ali@rmit.rmit");
		Offer offer2 = new Offer(2700.0, property, Ali, "2019-10-14");
		Ali.makeOffer(property, offer2);
		assertEquals(property.numberOfValidOffer(), 1); //should not change
		
		//Charles
		Buyer Charles = new Buyer(3, "Charles", "charles@rmit.rmit");
		Offer offer3 = new Offer(2999.9, property, Charles, "2019-10-14");
		Charles.makeOffer(property, offer3);
		assertEquals(property.numberOfValidOffer(), 1);
		
		//and Ahmed
		Buyer Ahmed = new Buyer(4, "Ahmed", "ahmed@rmit.rmit");
		Offer offer4 = new Offer(3000.0, property, Ahmed, "2019-10-14");
		Ahmed.makeOffer(property, offer4);
		assertEquals(property.numberOfValidOffer(), 2);
		
		//and Mohammed
		Buyer Mohammed = new Buyer(5, "Mohammed", "mohammed@rmit.rmit");
		Offer offer5 = new Offer(3000.1, property, Mohammed, "2019-10-14");
		Mohammed.makeOffer(property, offer5);
		assertEquals(property.numberOfValidOffer(), 3);
		
		//Check on number of valid offers will be 2 since Ahmed made an offer >= 3000 and did not withdraw
		assertEquals(property.numberOfValidOffer(), 3);

	}

	
	//invalid
	@Test
	public void testOfferAcceptanceAfterDueDate() {
		// add property
		SaleProperty property = Mohammed.addProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 2500);
		
		// keith intersted in Docklands
		Keith.addSuburb("Docklands");
		
		// keith found this unit and liked it and wants to place an offer
		this.offer = new Offer(2500.0, property, Keith, "2019-10-14");
		Keith.makeOffer(property, offer); //timer will start
		
		//checking are there any offer for p property
		assertEquals(property.numberOfOffer(), 1);
		
		//after four days
		offer.calculateTime("2019-10-18");
		
		//accepting offer after three days wont be accepted and returns false
		assertFalse(Mohammed.answerOffer(offer, true));

	}

	
	//valid
	@Test
	public void testOfferAcceptanceDuringDueDate() {
		// add property
		SaleProperty property = Mohammed.addProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 3000);
		
		// keith intersted in Docklands
		Keith.addSuburb("Docklands");
		
		// keith found this unit and liked it and wants to place an offer
		this.offer = new Offer(3000.0, property, Keith, "2019-10-14");
		Keith.makeOffer(property, offer); //timer will start
		
		//checking are there any offer for p property
		assertEquals(property.numberOfOffer(), 1);
		
		//after one day
		offer.calculateTime("2019-10-15");
		
		//accepting offer after one day will be true
		assertTrue(Mohammed.answerOffer(offer, true));
	}
	
	//invalid
	@Test
	public void testOfferAcceptanceAfterCustumerWithdraw() {
		// add property
		SaleProperty property = Mohammed.addProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 1500);
		
		// keith intersted in Docklands
		Keith.addSuburb("Docklands");
		
		// keith found this unit and liked it and wants to place an offer
		this.offer = new Offer(1500.0, property, Keith, "2019-10-14");
		Keith.makeOffer(property, offer); //timer will start
		
		//checking are there any offer for p property
		assertEquals(property.numberOfOffer(), 1);
		
		
		//a new buyer and another offer to the same property
		Buyer Ali = new Buyer(2, "Ali", "rmit@rmit.rmit");
		
		Offer AliOffer = new Offer(1600.0, property, Ali, "2019-10-14");
		
		Ali.makeOffer(property, AliOffer);
		
		//checking are there any offer for p property
		assertEquals(property.numberOfOffer(), 2);
		
		//after one day
		offer.calculateTime("2019-10-15");
		
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
	
	//invalid
	@Test
	public void testInvalidAcceptOfferWithPriceBelowMinimum() {
		// add property
		SaleProperty property = Mohammed.addProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 3000);
		
		// keith intersted in Docklands
		Keith.addSuburb("Docklands");
		
		// keith found this unit and liked it and wants to place an offer
		this.offer = new Offer(2900.0, property, Keith, "2019-10-14");
		Keith.makeOffer(property, offer); //timer will start
		
		//checking are there any offer for p property which should not be because the price is <
		assertNotEquals(property.numberOfOffer(), 1);
	}

}

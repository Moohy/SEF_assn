package Property;

import java.util.ArrayList;
import java.util.Collection;

import Offer.Offer;

public class SaleProperty extends Property {

	private double commissionRate = 0;
	private double minPrice;
	
	private Collection<Offer> offers;
	
//	boolean offerAcceptance = false;
//	boolean buyerNotWithdraw = true;
//	boolean deposit= false;
	
	
	public SaleProperty(String address, String suburb, int bedroom, int bathroom, int spaces, PropertyType PT, double minPrice) {
		super(address, suburb, bedroom, bathroom, spaces, PT);
		
		this.minPrice = minPrice;
		
		this.offers = new ArrayList<Offer>();
	}

//	
//	public double commission(double commission) {
//		if(commission > .05 || commission < .02)
//			return this.commission;
//		this.commission = commission;
//		return this.commission;
//	}
	
//	public boolean compilingSection32() {
//		return true;
//	}
//	
//	public double vendorsMinPrice() {
//		return 50000;
//	}
//	
//	public boolean isOfferAccepted(int numDaysSinceInspection, boolean isAccepted) {
//		if(numDaysSinceInspection <= 3 && isAccepted)
//			offerAcceptance = true;
//		return offerAcceptance && buyerNotWithdraw;
//		
//	}
//	
//	public boolean receivedDeposit(boolean isReceived) {
//		if(offerAcceptance && isReceived)
//			deposit = true;
//		return deposit;
//	}
	
	public ArrayList getOffers() {
		return (ArrayList) this.offers;
	}
	
	public void addOffer(Offer offer) {
		offers.add(offer);
	}
	
	public int numberOfOffer() {
		return offers.size();
	}
	
	public double minPrice() {
		return minPrice;
	}
	
}

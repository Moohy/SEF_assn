package Property;

import java.util.ArrayList;
import java.util.Collection;

import Customer.Seller;
import Offer.Offer;
import Sale.Sale;

public class SaleProperty extends Property {

	private double commissionRate = 0;
	private double minPrice;
	private Seller seller;
	private Sale sale;
	private Collection<Offer> offers;
	
	
	public SaleProperty(String address, String suburb, int bedroom, int bathroom, int spaces, PropertyType PT, double minPrice, Seller seller) {
		super(address, suburb, bedroom, bathroom, spaces, PT);
		
		this.seller = seller;
		
		this.sale = null;
		
		this.minPrice = minPrice;
		
		this.offers = new ArrayList<Offer>();
	}
	
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
	public Sale getSale() {
		return this.sale;
	}
	
	public ArrayList<Offer> getOffers() {
		return (ArrayList) this.offers;
	}
	
	public void addOffer(Offer offer) {
		offers.add(offer);
	}
	
	public int numberOfOffer() {
		return offers.size();
	}
	
	public int numberOfValidOffer() {
		int counter = 0;
		for(Offer offer: offers) {
			if(!offer.isWithdraw())
				counter++;
		}
		return counter;
	}
	
	public double minPrice() {
		return minPrice;
	}
	
}

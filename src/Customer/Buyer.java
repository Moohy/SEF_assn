package Customer;

import Property.*;
import Sale.Sale;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import Offer.*;

public class Buyer extends Customer {
	
	private HashMap<Property, Offer> propOffers;
	private Collection<String> suburbsOfInterest;
	private Collection<Sale> sales;

	public Buyer(int id, String name, String email) {
		super(id, name, email);
		
		this.propOffers = new HashMap<Property, Offer>();
		this.suburbsOfInterest = new ArrayList<String>();
		this.sales = new ArrayList<Sale>();
	}
	
	public void makeOffer(SaleProperty property, Offer offer) {
		if(offer.validOffer((int) property.minPrice())) {
			propOffers.put(property, offer);
			property.addOffer(offer);
		}
	}
	
	public void withdrawOffer(Property property) {
		Offer offer = propOffers.get(property);
		offer.withdrawOffer();
		propOffers.put(property, offer);
	}
	
	public void makeDeposit(Property property, double amount) {
		
	}
	
	public void addSuburb(String suburb) {
		suburbsOfInterest.add(suburb);
	}

}

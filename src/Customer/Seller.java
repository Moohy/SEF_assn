package Customer;

import java.util.ArrayList;
import java.util.Collection;

import Offer.Offer;
import Property.*;

public class Seller extends Customer{
	
	private Collection<SaleProperty> properties;
	private Collection<Offer> offers;

	public Seller(int id, String name, String email) {
		super(id, name, email);
		this.properties = new ArrayList<SaleProperty>();
		this.offers = new ArrayList<Offer>();
		// TODO Auto-generated constructor stub
	}
	
	public SaleProperty addProperty(String address, String suburb, int bedroom, int bathroom, int spaces, PropertyType type, Double minPrice){
		SaleProperty p = new SaleProperty(address, suburb, bedroom, bathroom, spaces, type, minPrice);
		this.properties.add(p);
		return p;
	}
	
	public void updateProperty(String address, String suburb, int bedroom, int bathroom, int spaces, PropertyType type, Double minPrice){
		SaleProperty p = new SaleProperty(address, suburb, bedroom, bathroom, spaces, type, minPrice);
		this.properties.add(p);
	}
	
	public Offer getOfferByIndex(int i) {
		offers = ((ArrayList<SaleProperty>) properties).get(properties.size() - 1).getOffers();
		
		return offers != null && offers.size() > i ? ((ArrayList<Offer>) offers).get(i) : null;
//		return ((ArrayList<Offer>) offers).get(i);
	}
	
	public void listOffers() {
		for(Offer o: offers)
			System.out.println(o);
	}
	
	public boolean answerOffer(Property property, Offer offer) {
		boolean x = offer.acceptOffer();
		
		return x;
	}
}

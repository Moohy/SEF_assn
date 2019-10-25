package Customer;

import java.util.ArrayList;
import java.util.Collection;

import Offer.Offer;
import Property.*;

public class Seller extends Customer{
	
	private Collection<SaleProperty> properties;

	public Seller(int id, String name, String email) {
		super(id, name, email);
		this.properties = new ArrayList<SaleProperty>();
	}
	
	public SaleProperty addProperty(String address, String suburb, int bedroom, int bathroom, int spaces, PropertyType type, Double minPrice){
		SaleProperty p = new SaleProperty(address, suburb, bedroom, bathroom, spaces, type, minPrice, this);
		this.properties.add(p);
		return p;
	}
	
	public void updateProperty(String address, String suburb, int bedroom, int bathroom, int spaces, PropertyType type, Double minPrice){
		SaleProperty p = new SaleProperty(address, suburb, bedroom, bathroom, spaces, type, minPrice, this);
		this.properties.add(p);
	}

	
	public boolean answerOffer(Offer offer, boolean accept) {
		if (!accept)
			return offer.rejectOffer();
		boolean x = offer.acceptOffer();
		
		return x;
	}
}

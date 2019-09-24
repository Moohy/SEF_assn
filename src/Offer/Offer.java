package Offer;

import Property.Property;
import Property.SaleProperty;

public class Offer {
	
//	private SaleProperty sp;
	private double price;
	private int date;
	private int acceptedDate;
	private int offerTimer;
	private int acceptedOfferTimer;
	private boolean isAcceptedBySeller = false;
	private boolean isWithdraw = false;


	public Offer(double price) {
		this.price = price;
//		this.sp = sp;
		this.date = 0;
		this.offerTimer = 0; 
	}
	
	public int getDay() {
		return this.offerTimer;
	}
	
	public void oneDay() {
		offerTimer++;
	}
	
	public boolean isWithdraw() {
		return this.isWithdraw;
	}
	
	public void withdrawOffer() {
		isWithdraw = true;
	}
	
	public boolean isAcceptedBySeller() {
		return this.isAcceptedBySeller;
	}
	
	public boolean validOffer(int p) {
		if(price >= p) {
			return true;
		}
		return false;
	}
	
	public boolean acceptOffer() {
		acceptedOfferTimer = offerTimer;
		if(offerTimer <= 3)
			isAcceptedBySeller = true;
		return isAcceptedBySeller && !isWithdraw;
	}
	
	public boolean rejectOffer() {
		isAcceptedBySeller = false;
		return isAcceptedBySeller;
	}
	
	public double price() {
		return price;
	}

}

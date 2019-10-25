package Offer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Customer.Buyer;
import Property.Property;
import Property.SaleProperty;

public class Offer {
	
	private SaleProperty sp;
	private Buyer b;
	private double price;
	private int date;
	private int acceptedDate;
	private int offerTimer;
	private int from;
	private int acceptedOfferTimer;
	private boolean isAcceptedBySeller = false;
	private boolean isWithdraw = false;


	public Offer(double price, SaleProperty sp, Buyer b, String date) {
		this.price = price;
		this.sp = sp;
		this.b =b;
		this.date = 0;
		Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-(\\d{2})");
		Matcher m = pattern.matcher(date);
		String f ="";
       while (m.find()) { 
    	   f = m.group(1);
        } 
       this.from = Integer.parseInt(f);
       this.offerTimer = 0; 
	}
	
	public int getDay() {
		return this.offerTimer;
	}
	
	public void calculateTime(String to) {
		Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-(\\d{2})");
		Matcher m = pattern.matcher(to);

		String t="";
       while (m.find()) { 
    	   t = m.group(1);
        } 
		
		this.offerTimer = Integer.parseInt(t) - this.from;
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
		if(sp.isSold())
			return false;
		acceptedOfferTimer = offerTimer;
		if(offerTimer <= 3) {
			isAcceptedBySeller = true;
			sp.sold();
		}
		return isAcceptedBySeller && !isWithdraw && sp.isSold();
	}
	
	public boolean rejectOffer() {
		isAcceptedBySeller = false;
		return !isAcceptedBySeller;
	}
	
	public double price() {
		return price;
	}

}

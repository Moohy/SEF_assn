package Sale;

import java.util.Collection;

import Customer.*;
import Employee.SaleConsultant;
import Property.SaleProperty;
import Offer.*;

public class Sale {
	
	SaleProperty p;
	Buyer b;
	SaleConsultant saleConsultant;
	double price;
	double commisionRate;
	double bonusRate =.40;
	String saleDate;

	public Sale(SalesConsultant emp, SaleProperty property, Buyer buyer, String date, double price, double commisionRate) {
		p = property;
		b = buyer;
		saleConsultant = emp;
		saleDate = date;
		this.price = price;
		this.commisionRate = commisionRate;	
	}
	
	public double calculateBonus() {
		return bonusRate * calculateCommission();
	}
	
	public double calculateCommission() {
		return price * commisionRate;
	}

}

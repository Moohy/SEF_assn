package Sale;

import java.util.Collection;

import Customer.*;
import Property.SaleProperty;
import Offer.*;

public class Sale {
	
	SaleProperty p;
	Buyer b;
	int price;
	double commissoinRate;
	double bonusRate;
	String saleDate;

	public Sale() {
		// TODO Auto-generated constructor stub
	}
	
	public double calcBonus() {
		return 0.0;
	}
	
	public double calcCommission() {
		return 0.0;
	}

}

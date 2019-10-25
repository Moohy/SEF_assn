package Branch;

import Customer.Customer;
import Inspection.Inspection;
import Offer.Offer;
import Property.Property;

public class Branch {
	
	Property[] properties;
	Inspection[] inspections;
	Offer[] offers;
	Customer[] customers;

	public Branch() {
		
	}
	
	public void notifyCustomer(String msg, Customer c) {
		c.notifyCustomer(msg);
	}

	public void runPayroll(String date) {

	}

}

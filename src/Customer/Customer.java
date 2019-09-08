package Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import Property.Property;

public class Customer {
	
	private String name;
	private String email;
	private int id;
	private Collection<String> suburbs = null;
	private Collection<Property> properties = null;
	private CustomerType CT;
//	private HashMap<Integer, String[]> customers;

	public Customer(int id, String name, String email, CustomerType CT) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.CT = CT;
		if (CT == CustomerType.buy || CT == CustomerType.rent) 
			this.suburbs = new ArrayList<String>();
		else
			this.properties = new ArrayList<Property>();
		
//		customers = new HashMap<Integer, String[]>();
//		customers.put(id, new String[] {name, email});
	}
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public Collection<String> getSuburbs() {
		return suburbs;
	}

	public Collection<Property> getProperties() {
		return properties;
	}

	public CustomerType getCustomerType() {
		return CT;
	}
	
	public boolean addSuburb(String suburb) {
		if (CT == CustomerType.buy || CT == CustomerType.rent) {
			//TODO:add suburb to array suburbs
			suburbs.add(suburb);
			return true;
		}
			
		return false;
	}
	
	public boolean addProperty(Property property) {
		if(CT == CustomerType.sell || CT == CustomerType.lease) {
//			property = Property(address, suburb, bedroom, bathroom, carSpace, PropertyType);
			properties.add(property);
			return true;
		}
		return false;
	}
	
	public boolean editProperties(Property property) {
		return true;
	}
	
	

}

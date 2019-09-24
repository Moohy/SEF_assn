package Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import Property.Property;

public class Customer {
	
	private int id;
	private String name;
	private String email;

	public Customer(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
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

	public void payCustomer() {
		
	}
	
	public String notifyCustomer(String msg) {
		return "";
	}
}

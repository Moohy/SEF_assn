package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Customer.Customer;
import Customer.CustomerType;

public class CustomerTests {
	
	Customer customer1;
	Customer customer2;
	
	@Before
	public void setUp() {
		int id=1;
		customer1 = new Customer(id, "Mohammed", "rmit@rmit.au", CustomerType.buy);
		customer2 = new Customer(++id, "John", "rmitStudent@rmit.au", CustomerType.lease);
	}

	@Test
	public void uniqueIDTest() {
		assertNotEquals(customer1.getId(), customer2.getId());
	}
	
	@Test
	public void customerTypePermissionTest() {
		assertTrue(customer1.addSuburb("Docklands"));
		assertFalse(customer2.addSuburb("CBD"));
		
		ArrayList<String> suburbs = (ArrayList<String>) customer1.getSuburbs();
		assertEquals("Docklands", suburbs.get(0));
		
		suburbs = (ArrayList<String>) customer2.getSuburbs();
		assertNull(suburbs);
	}
}

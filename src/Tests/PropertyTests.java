package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Property.Property;
import Property.PropertyType;

public class PropertyTests {
	
	Property property1;
	Property property2;
	
	@Before
	public void setUp() {
		property1 = new Property("888 Collins st", "Docklands", 1, 1, 0, PropertyType.unit);
		property2 = new Property("123 Bourke st", "Docklands", 4, 3, 2, PropertyType.townhouse);
	}

	@Test
	public void editCarSpace() {
		assertNotEquals(1, property1.getCarSpaceNum());
		property1.setCarSpaceNum(1);
		assertEquals(1, property1.getCarSpaceNum());
	}

	@Test
	public void editBathsNum() {
		assertNotEquals(2, property1.getNumOfBathroom());
		property1.setNumOfBathroom(2);
		assertEquals(2, property1.getNumOfBathroom());
	}

	@Test
	public void editBedsNum() {
		assertNotEquals(3, property1.getNumOfBedroom());
		property1.setNumOfBedroom(3);
		assertEquals(3, property1.getNumOfBedroom());
	}

}

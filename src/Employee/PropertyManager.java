package Employee;

import java.util.ArrayList;
import java.util.Collection;

import Branch.Branch;
import Inspection.Inspection;
import Property.RentalProperty;
import Property.SaleProperty;

public class PropertyManager extends Employee {
	
	private Collection<RentalProperty> renatlProperty;

	public PropertyManager(int id, String name, String email, double salary, boolean isPartTime, Branch branch) {
		super(id, name, email, salary, isPartTime, branch);
		
		this.renatlProperty = new ArrayList<RentalProperty>();
	}

	public void createInspection(RentalProperty rentalProperty, String date, String start, String end) {
		rentalProperty.createIspection(date, start, end);
	}
	
	public void removeInspection(RentalProperty rentalProperty, Inspection insp) {
		rentalProperty.removeInspection(insp);
	}

}

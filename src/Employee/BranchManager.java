package Employee;

import Branch.Branch;
import Property.*;

public class BranchManager extends Employee {

	public BranchManager(int id, String name, String email, double salary, Branch branch) {
		super(id, name, email, salary, true, branch);

	}
	
	public void assignEmployee(Property property, SaleConsultant employee) {
		employee.addSaleProperty((SaleProperty) property);
	}

	public void approvedHours(Employee employee) {
		employee.hoursApproved = true;
	}
}

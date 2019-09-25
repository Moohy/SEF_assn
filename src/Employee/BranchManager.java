package Employee;

import Branch.Branch;
import Property.*;

public class BranchManager extends Employee {

	public BranchManager(int id, String name, String email, double salary, Branch branch) {
		super(id, name, email, salary, true, branch);

	}
	
	public void assignEmployee(Property property, Employee employee) {
		
	}

	public void approvedHours(Employee employee) {
		
	}
}

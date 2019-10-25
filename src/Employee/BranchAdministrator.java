package Employee;

import Branch.Branch;

public class BranchAdministrator extends Employee {

	public BranchAdministrator(int id, String name, String email, double salary, Branch branch) {
		super(id, name, email, salary, true, branch);

	}
	
	public void runPayroll(String date) {
		branch.runPayroll(date);
	}
	
	public void addDocuments(String doc) {
		
	}

}

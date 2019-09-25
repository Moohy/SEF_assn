package Employee;

import Branch.Branch;

public class Employee {
	
	private Branch branch;
	private int id;
	private String name;
	private String email;
	private double salary;
	private boolean isPartTime;
	private double hours;
	private double hoursApproved;
	
	public Employee(int id, String name, String email, double salary, boolean isPartTime, Branch branch) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.isPartTime = isPartTime;
		this.branch = branch;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isPartTime() {
		return isPartTime;
	}

	public void setPartTime(boolean isPartTime) {
		this.isPartTime = isPartTime;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public double getHoursApproved() {
		return hoursApproved;
	}

	public void setHoursApproved(double hoursApproved) {
		this.hoursApproved = hoursApproved;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
	public void proccessPay() {
		
	}
	
	public void resetHoursApproved() {
		hoursApproved = 0;
	}
	
	private void calcSale() {
		
	}
	
	private void payEmployee() {
		
	}
	
	public void approvedHours() {
		
	}
}

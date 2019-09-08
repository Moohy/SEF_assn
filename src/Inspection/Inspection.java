package Inspection;

import Property.Property;

public class Inspection {
	
	private int empId;
	private Property property;
	private String date;
	private String time;
	private boolean status;

	public Inspection(int empId, Property property, String date, String time) {
		this.empId = empId;
		this.property = property;
		this.date = date;
		this.time = time;
		this.status = true;
	}

	public boolean cancelInspection() {
		if (status) {
			this.status = false;
			return true;
		}
		return false;
	}

}

package Inspection;

import Property.Property;

public class Inspection {
	
	private int empId;
	private Property property;
	private String date;
	private String start;
	private String end;
	private boolean status;

	public Inspection(Property property, String date, String start, String end) {
//		this.empId = empId;
		this.property = property;
		this.date = date;
		this.start = start;
		this.end = end;
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

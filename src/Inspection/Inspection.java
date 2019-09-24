package Inspection;

import Property.Property;

public class Inspection {
	
	private Property property;
	private String date;
	private String start;
	private String end;

	public Inspection(Property property, String date, String start, String end) {
		this.property = property;
		this.date = date;
		this.start = start;
		this.end = end;
	}
}

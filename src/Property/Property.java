package Property;

import java.util.ArrayList;
import java.util.Collection;

import Inspection.Inspection;

public class Property {
	
	private int id;
	private String address;
	private String suburb;
	private int bedroom;
	private int bathroom;
	private int spaces;
	private PropertyType pt;
	private Collection<String> documents;
	private Collection<Inspection> inspections;


	public Property(String address, String suburb, int bedroom, int bathroom, int spaces,
			PropertyType PT) {

		this.address = address;
		this.suburb = suburb;
		this.bedroom = bedroom;
		this.bathroom = bathroom;
		this.spaces = spaces;
		this.pt = pt;
		
		documents = new ArrayList<String>();
		inspections = new ArrayList<Inspection>();
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getSuburb() {
		return suburb;
	}


	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}


	public int getNumOfBedroom() {
		return bedroom;
	}


	public void setNumOfBedroom(int bedroom) {
		this.bedroom = bedroom;
	}


	public int getNumOfBathroom() {
		return bathroom;
	}


	public void setNumOfBathroom(int bathroom) {
		this.bathroom = bathroom;
	}


	public int getNumOfCarSpace() {
		return spaces;
	}


	public void setNumOfCarSpace(int spaces) {
		this.spaces = spaces;
	}


	public PropertyType getPT() {
		return pt;
	}


	public void setPT(PropertyType pT) {
		pt = pT;
	}
	
	public void addDocument(String doc){
		this.documents.add(doc);
	}
	
	public void createIspection(String date, String start, String end) {
		Inspection i = new Inspection(this, date, start, end);
	}
	
	public void removeInspection(Inspection insp) {
		inspections.remove(insp);
	}
	
	public void cancelInspections() {
		inspections.removeAll(inspections);
	}
	

}

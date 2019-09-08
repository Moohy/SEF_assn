package Property;

public class Property {
	
	private String address;
	private String suburb;
	private int numOfBedroom;
	private int numOfBathroom;
	private int carSpace;
	private PropertyType PT;


	public Property(String address, String suburb, int numOfBedroom, int numOfBathroom, int carSpace,
			PropertyType PT) {

		this.address = address;
		this.suburb = suburb;
		this.numOfBedroom = numOfBedroom;
		this.numOfBathroom = numOfBathroom;
		this.carSpace = carSpace;
		this.PT = PT;
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
		return numOfBedroom;
	}


	public void setNumOfBedroom(int numOfBedroom) {
		this.numOfBedroom = numOfBedroom;
	}


	public int getNumOfBathroom() {
		return numOfBathroom;
	}


	public void setNumOfBathroom(int numOfBathroom) {
		this.numOfBathroom = numOfBathroom;
	}


	public int getCarSpaceNum() {
		return carSpace;
	}


	public void setCarSpaceNum(int carSpace) {
		this.carSpace = carSpace;
	}


	public PropertyType getPT() {
		return PT;
	}


	public void setPT(PropertyType pT) {
		PT = pT;
	}
	

}

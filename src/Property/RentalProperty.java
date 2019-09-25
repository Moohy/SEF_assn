package Property;

public class RentalProperty extends Property {
	
	int managementFee = 8;
	boolean negotiatedFee = false;
	boolean appAcceptance = false;
	boolean buyerNotWithdraw = true;
	boolean bond = false;

	public RentalProperty(String address, String suburb, int bedroom, int bathroom, int spaces, PropertyType PT) {
		super(address, suburb, bedroom, bathroom, spaces, PT);
		// TODO Auto-generated constructor stub
	}


}

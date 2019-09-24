package RentProperties;

public class RentProperties {
	
	int managementFee = 8;
	boolean negotiatedFee = false;
	boolean appAcceptance = false;
	boolean buyerNotWithdraw = true;
	boolean bond = false;

	public RentProperties() {
		// TODO Auto-generated constructor stub
	}
	
	public int managementFee() {
		//TODO:
		//if customer of more than 1 property managementFee = 7
		// minimum negotiated management fee for customer w/ single property = 6
		// minimum negotiated fee for multi properties cus = 6
		if(negotiatedFee)
			this.managementFee -= 1;
		
		
		return this.managementFee;
	}
	
	public void negotiateFee() {
		if(!negotiatedFee)
			negotiatedFee = true;
	}
	
	public boolean rentApplicationAcceptence(int weeklyRent, int numOfMonths) {
		if(numOfMonths > 6) {
			return true;
		}
		return false;
	}
	
	public boolean acceptApplication(int numOfDays, boolean isAccepted) {
		if(numOfDays <= 3 && isAccepted)
			appAcceptance = true;
		return appAcceptance && buyerNotWithdraw;
	}
	
	public boolean receivedBond(boolean isReceived) {
		appAcceptance = true; //TODO should not do this
		if(appAcceptance && isReceived)
			bond = true;
		return bond;
	}

}

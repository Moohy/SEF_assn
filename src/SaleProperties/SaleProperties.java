package SaleProperties;

public class SaleProperties {
	
	double commission = 0;
	boolean offerAcceptance = false;
	boolean buyerNotWithdraw = true;
	boolean deposit= false;

	public SaleProperties() {
		// TODO Auto-generated constructor stub
	}
	
	public double commission(double commission) {
		if(commission > .05 || commission < .02)
			return this.commission;
		this.commission = commission;
		return this.commission;
	}
	
	public boolean compilingSection32() {
		return true;
	}
	
	public double vendorsMinPrice() {
		return 50000;
	}
	
	public boolean isOfferAccepted(int numDaysSinceInspection, boolean isAccepted) {
		if(numDaysSinceInspection <= 3 && isAccepted)
			offerAcceptance = true;
		return offerAcceptance && buyerNotWithdraw;
		
	}
	
	public boolean receivedDeposit(boolean isReceived) {
		if(offerAcceptance && isReceived)
			deposit = true;
		return deposit;
	}
	
	public boolean getOfferAcceptance() {
		return this.offerAcceptance;
	}
	
}

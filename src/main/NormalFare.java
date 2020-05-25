package main;


public class NormalFare extends Fare {
	
	public NormalFare(double fare) {
		this.fare = fare;
	}
	
	public NormalFare(double fare, String identifier) {
		this.fare = fare;
		this.identifier = identifier;
	}

	@Override
	public String getType() {
		return this.getClass().getName();
	}

	@Override
	public MatchFare createMatch() {
		return new MatchFareNormal();
	}
}

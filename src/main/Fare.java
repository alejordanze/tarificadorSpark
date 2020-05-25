package main;


import java.util.List;

public abstract class Fare {
	
	protected double fare;
	protected String identifier;
	
	public Fare(){
	}
	
	public Fare(double fare){
		this.fare = fare;
	}
	
	public double getFare() {
		return this.fare;
	}
	public abstract String getType();

	public void setFare(float fare) {
		this.fare = fare;
	}

	public String getIdentifier() {
		return this.identifier;
	}
	
	public String setIdentifier(String identifier) {
		return this.identifier = identifier;
	}
	
	public abstract MatchFare createMatch();
}

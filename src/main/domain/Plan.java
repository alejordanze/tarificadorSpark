package main.domain;


import java.util.*;

public abstract class Plan{
	
	List<Fare> fareList = new ArrayList<>();
	Fare normalFare;
	
	public Fare getNormalFare() {
		return normalFare;
	}

	public void setNormalFare(Fare normalFare) {
		this.normalFare = normalFare;
	}

	public List<Fare> getFareList() {
		return fareList;
	}

	public void setFareList(List<Fare> tarifas) {
		this.fareList = tarifas;
	}
	
	public void addFare(Fare fare) {
		fareList.add(fare);
	}
	
	public void removeFare(String identifier) {
		for(Fare fare: this.fareList) {
			if(fare.getIdentifier().compareTo(identifier) == 0) {
				System.out.println(fare.getIdentifier());
				this.fareList.remove(fare);
			}
		}
	}
	
	public abstract double getFare(CDR cdr);	
	
	public double getLowerFare(List<Double> fareList) {
		double lowerFare = -1;
		if(fareList.size() > 1) {
			for( int i = 0 ; i < fareList.size(); i++) {
				if(i + 1 <= fareList.size() - 1) {
					lowerFare = fareList.get(i) < fareList.get(i+1) ? fareList.get(i) : fareList.get(i+1);
				}
			}
		}
		else {
			lowerFare = fareList.get(0);
		}
		return lowerFare;
	}
	public abstract String getStringPlan();
}

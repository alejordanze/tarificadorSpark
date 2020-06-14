package main.domain;


import java.util.ArrayList;
import java.util.List;


public class Wow extends Plan {

	public Wow() {
		setNormalFare(new NormalFare(0.99));
	}
		
	public Wow(double fare) {
		setNormalFare(new NormalFare(fare));
	}
	
	public Wow(Fare fare) {
		setNormalFare(fare);
	}
	
	public Wow(Fare fare, List<Fare> fareList) {
		setFareList(fareList);
		setNormalFare(fare);
	}
	
	@Override
	public double getFare(CDR cdr) {
		FriendRegistry friendRegistry = FriendRegistry.getInstance();
		List<Double> findedFares = new ArrayList<>();
		double findedFare = 0;
		if(!friendRegistry.isNumberFriend(cdr.getOriginPhoneNumber(),cdr.getDestinationPhoneNumber())) {

			for( Fare fare: this.fareList) {
				MatchFare matcher = fare.createMatch();
				findedFare = matcher.getMatchingFare(cdr, fare); 
				if(findedFare != -1) {
					findedFares.add(findedFare);
				}
			}
			if(!findedFares.isEmpty()) {
				findedFare = getLowerFare(findedFares);
				if(findedFare != -1)
					return findedFare;
			}
			findedFare = this.normalFare.getFare();
		}
		return findedFare;
	}
	
	@Override
	public String getStringPlan() {
		return "wow";
	}

}
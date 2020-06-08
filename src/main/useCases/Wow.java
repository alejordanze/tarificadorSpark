package main.useCases;


import java.util.ArrayList;
import java.util.List;

import main.entities.CDR;
import main.entities.FriendRegistry;


public class Wow extends Plan {

	private List<Long> friends = new ArrayList<Long>();
	
	public Wow() {
		setNormalFare(new NormalFare(0.99));
	}
	
	
	public Wow(String friends) {
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

	public List<Long> getFriends() {
		return friends;
	}
	
	public void addFriend(long phoneNumber) {
		this.friends.add(phoneNumber);
	}
	
	public void removeFriend(long phoneNumber) {
		int index = this.friends.indexOf(phoneNumber);
		this.friends.remove(index);
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

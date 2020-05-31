package main.useCases;


import java.util.ArrayList;
import java.util.List;

import main.entities.CDR;


public class Wow extends Plan {

	private List<Long> friends = new ArrayList<Long>();
	
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

	public void setFriends(List<Long> friends) {
		this.friends = friends;
	}
	
	public void addFriend(long phoneNumber) {
		this.friends.add(phoneNumber);
	}
	
	public void removeFriend(long phoneNumber) {
		int index = this.friends.indexOf(phoneNumber);
		this.friends.remove(index);
	}
	
	public boolean isNumberFriend(long phoneNumber) {
		return this.friends.contains(phoneNumber);
	}

	@Override
	public double getFare(CDR cdr) {
		List<Double> findedFares = new ArrayList<>();
		double findedFare = 0;
		if(!isNumberFriend(cdr.getDestinationPhoneNumber())) {
			
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
	
}

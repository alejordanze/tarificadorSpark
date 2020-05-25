package main;


import java.util.ArrayList;
import java.util.List;

public class Prepaid extends Plan {
	
	public Prepaid(double fare){
		setNormalFare(new NormalFare(fare));
	}
	
	public Prepaid(Fare fare){
		setNormalFare(fare);
	}
	
	public Prepaid(Fare fare, List<Fare> fareList){
		setFareList(fareList);
		setNormalFare(fare);
	}
	
	public double getFare(CDR cdr) {
		List<Double> findedFares = new ArrayList<>();
		double findedFare = -1;
		
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
		
		findedFare = normalFare.getFare();
		return findedFare;
	}
}

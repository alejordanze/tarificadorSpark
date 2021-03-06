package main.domain.Plan;


import java.util.*;

import main.domain.CDR;
import main.domain.Fare.Fare;
import main.domain.Fare.NormalFare;
import main.domain.Fare.FareMatchers.MatchFare;

public class Postpaid extends Plan{
	
	public Postpaid() {
		setNormalFare(new NormalFare(1));
	}
	
	public Postpaid(double fare) {
		setNormalFare(new NormalFare(fare));
	}
	
	public Postpaid(Fare fare) {
		setNormalFare(fare);
	}
	
	public Postpaid(Fare fare, List<Fare> fareList) {
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
			return getLowerFare(findedFares);
		}
		
		findedFare = normalFare.getFare();
		return findedFare;
	}

	@Override
	public String getStringPlan() {
		return "postpago";
	}

}

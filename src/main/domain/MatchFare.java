package main.domain;


import java.util.List;

public interface MatchFare {
	
	public double getMatchingFare(CDR cdr, Fare fare);
}
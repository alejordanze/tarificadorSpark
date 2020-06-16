package main.domain;

import main.domain.Plan.Plan;
import main.domain.Plan.Postpaid;
import main.domain.Plan.Prepaid;
import main.domain.Plan.Wow;

public class PlanFactory {
	
	public PlanFactory() {
	}
	
	public static Plan getPlanFromString(String stringPlan){
		
		if(stringPlan.equalsIgnoreCase("wow")) {
			return new Wow();
		}
		if(stringPlan.equalsIgnoreCase("postpago")) {
			return new Postpaid();
		}
		if(stringPlan.equalsIgnoreCase("prepago")) {
			return new Prepaid();
		}
		
		return null;
	}

}

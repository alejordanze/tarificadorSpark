package main.entities;

import java.util.ArrayList;
import java.util.List;

import main.useCases.*;

public class Client{

	public Plan plan;
	public long phoneNumber;
	public String fullName;
	
	public Client(){
	}
		
	public Client(Plan plan, long phoneNumber, String fullName){
		this.plan = plan;
		this.phoneNumber = phoneNumber;
		this.fullName = fullName;
	}
	
	public Client(Long phoneNumber, String fullName, String plan, String friends){
		this.plan = getPlanFromString(plan, friends);
		this.phoneNumber = phoneNumber;
		this.fullName = fullName;
	}
	
	private Plan getPlanFromString(String stringPlan, String friends){
		Plan plan = null;
		if(stringPlan.equalsIgnoreCase("wow")) {
			plan = new Wow(friends);
		}
		if(stringPlan.equalsIgnoreCase("postpago")) {
			plan = new Postpaid();
		}
		if(stringPlan.equalsIgnoreCase("prepago")) {
			plan = new Prepaid();
		}
		return plan;
	}


	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isSamePhoneNumber(long phoneNumber){
		return this.phoneNumber == phoneNumber;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String join() {
		return this.phoneNumber + ", " + this.fullName + ", " + this.plan.getStringPlan();
	}
}

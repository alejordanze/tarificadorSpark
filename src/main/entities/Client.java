package main.entities;

import main.useCases.Plan;

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
		return this.phoneNumber + ", " + this.fullName + ", " + this.plan;
	}
}

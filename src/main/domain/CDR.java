package main.domain;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CDR {

	long originPhoneNumber;
	long destinationPhoneNumber;
	Date date;
	double duration;
	int hour;
	double cost;
	Date dateAdded;

	public CDR(){
		
	}

	public CDR(long originPhoneNumber, long destinationPhoneNumber, int duration, int hour, Date date) {
		this.originPhoneNumber = originPhoneNumber;
		this.destinationPhoneNumber = destinationPhoneNumber;
		this.duration = duration;
		this.hour = hour;
		this.date = date;
	}
	
	public CDR(long originPhoneNumber, long destinationPhoneNumber, String date, String hour, String duration) {
		this.originPhoneNumber = originPhoneNumber;
		this.destinationPhoneNumber = destinationPhoneNumber;
		setDurationFromString(duration);
		setHourFromString(hour);
		this.date = getDateFromString(date);
	}
	

	public CDR(long originPhoneNumber, long destinationPhoneNumber, double duration, int hour, java.sql.Date date, double cost, Date dateAdded) {
		this.originPhoneNumber = originPhoneNumber;
		this.destinationPhoneNumber = destinationPhoneNumber;
		this.duration = duration;
		this.hour = hour;
		this.date = getDateFromMySqlDate(date);
		this.cost = cost;
		this.dateAdded = dateAdded;
	}
	
	public long getOriginPhoneNumber() {
		return originPhoneNumber;
	}
	
	public void setOriginPhoneNumbern(long originPhoneNumber) {
		this.originPhoneNumber = originPhoneNumber;
	}

	public long getDestinationPhoneNumber() {
		return destinationPhoneNumber;
	}

	public void setDestinationPhoneNumber(long destinationPhoneNumber) {
		this.destinationPhoneNumber = destinationPhoneNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getStringDate() {
		String stringDate = "";
		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		DateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
		try {
			 stringDate = formatter1.format(formatter.parse(this.date.toString()));
		} catch (ParseException e) {
			
		}
		return stringDate;
	}
	
	public java.sql.Date getSqlDate() {
		return new java.sql.Date(this.date.getTime()) ;
	}

	public double getDuration() {
		return duration;
	}
	
	public String getStringDuration() {
		return this.splitNumber(duration);
	}
	
	private String splitNumber(double number) {
		String result = Double.toString(number);
		if(result.length() == 3) {
			result = result.substring(0, 1) + ":" + getSeconds(result.substring(2, 3), 10);
		}
		else if(result.length() == 4) {
			result = result.substring(0, 1) + ":" + getSeconds(result.substring(2, 4),100);
		}
		else if(result.length() == 5) {
			result = result.substring(0, 2) + ":" + getSeconds(result.substring(3, 5),100);
		}
		return result;
	}
	
	private String splitHour(int number) {
		String result = Integer.toString(number);
		if(result.length() == 3) {
			result = result.substring(0, 1) + ":" + result.substring(1, 3);
		}
		else {
			result = result.substring(0, 2) + ":" + result.substring(2, 4);
		}
		return result;
	}
	
	public static String getSeconds(String seconds, int divisor) {
		BigDecimal bd2 = new BigDecimal(Double.toString(Double.parseDouble(seconds)/divisor*60));
		bd2 = bd2.setScale(0, RoundingMode.HALF_UP);
		String result = Integer.toString(bd2.intValue());
		return result.length() == 1 ? "0" + result : result;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void setDurationFromString(String duration) {
		String[] split = duration.split(":");
		this.duration = Double.parseDouble(split[0]) + this.round(Double.parseDouble(split[1])/60, 2);
		
	}

	public int getHour() {
		return hour;
	}

	public String getStringHour() {
		return this.splitHour(hour);
	}
	
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	
	public void setHourFromString(String hour) {
		String[] split = hour.split(":");
		this.hour = Integer.parseInt(split[0]+split[1]);
	}
	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	 public Date getDateFromString(String dateString){
	    Date date = new Date();
		try {
			date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
	    return date;
	 }	
	 
	 private double round(double number, int places) {
		 BigDecimal bd = new BigDecimal(Double.toString(number));
		 bd = bd.setScale(places, RoundingMode.HALF_UP);
		 return bd.doubleValue();
	 }
	
	 public Date getDateFromMySqlDate(java.sql.Date date){
		 return new java.util.Date(date.getTime());
	 }
	
	public void calculateCostCall(ClientRegistry clientList) {
		ClientRegistry clientRegistration = clientList;
		Client user = clientRegistration.getClientByNumber(originPhoneNumber);
		double fare = user.getPlan().getFare(this);
		this.cost = this.round(this.duration * fare, 2);
	}
	
	public String join() {
		return this.originPhoneNumber + ", " + this.destinationPhoneNumber + ", " + getStringDate() + ", " + getStringHour() + ", " + getStringDuration() + ", " + this.cost;
	}
	
	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
}

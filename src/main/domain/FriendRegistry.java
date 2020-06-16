package main.domain;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendRegistry {

    private Map<Long, List<Long>> friendList = new HashMap<>();
    private static FriendRegistry friendRegistry = null;
         
    public static FriendRegistry getInstance() {
    	if(friendRegistry == null) {
    		friendRegistry = new FriendRegistry();
    	}
    	return friendRegistry;
    }
    
    public static void setInstance() {
    	friendRegistry = null;
    }
    
    public void setFriends(long ownerPhoneNumber, List<Long> friendsPhoneNumbers) {
    	friendList.put(ownerPhoneNumber, friendsPhoneNumbers);
    }

    public void addFriend(long ownerPhoneNumber, long friendPhoneNumbers) {
    	if(getFriends(ownerPhoneNumber)==null) {
			setFriends(ownerPhoneNumber, asList(friendPhoneNumbers));
		}
		else {
			getFriends(ownerPhoneNumber).add(friendPhoneNumbers);
		}
    } 

    public List<Long> getFriends(long ownerPhoneNumber) {
    	return friendList.get(ownerPhoneNumber) ;
    }
    
	public void removeFriend(long ownerPhoneNumber, long friendPhoneNumber) {
		int index = friendList.get(ownerPhoneNumber).indexOf(friendPhoneNumber);
		friendList.get(ownerPhoneNumber).remove(index);		
	}
	
	public boolean isNumberFriend(long ownerPhoneNumber, long friendPhoneNumber) {
		return friendList.get(ownerPhoneNumber).contains(friendPhoneNumber);
	}
	
	public String getStringFriends(long ownerPhoneNumber) {
		String result = "";
		List<Long> friends= getFriends(ownerPhoneNumber);
		if(friends==null) 
			result = "No tiene numeros amigos";
		else {
			for(int i = 0; i < friends.size(); i++) {
				result += (friends.get(i).toString()) + (i == friends.size() -1 ? "" : ",");
			}
			result = "[" + result + "]";
		}
		return result;
	}
	
	private String verifyFormat(String friends) {
		if(!friends.contains("[")) {
			return friends;
 		}
		return friends.substring(1, friends.length() -1);
	}

	
	public void setFriendsFromString(String ownerPhoneNumber,String friends) {
		List<Long> friendsList = new ArrayList<Long>();
		if(friends.length() > 0 && !friends.equals("No tiene numeros amigos")) {
			friends = verifyFormat(friends);
			String[] list = friends.split(",");
		    for(String text:list) {
		    	friendsList.add(Long.valueOf(text));
		     }
		    setFriends(Long.valueOf(ownerPhoneNumber),friendsList);
		}
	}
}


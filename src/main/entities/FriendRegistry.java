package main.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendRegistry {

    private Map<Long, List<Long>> friendList = new HashMap<Long, List<Long>>();
    private static FriendRegistry friendRegistry = null;
         
    public static FriendRegistry getInstance() {
    	if(friendRegistry == null) {
    		friendRegistry = new FriendRegistry();
    	}
    	return friendRegistry;
    }
    
    public void addFriends(long ownerPhoneNumber, List<Long> friendsPhoneNumbers) {
    	friendList.put(ownerPhoneNumber, friendsPhoneNumbers);
    }

    public void addAFriend(long ownerPhoneNumber, long friendPhoneNumbers) {
    	friendList.get(ownerPhoneNumber).add(friendPhoneNumbers);
    } 

    public List<Long> getFriends(long ownerPhoneNumber) {
    	return friendList.get(ownerPhoneNumber) ;
    }
    
	public void removeFriend(long ownerPhoneNumber, long friendPhoneNumber) {
		friendList.get(ownerPhoneNumber).remove(friendPhoneNumber);
	}
	
	public boolean isNumberFriend(long ownerPhoneNumber, long friendPhoneNumber) {
		return friendList.get(ownerPhoneNumber).contains(friendPhoneNumber);
	}
	
	public String getStringFriends(long ownerPhoneNumber){
		String result = "";
		List<Long> friends= getFriends(ownerPhoneNumber);
		for(int i = 0; i < friends.size(); i++) {
			result += (friends.get(i).toString()) + (i == friends.size() -1 ? "" : ",");
		}
		return result;
	}
	
	public List<Long> getFriendsFromString(String friends) {
		List<Long> friendsList = new ArrayList<Long>();
		if(friends.length() > 0) {
			friends = friends.substring(1, friends.length() - 1);
			String[] list = friends.split(",");
		    for(String text:list) {
		    	friendsList.add(Long.valueOf(text));
		     }
		}
		return friendsList;
	}
}


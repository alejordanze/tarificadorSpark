package main.entities;

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

    public List<Long> getFriends(long ownerPhoneNumber) {
    	return friendList.get(ownerPhoneNumber) ;
    }
}

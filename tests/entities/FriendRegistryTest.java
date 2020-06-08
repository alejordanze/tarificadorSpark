package entities;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.entities.FriendRegistry;

class FriendRegistryTest {
	FriendRegistry friendRegistry;
	Long owner = (long) 77777777;
	Long owner2 = (long) 11111111;
	Long friend1 = (long) 88888888;
	Long friend2 = (long) 99999999;
	Long friend3 = (long) 66666666;
	
	@BeforeEach
	void setUp() {
		FriendRegistry.setInstance();
		friendRegistry = FriendRegistry.getInstance();
	}
	
	@Test
	void setAndGetfriendsRegistryTest() {
		friendRegistry.setFriends(owner, asList(friend1,friend2));
		assertEquals(asList(friend1,friend2),friendRegistry.getFriends(owner));
	}
	
	@Test
	void setAFriendRegistryTest() {
		friendRegistry.addFriend(owner, friend1);
		friendRegistry.addFriend(owner, friend2);
		assertEquals(asList(friend1),friendRegistry.getFriends(owner));
	}
	
	@Test
	void removeFriendTest() {		
		friendRegistry.setFriends(owner, asList(friend1,friend2));
		friendRegistry.removeFriend(owner, friend1);
		assertEquals(asList(friend1,friend2),friendRegistry.getFriends(owner));
	}

	@Test
	void isNumberFriendTest() {
		friendRegistry.setFriends(owner, asList(friend1));
		assertTrue(friendRegistry.isNumberFriend(owner, friend1));
		assertFalse(friendRegistry.isNumberFriend(owner, friend3));
	}
	
	@Test
	void setFriendsFromStringTest() {
		friendRegistry.setFriendsFromString("77777777", "[88888888,99999999]");
		assertEquals(asList(friend1,friend2),friendRegistry.getFriends(owner));
	}
	
	@Test
	void getStringFriendsTest() {
		friendRegistry.setFriends(owner, asList(friend1,friend2));
		String friendsList= friendRegistry.getStringFriends(owner);
		assertEquals("88888888,99999999",friendsList);
	}
	
	@Test
	void getStringNoFriendsTest() {
		String friendsList= friendRegistry.getStringFriends(owner);
		assertEquals("No tiene numeros amigos",friendsList);
	}
	
}

package entities;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.entities.FriendRegistry;

class FriendRegistryTest {

	@Test
	void setAndGetfriendRegistryTest() {
		FriendRegistry friendRegistry = FriendRegistry.getInstance();
		Long owner = (long) 77777777;
		Long friend1 = (long) 88888888;
		Long friend2 = (long) 99999999;
		friendRegistry.addFriends(77777777, asList(friend1,friend2));
		assertEquals(asList(friend1,friend2),friendRegistry.getFriends(owner));
	}

}

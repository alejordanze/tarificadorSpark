package entities;

import static org.junit.jupiter.api.Assertions.*;
import static java.util.Arrays.*;

import org.junit.jupiter.api.Test;

import main.domain.Client;
import main.domain.FriendRegistry;
import main.domain.Plan.Plan;
import main.domain.Plan.Prepaid;

class ClientTest {

	Plan plan = new Prepaid(5);
	Client client = new Client();
	FriendRegistry friendRegistry = FriendRegistry.getInstance();

	@Test
	void setClientTest() {
		Client client2 = new Client(plan,77777777, "Ivy Rocabado");
		client.setPhoneNumber(77777777);
		client.setPlan(plan);
		client.setFullName("Ivy Rocabado");
		assertEquals(client2.getPhoneNumber(), client.getPhoneNumber());
		assertEquals(client2.getPlan(), client.getPlan());
		assertEquals(client2.getFullName(), client.getFullName());
		assertEquals("77777777, Ivy Rocabado, prepago", client.join());
	}
	
	@Test
	void setPhoneNumerTest() {
		client.setPhoneNumber(77777777);
		assertEquals(77777777, client.getPhoneNumber());
	}
	
	@Test
	void isSamePhoneNumberTest() {
		Client client2 = new Client(plan,77777777, "Ivy Rocabado");
		assertEquals(true, client2.isSamePhoneNumber(77777777));
	}
	
	@Test
	void isNotSamePhoneNumberTest() {
		Client client2 = new Client(plan,77777778, "Ivy Rocabado");
		assertEquals(false, client2.isSamePhoneNumber(77777777));
	}
	
	
	@Test
	void setClientPrepaidTest() {
		Client client3 = new Client(77777777, "Ivy Rocabado", "prepago");
		client.setPhoneNumber(77777777);
		client.setFullName("Ivy Rocabado");
		assertEquals(client3.getPhoneNumber(), client.getPhoneNumber());
		assertEquals(client3.getFullName(), client.getFullName());
	}
	
	@Test
	void setClientPostPaidTest() {
		Client client3 = new Client(77777777, "Ivy Rocabado", "postpago");
		client.setPhoneNumber(77777777);
		client.setFullName("Ivy Rocabado");
		assertEquals(client3.getPhoneNumber(), client.getPhoneNumber());
		assertEquals(client3.getFullName(), client.getFullName());
	}
	
	@Test
	void setClientWowWithFriendsTest() {
		Client client3 = new Client(77777777, "Ivy Rocabado", "wow");
		client.setPhoneNumber(77777777);
		client.setFullName("Ivy Rocabado");
		friendRegistry.setFriends(77777777, asList((long)99999999,(long)88888888));
		assertEquals(client3.getPhoneNumber(), client.getPhoneNumber());
		assertEquals(client3.getFullName(), client.getFullName());
	}

}

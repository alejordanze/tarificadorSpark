package test;

import static org.junit.jupiter.api.Assertions.*;
import static java.util.Arrays.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import main.*;

class CDRTest {

	CDR cdr = new CDR();
	CDR cdr2 = new CDR(7777777, 6666666, 2, 1830, new Date(19-04-2020));
	CDR cdr3 = new CDR(8888888, 7777777, 4, 2030, new Date(20-04-2020));
	CDR cdr4 = new CDR(8888888, 7777777, 5, 1400, new Date(20-04-2020));
	CDR cdr5 = new CDR(8888888, 7777776, 10, 1630, new Date(20-04-2020));
	CDR cdr6 = new CDR(8888888, 6666666, 7, 1830, new Date(21-04-2020));
	
	private ClientRegistry reg2 = new ClientRegistry();
	
	private Client cliente = new Client(new Prepaid(2), 7777777);
	private Client cliente2 = new Client(new Postpaid(1), 6666666);
	private Client cliente3 = new Client(new Postpaid(1), 8888888);
	
	Wow plan = new Wow(new NormalFare(3), asList( new FareByHour(5, 1500, 1759), new FareByHour(4, 1800, 2200)));
	
	
	@Test
	void isSameOriginPhoneNumberTest() {
		cdr.setOriginPhoneNumbern(7777777);
		assertEquals(7777777, cdr.getOriginPhoneNumber());
	}

	@Test
	void testFirstCall() {
		plan.addFriend(6666666);
		Client cliente3 = new Client(plan, 8888888);
		reg2.addClient(cliente);
		reg2.addClient(cliente2);
		reg2.addClient(cliente3);
		cdr2.calculateCostCall(reg2);
		assertEquals(4, cdr2.getCost());
	}
	
	@Test
	void testSecondCall() {
		plan.addFriend(6666666);
		Client cliente3 = new Client(plan, 8888888);
		reg2.addClient(cliente);
		reg2.addClient(cliente2);
		reg2.addClient(cliente3);
		cdr3.calculateCostCall(reg2);
		assertEquals(16, cdr3.getCost());
	}
	
	@Test
	void testThirdCall() {
		plan.addFriend(6666666);
		Client cliente3 = new Client(plan, 8888888);
		reg2.addClient(cliente);
		reg2.addClient(cliente2);
		reg2.addClient(cliente3);
		cdr4.calculateCostCall(reg2);
		assertEquals(15, cdr4.getCost());
	}
	
	@Test
	void testFourthCall() {
		plan.addFriend(6666666);
		Client cliente3 = new Client(plan, 8888888);
		reg2.addClient(cliente);
		reg2.addClient(cliente2);
		reg2.addClient(cliente3);
		cdr5.calculateCostCall(reg2);
		assertEquals(50, cdr5.getCost());
	}
	
	@Test
	void testFifthCall() {
		plan.addFriend(6666666);
		Client cliente3 = new Client(plan, 8888888);
		reg2.addClient(cliente);
		reg2.addClient(cliente2);
		reg2.addClient(cliente3);
		cdr6.calculateCostCall(reg2);
		assertEquals(0, cdr6.getCost());
	}
	

	@Test
	void testSixCall() {
		cdr.setDuration(7);
		cdr.setDate(new Date(30-04-2020));
		cdr.setOriginPhoneNumbern(6666666);
		cdr.setDestinationPhoneNumber(8888888);
		cdr.setHour(1900);
		cdr.setCost(0);
		cdr.join();
		assertEquals(7, cdr.getDuration());
		assertEquals(new Date(30-04-2020), cdr.getDate());
		assertEquals(6666666, cdr.getOriginPhoneNumber());
		assertEquals(8888888, cdr.getDestinationPhoneNumber());
		assertEquals(0, cdr.getCost());
	}
}

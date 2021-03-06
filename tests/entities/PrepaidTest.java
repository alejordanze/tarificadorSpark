package entities;

import static org.junit.jupiter.api.Assertions.*;
import static java.util.Arrays.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.*;
import main.domain.CDR;
import main.domain.Client;
import main.domain.ClientRegistry;
import main.domain.Fare.Fare;
import main.domain.Fare.FareByHour;
import main.domain.Fare.NormalFare;
import main.domain.Plan.Prepaid;

class PrepaidTest {

	Prepaid plan;
	CDR llamada = new CDR(7777777, 66666666, 2, 1730, new Date());
	CDR llamada2 = new CDR(8888888, 66666666, 21, 1630, new Date());
	Fare fare = new NormalFare(2, "Normal");
	Fare fare2 = new FareByHour(3, 1330, 1550, "Tardes");
	List<Fare> fares = asList(new FareByHour(1,1000,1400), new FareByHour(2, 1500, 1800));
	
	@Test
	void testFirstConstructor() {
		Prepaid plan = new Prepaid(1.45);
		assertEquals(plan.getNormalFare().getFare(), 1.45);
	}

	@Test
	void testSecondConstructor() {
		Prepaid plan = new Prepaid(new NormalFare(1.2));
		assertEquals(plan.getNormalFare().getFare(), 1.2);
	}
	
	@Test
	void testThirdConstructor() {
		Prepaid plan = new Prepaid(fare,fares);
		assertEquals(plan.getNormalFare().getFare(), 2);
	}
	
	@Test
	void testingGetFare() {
		Prepaid plan = new Prepaid(fare, fares);
		assertEquals(2, plan.getFare(llamada));
	}
	
	@Test
	void testingCall() {
		Prepaid plan = new Prepaid(fare, fares);
		Client cliente = new Client(plan,8888888, "Saskia Sejas");
		ClientRegistry clientList = new ClientRegistry();
		clientList.addClient(cliente);
		llamada2.calculateCostCall(clientList);
		assertEquals(42, llamada2.getCost());
	}
}

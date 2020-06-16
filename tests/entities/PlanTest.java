package entities;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.domain.CDR;
import main.domain.Client;
import main.domain.ClientRegistry;
import main.domain.PlanFactory;
import main.domain.Fare.Fare;
import main.domain.Fare.FareByHour;
import main.domain.Fare.NormalFare;
import main.domain.Plan.Plan;
import main.domain.Plan.Prepaid;

class PlanTest {

	CDR llamada = new CDR(8888888, 77777777, 2, 1730, new Date());
	CDR llamada2 = new CDR(8888888, 66666666, 21, 1630, new Date());
	Fare fare = new NormalFare(2, "Normal");
	List<Fare> fares = asList(new FareByHour(1,1000,1400), new FareByHour(2, 1000, 1400));
	Plan plan = new Prepaid(fare, fares);
	Client cliente = new Client(plan,8888888, "Saskia Sejas");
	ClientRegistry clientList = new ClientRegistry();
	List<Double> fares2 = new ArrayList<>();
	
	@BeforeEach
	void setUp() {
		clientList.addClient(cliente);
		fares2.add(1.2);
		fares2.add(1.7);
		fares2.add(0.99);
	}
	
	@Test
	void testCalculateWithLowerFare() {
		llamada.calculateCostCall(clientList);
		assertEquals(llamada.getCost(), 2, 2);
	}
	
	@Test
	void testLowerFare() {
		llamada.calculateCostCall(clientList);
		assertEquals(plan.getLowerFare(fares2), 0.99, 0.99);
	}
	
	@Test
	void testNullPlan() {
		assertEquals(null, PlanFactory.getPlanFromString("prepaid"));
	}

}

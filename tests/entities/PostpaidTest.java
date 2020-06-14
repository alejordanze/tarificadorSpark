package entities;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static java.util.Arrays.*;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.*;
import main.domain.CDR;
import main.domain.Fare;
import main.domain.FareByHour;
import main.domain.NormalFare;
import main.domain.Postpaid;

class PostpaidTest {
	
	Postpaid plan = new Postpaid(1.3);
	Postpaid plan2 = new Postpaid(1.5);
	
	CDR llamada = new CDR(70209102, 66666666, 2, 1530, new Date());
	CDR llamada2 = new CDR(76464241, 70999948, 10, 2130, new Date());
	Fare fare = new NormalFare(2);
	List<Fare> fares = asList(new FareByHour(1,1000,1400), new FareByHour(2, 1500, 1800));
	
	@Test
	void testFirstConstructor() {
		Postpaid plan = new Postpaid(1.45);
		assertEquals(plan.getNormalFare().getFare(), 1.45, 1.45);
	}

	@Test
	void testSecondConstructor() {
		Postpaid plan = new Postpaid(new NormalFare(1.2));
		assertEquals(plan.getNormalFare().getFare(), 1.2, 1.2);
	}
	
	@Test
	void testThirdConstructor() {
		Postpaid plan = new Postpaid(fare, fares);
		assertEquals(plan.getNormalFare().getFare(), 2, 2);
	}
	
	@Test
	void testingGetFare() {
		Postpaid plan = new Postpaid(fare, fares);
		assertEquals(2, plan.getFare(llamada), plan.getFare(llamada));
	}
	
	@Test 
	void getStringPlanTest() {
		assertEquals("postpago",plan.getStringPlan());
	}
}
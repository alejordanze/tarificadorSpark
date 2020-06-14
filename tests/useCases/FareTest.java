package useCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.Fare;
import domain.NormalFare;

class FareTest {

	@Test
	void constructorWithParametersTest() {
		Fare fare = new NormalFare(0.85);
		assertEquals(0.85,fare.getFare());
	}
	
	@Test
	void constructorWithoutParametersTest() {
		Fare fare = new NormalFare(0.85,"Normal fare 0.85");
		fare.setFare(3.5);
		fare.setIdentifier("Normal fare 3.5");
		assertEquals(3.5,fare.getFare());
		assertEquals("Normal fare 3.5",fare.getIdentifier());
	}

}

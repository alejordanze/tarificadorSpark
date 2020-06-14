package useCases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.Fare;
import domain.FareNames;
import domain.NormalFare;

class NormalFareTest {

	Fare normalFare = new NormalFare(0.85);

	@Test
	void getTypeTest() {
		assertEquals(FareNames.NORMAL_FARE,normalFare.getType());
	}

}

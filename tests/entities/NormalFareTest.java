package entities;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.domain.Fare.Fare;
import main.domain.Fare.FareNames;
import main.domain.Fare.NormalFare;

class NormalFareTest {

	Fare normalFare = new NormalFare(0.85);

	@Test
	void getTypeTest() {
		assertEquals(FareNames.NORMAL_FARE,normalFare.getType());
	}

}

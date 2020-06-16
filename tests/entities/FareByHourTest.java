package entities;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.domain.Fare.Fare;
import main.domain.Fare.FareByHour;
import main.domain.Fare.FareNames;

class FareByHourTest {

	Fare fareByHour = new FareByHour(1,1000,1400);

	@Test
	void getTypeTest() {
		assertEquals(FareNames.FARE_BY_HOUR,fareByHour.getType());
	}
}

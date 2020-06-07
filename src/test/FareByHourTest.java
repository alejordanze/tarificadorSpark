package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FareNames;
import main.useCases.Fare;
import main.useCases.FareByHour;

class FareByHourTest {

	Fare fareByHour = new FareByHour(1,1000,1400);

	@Test
	void getTypeTest() {
		assertEquals(FareNames.FARE_BY_HOUR,fareByHour.getType());
	}
}

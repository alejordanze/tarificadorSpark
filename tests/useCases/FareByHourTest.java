package useCases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.Fare;
import domain.FareByHour;
import domain.FareNames;

class FareByHourTest {

	Fare fareByHour = new FareByHour(1,1000,1400);

	@Test
	void getTypeTest() {
		assertEquals(FareNames.FARE_BY_HOUR,fareByHour.getType());
	}
}

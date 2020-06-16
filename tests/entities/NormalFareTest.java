package entities;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import main.domain.CDR;
import main.domain.Fare.Fare;
import main.domain.Fare.FareNames;
import main.domain.Fare.NormalFare;
import main.domain.Fare.FareMatchers.MatchFareNormal;

class NormalFareTest {

	Fare normalFare = new NormalFare(0.85);
	MatchFareNormal matcher = new MatchFareNormal();
	CDR llamada = new CDR(70209102, 66666666, 2, 1530, new Date());
	@Test
	void getTypeTest() {
		assertEquals(FareNames.NORMAL_FARE,normalFare.getType());
	}
	@Test
	void getNormalFare() {
		assertEquals(matcher.getMatchingFare(llamada, normalFare), 0.85, 0.85);
	}

}

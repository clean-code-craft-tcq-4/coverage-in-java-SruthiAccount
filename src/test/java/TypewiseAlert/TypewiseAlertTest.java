package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TypewiseAlertTest {
	@Test
	public void infersLowBreachAsPerLimits() {
		assertTrue(TypewiseAlert.inferBreach(12, 20, 30) == TypewiseAlert.BreachType.TOO_LOW);
	}

	@Test
	public void infersHighBreachAsPerLimits() {
		assertTrue(TypewiseAlert.inferBreach(42, 20, 30) == TypewiseAlert.BreachType.TOO_HIGH);
	}

	@Test
	public void infersNormalBreachAsPerLimits() {
		assertTrue(TypewiseAlert.inferBreach(25, 20, 30) == TypewiseAlert.BreachType.NORMAL);
	}
}

package TypewiseAlert;

public class PASSIVE_COOLING implements CoolingLimitsInterface {
	int lowerLimit=0;
	int upperLimit=35;
	@Override
	public int getLowerLimit() {
		return lowerLimit;
	}
	@Override
	public int getUpperLimit() {
		return upperLimit;
	}
}


package TypewiseAlert;

public class MED_ACTIVE_COOLING implements CoolingLimitsInterface{
	int lowerLimit=0;
	int upperLimit=40;
	@Override
	public int getLowerLimit() {
		return lowerLimit;
	}
	@Override
	public int getUpperLimit() {
		return upperLimit;
	}
}

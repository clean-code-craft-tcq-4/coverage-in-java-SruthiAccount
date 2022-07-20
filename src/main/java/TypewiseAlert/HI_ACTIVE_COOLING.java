package TypewiseAlert;

public class HI_ACTIVE_COOLING implements CoolingLimitsInterface {
	int lowerLimit=0;
	int upperLimit=45;
	@Override
	public int getLowerLimit() {
		return lowerLimit;
	}
	@Override
	public int getUpperLimit() {
		return upperLimit;
	}
	
}

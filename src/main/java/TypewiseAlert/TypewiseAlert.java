package TypewiseAlert;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class TypewiseAlert 
{
    public enum BreachType {
      NORMAL,
      TOO_LOW,
      TOO_HIGH
    };
    public static BreachType inferBreach(double value, double lowerLimit, double upperLimit) {
      if(value < lowerLimit) {
        return BreachType.TOO_LOW;
      }
      if(value > upperLimit) {
        return BreachType.TOO_HIGH;
      }
      return BreachType.NORMAL;
    }
    public enum CoolingType {
      PASSIVE_COOLING,
      HI_ACTIVE_COOLING,
      MED_ACTIVE_COOLING
    };
   
   
  static Map<String,CoolingLimitsInterface> mapping=new HashMap<String,CoolingLimitsInterface>();
    public static BreachType classifyTemperatureBreach(
        CoolingType coolingType, double temperatureInC) {
      int lowerLimit =mapping.get(coolingType.toString()).getLowerLimit();
      int upperLimit = mapping.get(coolingType.toString()).getUpperLimit();
    
      return inferBreach(temperatureInC, lowerLimit, upperLimit);
    }
    public enum AlertTarget{
      TO_CONTROLLER,
      TO_EMAIL
    };
    public class BatteryCharacter {
      public CoolingType coolingType;
      public String brand;
    }
    public static void setCoolingMap() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    	 for(CoolingType c:CoolingType.values())
         {
        	 Class c1 = Class.forName("TypewiseAlert."+c.toString());
			 CoolingLimitsInterface p1=(CoolingLimitsInterface) c1.newInstance();
         }
			
    }
    public static void checkAndAlert(
        AlertTarget alertTarget, BatteryCharacter batteryChar, double temperatureInC) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
      
    	setCoolingMap();
    	
    	
      BreachType breachType = classifyTemperatureBreach(
        batteryChar.coolingType, temperatureInC
      );

      sendAlert(alertTarget,breachType);
    }
    public static void sendAlert(AlertTarget alertTarget,BreachType breachType) {
    	 switch(alertTarget) {
         case TO_CONTROLLER:
           sendToController(breachType);
           break;
         case TO_EMAIL:
           sendToEmail(breachType);
           break;
       }
    }
    public static void sendToController(BreachType breachType) {
      int header = 0xfeed;
      System.out.printf("%i : %i\n", header, breachType);
    }
    public static void sendToEmail(BreachType breachType) {
      String recepient = "a.b@c.com";
      switch(breachType) {
        case TOO_LOW:
          System.out.printf("To: %s\n", recepient);
          System.out.println("Hi, the temperature is too low\n");
          break;
        case TOO_HIGH:
          System.out.printf("To: %s\n", recepient);
          System.out.println("Hi, the temperature is too high\n");
          break;
      
      }
    }
}

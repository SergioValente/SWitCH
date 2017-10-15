package aula01_02102017;


/**
 * Simple program to convert a value into Celsius or Fahrenheit
 * @author sergiovalente
 *
 */
public class TempConversion {

	public static void main(String[] args) {
	
		double temp = 40;
		
		convertToFahr(temp);
		convertToCelsius(temp);
		
	}
	/**
	 * Calculates and prints the conversion to Fahrenheit
	 * @param t Temperature
	 */
	private static void convertToFahr(double t) {
		System.out.println (t + " converted to Fahrenheit: " + (9.0 / 5 * t + 32));
	}
	/**
	 * Calculates and prints the conversion to Celsius
	 * @param t Temperature
	 */
	private static void convertToCelsius(double t) {
		System.out.println (t + " converted to Celsius: " + (5.0 / 9 * (t - 32)));
	}
}

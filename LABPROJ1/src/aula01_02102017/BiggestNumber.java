package aula01_02102017;

/**
 * Calculates the biggest of three numbers.
 * @author sergiovalente
 *
 */
public class BiggestNumber {

	public static void main(String[] args) {
		
		int a = 30;
		int b = 20;
		int c = 3;
		
		System.out.println("O maior número é o " + Math.max(Math.max(a, b), c));
		
	}

}

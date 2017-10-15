package aula01_02102017;

public class Factorial {

	public static void main(String[] args) {

		long fact = 1;
		int i = 1;
		
		for (i = 2; i <= 17; i++) {
			
			fact *= i;
		}
		
		System.out.println("O factorial de " + (i - 1) + " é igual a " + fact);

	}

}

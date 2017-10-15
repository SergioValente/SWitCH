package aula02_04102017;

public class Factorial {
	
	public static long factorial (int a) {
		
		long fact = 1;
		
		if (a == 0) return -1;
		
		for (int i = a; i > 1; i--)
			fact *= i;
		
		return fact;
	}

}

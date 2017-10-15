package aula03_10102017;

public class Funcoes {

	/**
	 * factorial implemented through recursive algorithm
	 * @param i int number for calculation
	 * @return factorial of i
	 */
	public static int factorial(int i) throws Exception {
		
		int result;
		
		if (i < 0)
			throw new Exception("Não existe factorial de números negativos");
		
		if (i == 0 || i == 1) return 1;
		
		result = factorial(i - 1) * i;
		
		return result;
	}
	
	public static int maior(int a, int b) {
		
		if (a > b) return a;
		else return b;
	}
	
	public static int maior(int a, int b, int c) {
		
		return maior(maior(a, b), c);
	}
	
	public static int maior(int a, int b, int c, int d) {
		
		return maior(maior(maior(a, b), c), d);
	}
	/**
	 * biggest of an array of numbers
	 * @param numeros array of numbers to be compared to one another
	 * @return biggest of all
	 */
	public static int maior(int[] numeros) {
		
		int result = (int) Double.NEGATIVE_INFINITY;
		
		for (int elem: numeros) {
			if (elem > result)
				result = elem;
		}
		return result;
	}
	
	/**
	 * Fibonacci's sequence
	 * @param numero order of Fibonaccis's sequence
	 * @return array with the sequence
	 */
	public static int[] fibonacci(int numero) throws Exception {
		
		if (numero < 2) {
			throw new Exception("O número de elementos da sequência deve ser pelo menos 2.");
		}
		int[] fibonacciSequence = new int[numero];
		
		fibonacciSequence[0] = 0;
		fibonacciSequence[1] = 1;
		
		for (int i = 2; i < fibonacciSequence.length; i++) {
			
			fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
		}
		return fibonacciSequence;
				
	}
	
	public static char[] invertedArray(char[] characters) {
		
		char[] inverted = new char[characters.length];
		
		for (int i = 0; i < characters.length; i++) {
			inverted[i] = characters[(characters.length - 1)- i];
		}
		return inverted;
	}
}

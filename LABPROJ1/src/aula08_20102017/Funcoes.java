package aula08_20102017;

public class Funcoes {
	
	/**
	 * test if a number is prime number using "brute force"
	 * @param num number to be tested
	 * @return true if prime, false if not prime
	 * @throws Exception in case of negative numbers
	 */
	public static boolean isPrimeNumber(int num) throws Exception{
		
		if(num <= 0) throw new Exception();
		
		if ((num == 1) || (num == 2)) return true;
		if ((num % 2 == 0) || (num % 3 == 0)) return false;
		
		for (int i = 5; i <= Math.sqrt(num); i += 2) {
			if (num % i == 0) return false; 
		}
		return true;
	} 

	/**
	 * method to return the sum of a number's individual digits
	 * @param num number to sum up
	 * @return the sum of its digits
	 */
	public static int sumOfDigitsOfNumber(int num) {
		
		int[] numToArray = divideNumberIntoDigits(num);
		
		return sumOfDigits(numToArray);
	}
	
	/**
	 * method to separate a number into its composing digits
	 * @param num number to separate
	 * @return array with the digits
	 */
	public static int[] divideNumberIntoDigits(int num) {
		
		if ((num < 10) && (num > -10)) { //number has only one digit
			int[] numToArray = {num};
			return numToArray;
		}
		
		int[] numToArray = new int[(int) Math.log10(num) + 1];
		int index = numToArray.length - 1;
		
		while(num / 10 > 0) {
			numToArray[index--] = num % 10;
			num /= 10;
		}
		numToArray[0] = num;
		
		return numToArray;
	}
	
	/**
	 * calculate the sum of all the numbers in an array
	 * @param numToArray array with integer numbers
	 * @return sum of all numbers
	 */
	public static int sumOfDigits(int[] numToArray) {
		
		int sum = 0;
		
		for (int i = 0; i < numToArray.length; i++) {
			sum += numToArray[i];
		}
		
		return sum;
	}
	
	/**
	 * Test if a matrix is triangular, wether upper or lower
	 * @param matrix matrix to be tested
	 * @return true if it's triangular, false if it's not
	 */
	public static boolean isTriangularMatrix(int[][] matrix) {
		
		if(!(isSquareMatrix(matrix))) return false;
		if((islowerTriangularMatrix(matrix))) return true;
		if((isUpperTriangularMatrix(matrix))) return true;
		
		return false;
	}
	
	/**
	 * Test if a matrix is square
	 * @param matrix test subject
	 * @return true if it's square, false if it's not a square matrix
	 */
	public static boolean isSquareMatrix(int[][] matrix) {
		
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i].length != matrix.length) return false;
		}
		return true;
	}
	
	/**
	 * Test if a matrix is lower triangular
	 * @param matrix matrix to be tested
	 * @return true if it's lower triangular, false if it's not.
	 */
	public static boolean islowerTriangularMatrix(int[][] matrix) {
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix.length; j++) { // j = i + 1 para percorrer só a parte de cima da matriz!!!!
				if(matrix[i][j] != 0) return false;
			}
		}	
		return true;
	}
	
	/**
	 * Tests if a matrix is upper triangular by calculating its transpose
	 * @param matrix matrix to be tested
	 * @return true if it's upper triangular, false if it's not.
	 */
	public static boolean isUpperTriangularMatrix(int[][] matrix) {
		
		int[][] transpose = aula06_16102017.OperacoesSobreMatrizes.matrizTransposta(matrix);
		
		return islowerTriangularMatrix(transpose);
	}
	
	/**
	 * Calculates a normalized array
	 * @param vector un-normalized array
	 * @return normalized array
	 */
	public static double[] normalizeVector(double[] vector) {
		
		if(minOfVector(vector) == maxOfVector(vector)) return vector;
		
		double[] normalizedVector = new double[vector.length];
		
		for(int i = 0; i < vector.length; i++) {
			normalizedVector[i] = 
					(vector[i] - minOfVector(vector)) / (maxOfVector(vector) - minOfVector(vector));
		}
		
		return normalizedVector;
	}
	
	/**
	 * Finds the min value in an array
	 * @param vector array to find the min value
	 * @return the min value
	 */
	public static double minOfVector(double[] vector) {
		
		double min = Double.POSITIVE_INFINITY;
		
		for(int i = 0; i < vector.length; i++) {
			if (vector[i] < min) {
				min = vector[i];
			}
		}
		return min;
	}
	
	/**
	 * Finds the max value in an array
	 * @param vector array to find the max value
	 * @return max value
	 */
	public static double maxOfVector(double[] vector) {
		
		double max = Double.NEGATIVE_INFINITY;
		
		for(int i = 0; i < vector.length; i++) {
			if (vector[i] > max) {
				max = vector[i];
			}
		}
		return max;
	}
}

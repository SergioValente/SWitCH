package aula08_20102017;

public class Funcoes {
	
	public static boolean isPrimeNumber(int num) throws Exception{
		
		if(num <= 0) throw new Exception();
		//TODO verify conditions and negative numbers
		if ((num == 1) || (num == 2)) return true;
		if ((num % 2 == 0) || (num % 3 == 0)) return false;
		
		for (int i = 5; i <= Math.sqrt(num); i += 2) {
			if (num % i == 0) return false; 
		}
		return true;
	}

	public static int sumOfDigitsOfNumber(int num) {
		
		int[] numToArray = divideNumberIntoDigits(num);
		
		return sumOfDigits(numToArray);
	}
	
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
	
	public static int sumOfDigits(int[] numToArray) {
		
		int sum = 0;
		
		for (int i = 0; i < numToArray.length; i++) {
			sum += numToArray[i];
		}
		return sum;
	}
	
	public static boolean isTriangularMatrix(int[][] matrix) {
		
		if(!(isSquareMatrix(matrix))) return false;
		if((isSuperiorTriangularMatrix(matrix))) return true;
		if((isInferiorTriangularMatrix(matrix))) return true;
		
		return false;
	}
	
	public static boolean isSquareMatrix(int[][] matrix) {
		
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i].length != matrix.length) return false;
		}
		return true;
	}
	
	public static boolean isSuperiorTriangularMatrix(int[][] matrix) {
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix.length; j++) { // j = i + 1 para percorrer só a parte de cima da matriz!!!!
				if(matrix[i][j] != 0) return false;
			}
		}	
		return true;
	}
	
	public static boolean isInferiorTriangularMatrix(int[][] matrix) {
		
		int[][] transpose = aula06_16102017.OperacoesSobreMatrizes.matrizTransposta(matrix);
		
		return isSuperiorTriangularMatrix(transpose);
	}
	
	public static double[] normalizeVector(double[] vector) {
		
		if(minOfVector(vector) == maxOfVector(vector)) return vector;
		
		double[] normalizedVector = new double[vector.length];
		
		for(int i = 0; i < vector.length; i++) {
			normalizedVector[i] = 
					(vector[i] - minOfVector(vector)) / (maxOfVector(vector) - minOfVector(vector));
		}
		
		return normalizedVector;
	}
	
	public static double minOfVector(double[] vector) {
		
		double min = Integer.MAX_VALUE;
		
		for(int i = 0; i < vector.length; i++) {
			if (vector[i] < min) {
				min = vector[i];
			}
		}
		return min;
	}
	
	public static double maxOfVector(double[] vector) {
		
		double max = Integer.MIN_VALUE;
		
		for(int i = 0; i < vector.length; i++) {
			if (vector[i] > max) {
				max = vector[i];
			}
		}
		return max;
	}
}

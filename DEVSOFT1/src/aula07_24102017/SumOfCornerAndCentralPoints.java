package aula07_24102017;

public class SumOfCornerAndCentralPoints {

	
	public static int sumOfPoints (int[][] matrix) {
		
		if (isMatrixOddAndSquare(matrix)) {
			return calculateSumOfCornerAndCentralPoints(matrix);
		}
		else {
			System.out.println("Não é possível fazer operação.");
		}
		return 0;
	}
	public static boolean isMatrixOddAndSquare(int[][] matrix) {
		
		if ((matrix.length % 2 != 1) || (matrix[0].length % 2 != 1)) {
			return false;
		}
		
		for(int i = 0; i < matrix.length; i++) {
			if (matrix[i].length != matrix.length) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int calculateSumOfCornerAndCentralPoints(int[][] matrix) {
		
		return matrix[0][0] + matrix[matrix.length - 1][matrix.length - 1] + 
			matrix[0][matrix.length - 1] + matrix[matrix.length - 1][0] + 
			matrix[matrix.length / 2][matrix.length / 2];
	}
}


package aula09_23102017;

public class ReplaceMatrixPointsWithMean {
	
	public static int[][] replaceMatrixPoints(int[][] matrix) {
		
		int[][] auxiliarMatrix = new int[matrix.length][matrix[0].length];
		
		
		auxiliarMatrix = fillBorderlineValues(matrix);
		//auxiliarMatrix = fillInteriorValues(auxiliarMatrix);
		for (int i = 1; i < matrix.length - 1; i++ ) {
			for (int j = 1; j < matrix[0].length - 1; j++) {
				auxiliarMatrix[i][j] = meanOfFourPoints(matrix, i, j);
			}
		}
		return auxiliarMatrix;
	}
	
	public static int[][] fillBorderlineValues(int[][] matrix) {
		
		int[][] auxiliarMatrix = new int[matrix.length][matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++ ) {
			for (int j = 0; j < matrix[0].length; j++) {
				
				if((i == 0) || (i == matrix.length - 1)) {
					auxiliarMatrix[i][j] = matrix[i][j];
				}
				else if ((j == 0) || (j == matrix[0].length - 1)) {
					auxiliarMatrix[i][j] = matrix[i][j];
				}
			}
		}
		return auxiliarMatrix;
	}
	
	public static int[][] fillInteriorValues(int[][] matrix) {
		
		int[][] auxiliarMatrix = matrix;
		
		for (int i = 1; i < matrix.length - 1; i++ ) {
			for (int j = 1; j < matrix[0].length - 1; j++) {
				auxiliarMatrix[i][j] = meanOfFourPoints(matrix, i, j);
			}
		}
		return auxiliarMatrix;
	}

	public static int meanOfFourPoints(int[][] matrix, int i, int j) {
		
		int sum = 0;
		
		sum = matrix[i - 1][j] + matrix[i][j - 1] + matrix[i][j + 1] + matrix[i + 1][j];
		
		return (int) Math.round((double) sum / 4);
	}
	
	public static int meanOfAllNeighbourPoints(int[][] matrix, int x, int y) {
		
		int sum = 0;
		
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j ++) {
				sum += matrix[i][j];
			}
		}
		return (int) Math.round((double) sum / 9);
	}
	public static int meanOfAllNeighbourPointsExceptCenter(int[][] matrix, int x, int y) {
		
		int sum = 0;
		
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j ++) {
				if ((i != x) || (j != y))
					sum += matrix[i][j];
			}
		}
		return (int) Math.round((double) sum / 8);
	}
}



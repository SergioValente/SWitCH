package aula09_23102017;

public class ReplaceMatrixPointsWithMean {

	/**
	 * method to replace each (possible) point in a matrix with its mean from the four closest points. 
	 * @param matrix source matrix
	 * @return matrix with averaged points
	 */
	public static int[][] replaceMatrixPoints(int[][] matrix) {
		
		int[][] auxiliarMatrix = new int[matrix.length][matrix[0].length];
		
		auxiliarMatrix = fillBorderlineValues(matrix);
		auxiliarMatrix = fillInteriorValues(matrix, auxiliarMatrix);
		//XXX code that works 1
//		for (int i = 1; i < matrix.length - 1; i++ ) {
//			for (int j = 1; j < matrix[0].length - 1; j++) {
//				auxiliarMatrix[i][j] = meanOfFourPoints(matrix, i, j);
//			}
//		}
		return auxiliarMatrix;
	}
	
	/**
	 * method to fill the matrix's borderline points
	 * @param matrix source matrix
	 * @return auxiliar matrix with the border line points equal to the source matrix
	 */
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
	
	/**
	 * method to populate the matrix's interior points (all except borderline points. 
	 * @param matrix source matrix
	 * @param auxiliarMatrix matrix with only the borderline points populated
	 * @return matrix with all (borderline and interior) points filled out.
	 */
	public static int[][] fillInteriorValues(int[][] matrix, int[][] auxiliarMatrix) {
		//XXX code that works 1
		//int[][] auxiliarMatrix = matrix;
		
		for (int i = 1; i < matrix.length - 1; i++ ) {
			for (int j = 1; j < matrix[0].length - 1; j++) {
				auxiliarMatrix[i][j] = meanOfFourPoints(matrix, i, j);
			}
		}
		return auxiliarMatrix;
	}

	/**
	 * auxiliar method to calculate the mean of the closest four points relative to a given point
	 * @param matrix source matrix
	 * @param i line index
	 * @param j column index
	 * @return average of the four closest points to (i,j)
	 */
	public static int meanOfFourPoints(int[][] matrix, int i, int j) {
		
		int sum = 0;
		
		sum = matrix[i - 1][j] + matrix[i][j - 1] + matrix[i][j + 1] + matrix[i + 1][j];
		
		return (int) Math.round((double) sum / 4);
	}
	
	/**
	 * auxiliar method to calculate the average of all neighbour points to (x,y).
	 * @param matrix source matrix
	 * @param x line index
	 * @param y column index
	 * @return average of all sorrounding points of (x,y), including (x,y).
	 */
	
	public static int meanOfAllNeighbourPoints(int[][] matrix, int x, int y) {
		
		int sum = 0;
		
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j ++) {
				sum += matrix[i][j];
			}
		}
		return (int) Math.round((double) sum / 9);
	}
	
	/**
	 * auxiliar method to calculate the average of all neighbour points of (x,y), excluding itself.
	 * @param matrix source matrix
	 * @param x line index
	 * @param y column index
	 * @return average of all - except itself - points of (x,y)
	 */
	
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



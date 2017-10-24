package aula09_23102017;

public class MatrixApplyBiggestMask {

	/**
	 * Given a matrix and a mask size, calculates the mean value of each point, applying the biggest<br> 
	 * possible mask (one that doesn't extend past the matrix's limits)
	 * @param matrix matrix to apply mask
	 * @param userMaskSize mask size given by user
	 * @return matrix with all the points averaged out according to its possible mask (when no mask<br>
	 * could be applied, a copy of the original values was made)
	 */
	public static int[][] applyMask (int[][] matrix, int userMaskSize) {
	
		int[][] auxiliarMatrix = new int[matrix.length][matrix[0].length];
		int maskSize = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				
				maskSize = biggestMaskSize (matrix.length, matrix[0].length, userMaskSize, i, j);
				auxiliarMatrix[i][j] = calculateMeanValueApplyingMask(matrix, maskSize, i, j);	
			}
		}
		
		return auxiliarMatrix;
	}
	
	/**
	 * Method to calculate the biggest mask size applicable, given the size of the matrix and the<br> 
	 * reference points
	 * @param numOfLines number of lines of the matrix
	 * @param numOfColumns number of columns of the matrix
	 * @param maskSize mask size provided by user
	 * @param x line index
	 * @param y column index
	 * @return the biggest mask size applicable or -1, representing no mask can be applied
	 */
	public static int biggestMaskSize (int numOfLines, int numOfColumns, int maskSize, int x, int y) {
		
		if (maskSize % 2 == 0) { // maskSize has to be an odd number.
			maskSize = maskSize - 1;
		}
		
		while (maskSize >= 3) {
			
			//if maskSize doesn't exceed the matrix's limits, return maskSize
			if ((x - maskSize / 2 >= 0) && (x + maskSize / 2 < numOfLines) &&
					(y - maskSize / 2 >= 0) && (y + maskSize / 2 < numOfColumns))
					return maskSize;
			maskSize -= 2;	
		}
		
		return -1; // no mask can be applied in point (x,y)
	}
	
	/**
	 * Method that calculates the mean value of all neighbour points of (x,y), given the mask size
	 * @param matrix source to calculate the mean value
	 * @param maskSize mask size obtained by method biggestMaskSize
	 * @param x line index
	 * @param y column index
	 * @return mean value of neighbour points of (x,y)
	 */
	public static int calculateMeanValueApplyingMask(int[][] matrix, int maskSize, int x, int y) {
	
		int sum  = 0;
		
		if (maskSize == -1) { //if no mask can be applied
			return (matrix[x][y]);
		}
		else {
			for (int i = x - maskSize / 2; i <= x + maskSize / 2; i++) {
				for (int j = y - maskSize / 2; j <= y + maskSize / 2; j++) {
					sum += matrix[i][j];
				}
			}		
		}
		
		return (int) Math.round((double) sum / (maskSize * maskSize));
	}
}

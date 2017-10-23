package aula09_23102017;

public class MatrixApplyBiggestMask {

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
		return -1; //
	}
	
	public static int calculateMeanValueApplyingMask(int[][] matrix, int maskSize, int x, int y) {
	
		int sum  = 0;
		
		if (maskSize == -1) {
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

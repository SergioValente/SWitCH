package aula07_24102017;

public class NumberOcurrencesChar {

	public static int ocurrences (char[][] matrix, char c) {
		
		int numberOfOcurrences = 0;
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == c) {
					numberOfOcurrences++;
				}
			}
		}	
		return numberOfOcurrences;
	}
	
	public static int[] numberOcurrencesBlackWhiteAndFree(char[][] matrix) {
		
		int[] chessPieces = new int [3];
		
		chessPieces[0] = ocurrences(matrix, 'l');
		chessPieces[1] = ocurrences(matrix, 'b');
		chessPieces[2] = ocurrences(matrix, 'w');
		
		return chessPieces;
	}
}

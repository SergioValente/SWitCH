package aula07_24102017;

public class ChessPieceMovement {
	
	//isValidChessBoard
	//populateBoard
	

	public static boolean isValidPawnMovement (char[][] board, char c, int[] inPosition, int[] finalPosition) {
		
		return false;			
	}
	
	public static boolean isValidRookMovement (char[][] board, char c, int[] inPosition, int[] finalPosition) {
		
		//TODO create validation to not exceed the matrix's limits
		
		//diagonal movement not possible
		if ((inPosition[0] != finalPosition[0]) && (inPosition[1] != finalPosition[1])) {
			return false;
		}
		//TODO if clause for movement
		int movement = 1;
		boolean freePositions = false;
		switch (movement) {
			case 1: freePositions = checkLeftToRight(board, inPosition, finalPosition);
					break;
			case 2: freePositions = checkRightToLeft(board, inPosition, finalPosition);
					break;
			case 3: freePositions = checkTopToBottom(board, inPosition, finalPosition);
					break;
			case 4: freePositions = checkBottomToTop(board, inPosition, finalPosition);
					break;
		}
		if(!(freePositions)) return false;
		
		
		if (board[finalPosition[0]][finalPosition[1]] != 'l') {
			if (Character.isLowerCase(c) == Character.isLowerCase(board[finalPosition[0]][finalPosition[1]])) {
				return false;
			}
		}
		return true;			
	}
	
	public static boolean isValidBishopMovement (char[][] board, char c, int[] inPosition, int[] finalPosition) {
		
		return false;			
	}
	
	
	public static boolean isValidKnightMovement (char[][] board, char c, int[] inPosition, int[] finalPosition) {
		
		return false;			
	}
	
	
	public static boolean isValidKingMovement (char[][] board, char c, int[] inPosition, int[] finalPosition) {
		
		return false;			
	}
	
	
	public static boolean isValidQueenMovement (char[][] board, char c, int[] inPosition, int[] finalPosition) {
		
		return false;			
	}
	
	
	public static boolean checkLeftToRight(char[][] board, int[] inPosition, int[] finalPosition) {
		
		for (int j = inPosition[1] + 1; j < finalPosition[1]; j++) {
			if (board[inPosition[0]][j] != 'l') {
					return false;
			}
		}
		return true;
	}
	
	
	public static boolean checkRightToLeft(char[][] board, int[] inPosition, int[] finalPosition) {
		
		for (int j = inPosition[1] - 1; j > finalPosition[1]; j--) {
			if (board[inPosition[0]][j] != 'l') {
					return false;
			}
		}
		return true;
	}
	
	
	public static boolean checkTopToBottom(char[][] board, int[] inPosition, int[] finalPosition) {
		
		for (int i = inPosition[0] + 1; i < finalPosition[0]; i++) {
			if (board[i][inPosition[1]] != 'l') {
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean checkBottomToTop(char[][] board, int[] inPosition, int[] finalPosition) {
		
		for (int i = inPosition[0] - 1; i > finalPosition[0]; i--) {
			if (board[i][inPosition[1]] != 'l') {
				return false;
			}
		}
		return true;
	}
}

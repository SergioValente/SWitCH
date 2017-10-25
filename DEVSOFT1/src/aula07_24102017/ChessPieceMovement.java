package aula07_24102017;

import java.util.*;

public class ChessPieceMovement {
	
	enum movement {LEFT_TO_RIGHT, RIGHT_TO_LEFT, TOP_TO_BOTTOM, BOTTOM_UP, TO_LOWER_RIGHT, TO_LOWER_LEFT,
				   TO_UPPER_RIGHT, TO_UPPER_LEFT};
	static EnumSet<movement> diagonalMovement = EnumSet.of(movement.TO_LOWER_RIGHT, movement.TO_LOWER_LEFT,
			   movement.TO_UPPER_RIGHT, movement.TO_UPPER_LEFT);
	static EnumSet<movement> nonDiagonalMovement = EnumSet.of(movement.LEFT_TO_RIGHT, movement.RIGHT_TO_LEFT,
			   movement.TOP_TO_BOTTOM, movement.BOTTOM_UP);

	
	public static boolean isValidMovement (char[][] board, int[] inPosition, int[] finalPosition) {
		
		char pieceInInitialPosition = board[inPosition[0]][inPosition[1]];
		char pieceInFinalPosition = board[finalPosition[0]][finalPosition[1]];
		movement directionOfMovement;
		
		if(!(initialValidations(board, inPosition, finalPosition))) return false;
		
		directionOfMovement = findDirectionOfMovement(inPosition, finalPosition);
		
		if(!(moveByTheRules(board, directionOfMovement, inPosition, finalPosition))) return false;
		
		if(!(isPathClear(directionOfMovement, board, inPosition, finalPosition))) return false;
		
		return (canPieceOccupyFinalPosition(pieceInInitialPosition, pieceInFinalPosition));			
	}
	
	public static boolean initialValidations(char[][] board, int[] inPos, int[] finPos) {
		
		for(int i = 0; i < 2; i++) {
			if ((inPos[i] < 0) || (inPos[i] >= board.length)) return false;
			if ((finPos[i] < 0 ) || (finPos[i] >= board[0].length)) return false;
		}	
		
		char pieceInInitialPosition = board[inPos[0]][inPos[1]];
		if (pieceInInitialPosition == 'l') return false;
		if (Arrays.equals(inPos, finPos)) return false;
		
			
		return true;
	}

	public static movement findDirectionOfMovement(int[] inPosition, int[] finalPosition) {
		
		if ((inPosition[0] < finalPosition[0]) && (inPosition[1] < finalPosition[1]))
			return movement.TO_LOWER_RIGHT;
		if ((inPosition[0] < finalPosition[0]) && (inPosition[1] > finalPosition[1]))
			return movement.TO_LOWER_LEFT;
		if ((inPosition[0] > finalPosition[0]) && (inPosition[1] < finalPosition[1]))
			return movement.TO_UPPER_RIGHT;
		if ((inPosition[0] > finalPosition[0]) && (inPosition[1] > finalPosition[1]))
			return movement.TO_UPPER_LEFT;
		if ((inPosition[0] == finalPosition[0]) && (inPosition[1] < finalPosition[1]))
			return movement.LEFT_TO_RIGHT;
		if ((inPosition[0] == finalPosition[0]) && (inPosition[1] > finalPosition[1]))
			return movement.RIGHT_TO_LEFT;
		if ((inPosition[0] < finalPosition[0]) && (inPosition[1] == finalPosition[1]))
			return movement.TOP_TO_BOTTOM;
		return movement.BOTTOM_UP; 
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
	
	public static boolean checkMainDiagonal(char[][] board, int[] inPosition, int[] finalPosition) {
		
		if(Math.abs((inPosition[1] - inPosition[0])) != Math.abs((finalPosition[1] - finalPosition[0]))) {
			return false;
		}
		if ((finalPosition[0] - inPosition[0] > 0)) {
			for (int i = inPosition[0] + 1, j = inPosition[1] + 1; i < finalPosition[0] && j < finalPosition[1]; i++, j++) {
				if (board[i][j] != 'l') {
					return false;
				}
			}
		}
		else {
			for (int i = inPosition[0] - 1, j = inPosition[0] - 1; i > finalPosition[0] && j >finalPosition[1]; i--, j--) {
				if (board[i][j] != 'l') {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean checkSecondaryDiagonal(char[][] board, int[] inPosition, int[] finalPosition) {
		
		if(Math.abs((finalPosition[0] - inPosition[0])) != Math.abs((finalPosition[1] - inPosition[1]))) {
			return false;
		}
		if ((finalPosition[0] - inPosition[0] > 0)) {
			for (int i = inPosition[0] + 1, j = inPosition[1] - 1; i < finalPosition[0] && j > finalPosition[1]; i++, j--) {
				if (board[i][j] != 'l') {
					return false;
				}
			}
		}
		else {
			for (int i = inPosition[0] - 1, j = inPosition[1] + 1; i > finalPosition[0] && j < finalPosition[1]; i--, j++) {
				if (board[i][j] != 'l') {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean canPieceOccupyFinalPosition(char pieceInInitialPosition, char pieceInFinalPosition) {
		
		if (pieceInFinalPosition != 'l') {
			if (Character.isLowerCase(pieceInInitialPosition) == Character.isLowerCase(pieceInFinalPosition)) {
				return false;
			}
		}
		return true;	
	}
	
	public static boolean isPathClear(movement mov, char[][] board, int[] inPos, int[] finPos) {
		
		if ((board[inPos[0]][inPos[1]] == 'c') || (board[inPos[0]][inPos[1]] == 'C')) return true;
		
		boolean allFreePositions = false;
		
		switch (mov) {
			case TO_UPPER_LEFT:  
			case TO_LOWER_RIGHT: allFreePositions = checkMainDiagonal(board, inPos, finPos);
					break;
			case TO_UPPER_RIGHT: 
			case TO_LOWER_LEFT:  allFreePositions = checkSecondaryDiagonal(board, inPos, finPos);
					break;
			case LEFT_TO_RIGHT: allFreePositions = checkLeftToRight(board, inPos, finPos);
					break;
			case RIGHT_TO_LEFT: allFreePositions = checkRightToLeft(board, inPos, finPos);
					break;
			case TOP_TO_BOTTOM: allFreePositions = checkTopToBottom(board, inPos, finPos);
					break;
			case BOTTOM_UP: allFreePositions = checkBottomToTop(board, inPos, finPos);
					break;
		}
		return allFreePositions;
	}

	public static boolean moveByTheRules(char[][] board, movement dirOfMov, int[] inPos, int[] finPos) {
		
		char pieceInInPos = board[inPos[0]][inPos[1]];
		boolean specificVal = false;
		
		if ((pieceInInPos == 't') || (pieceInInPos == 'T'))
			specificVal = rookValidations(dirOfMov);
		if ((pieceInInPos == 'b') || (pieceInInPos == 'B'))
			specificVal = bishopValidations(dirOfMov);
		if ((pieceInInPos == 'c') || (pieceInInPos == 'C'))
			specificVal = knightValidations(inPos, finPos);
		if ((pieceInInPos == 'q') || (pieceInInPos == 'Q'))
			specificVal = queenValidations(dirOfMov);
		if ((pieceInInPos == 'r') || (pieceInInPos == 'r'))
			specificVal = kingValidations(inPos, finPos);
		if (pieceInInPos == 'p')
			specificVal = blackPawnValidations(board, dirOfMov, inPos, finPos);
		if (pieceInInPos == 'P')
			specificVal = whitePawnValidations(board, dirOfMov, inPos, finPos);
		
		return specificVal;
	}

	public static boolean rookValidations(movement directionOfMovement) {
		
		if (diagonalMovement.contains(directionOfMovement)) return false;
		
		return true;
	}

	public static boolean bishopValidations(movement directionOfMovement) {

		if (nonDiagonalMovement.contains(directionOfMovement)) return false;
		
		return true;
	}

	public static boolean knightValidations(int[] inPos, int[] finPos) {
		
		if ((Math.abs(finPos[0] - inPos[0]) > 2) || (Math.abs(finPos[1] - inPos[1]) > 2)) return false;
		if ((Math.abs(finPos[0] - inPos[0]) == 2) && (Math.abs(finPos[1] - inPos[1]) != 1)) return false;
		if ((Math.abs(finPos[0] - inPos[0]) == 1) && (Math.abs(finPos[1] - inPos[1]) != 2)) return false;
		
		return true;
	}

	public static boolean queenValidations(movement directionOfMovement) {
		
		//no restrictions of movement other than those previously caught in initialValidations
		
		return true;
	}
	
	public static boolean kingValidations(int[] inPos, int[] finPos) {
		
		if ((Math.abs(inPos[0] - finPos[0]) > 1) || (Math.abs(inPos[1] - finPos[1]) > 1)) return false; 
		
		return true;
	}
	
	public static boolean whitePawnValidations(char[][] board, movement dirOfMov, int[] inPos, int[] finPos) {
		
		char takeOpponentLeft = 'l'; 
		char takeOpponentRight = 'l';
		
		if (inPos[1] > 0) takeOpponentLeft = board[inPos[0] + 1][inPos[1] - 1];
		if (inPos[1] < (board.length - 1)) takeOpponentRight = board[inPos[0] + 1][inPos[1] + 1];
		
		//Só anda para baixo
		if ((dirOfMov != movement.TO_LOWER_LEFT) && (dirOfMov != movement.TO_LOWER_RIGHT) &&
				(dirOfMov != movement.TOP_TO_BOTTOM)) return false;
		//Lateralmente só pode andar 1 casa no máximo
		if (Math.abs(finPos[1] - inPos[1]) > 1) return false;
		//Exceto na linha 1, só pode andar uma casa para baixo no máximo
		if ((inPos[0] != 1) && ((finPos[0] - inPos[0]) != 1)) return false;
		//Na linha 1 só pode andar duas casas no máximo
		if ((inPos[0] == 1) && ((finPos[0] - inPos[0]) > 2)) return false;
		//Só pode andar na vertical se a casa estiver vazia.
		if ((dirOfMov == movement.TOP_TO_BOTTOM) && (board[finPos[0]][finPos[1]] != 'l')) return false;
		//Só pode comer se a posição final tiver uma peça preta.
		if ((dirOfMov == movement.TO_LOWER_LEFT) && 
				((takeOpponentLeft == 'l') || (Character.isUpperCase(takeOpponentLeft)))) return false; 
		if ((dirOfMov == movement.TO_LOWER_RIGHT) && 
				((takeOpponentRight == 'l') || (Character.isUpperCase(takeOpponentRight)))) return false;
		//Na linha 1, só pode andar duas casas se as duas posições estiverem livres.
		if ((inPos[0] == 1) && (finPos[0] - inPos[0] == 2))
			if ((board[finPos[0]][finPos[1]] != 'l') || (board[finPos[0] - 1][finPos[1]] != 'l')) return false;
		
		return true;
	}
	
	public static boolean blackPawnValidations(char[][] board, movement dirOfMov, int[] inPos, int[] finPos) {
			
		char takeOpponentLeft = 'l'; 
		char takeOpponentRight = 'l';
		
		if (inPos[1] > 0) takeOpponentLeft = board[inPos[0] - 1][inPos[1] - 1];
		if (inPos[1] < (board.length - 1)) takeOpponentRight = board[inPos[0] - 1][inPos[1] + 1];
		
		//Só anda para cima
		if ((dirOfMov == movement.TO_LOWER_LEFT) || (dirOfMov == movement.TO_LOWER_RIGHT) ||
				(dirOfMov == movement.TOP_TO_BOTTOM)) return false;
		//Lateralmente só pode andar 1 casa no máximo
		if (Math.abs(finPos[1] - inPos[1]) > 1) return false;
		//Exceto na linha 6, só pode andar uma casa para cima no máximo
		if ((inPos[0] != 6) && ((inPos[0] - finPos[0]) != 1)) return false;
		//Na linha 6 só pode andar duas casas no máximo
		if ((inPos[0] == 6) && ((inPos[0] - finPos[0]) > 2)) return false;
		//Só pode andar na vertical se a casa estiver vazia.
		if ((dirOfMov == movement.BOTTOM_UP) && (board[finPos[0]][finPos[1]] != 'l')) return false;
		//Só pode comer se a posição final tiver uma peça branca.
		if ((dirOfMov == movement.TO_UPPER_LEFT) && 
				((takeOpponentLeft == 'l') || (Character.isLowerCase(takeOpponentLeft)))) return false; 
		if ((dirOfMov == movement.TO_UPPER_RIGHT) && 
				((takeOpponentRight == 'l') || (Character.isLowerCase(takeOpponentRight)))) return false;
		//Na linha 6, só pode andar duas casas se as duas posições estiverem livres.
		if ((inPos[0] == 6) && (inPos[0] - finPos[0] == 2))
			if ((board[finPos[0]][finPos[1]] != 'l') || (board[finPos[0] + 1][finPos[1]] != 'l')) return false;
		
		return true;
	}
}

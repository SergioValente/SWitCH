package aula07_24102017;

import java.util.*;

public class ChessPieceMovement {
	
	enum movement {LEFT_TO_RIGHT, RIGHT_TO_LEFT, TOP_TO_BOTTOM, BOTTOM_UP, TO_LOWER_RIGHT, TO_LOWER_LEFT,
				   TO_UPPER_RIGHT, TO_UPPER_LEFT};
	static EnumSet<movement> diagonalMovement = EnumSet.of(movement.TO_LOWER_RIGHT, movement.TO_LOWER_LEFT,
			   movement.TO_UPPER_RIGHT, movement.TO_UPPER_LEFT);
	static EnumSet<movement> nonDiagonalMovement = EnumSet.of(movement.LEFT_TO_RIGHT, movement.RIGHT_TO_LEFT,
			   movement.TOP_TO_BOTTOM, movement.BOTTOM_UP);
	

	/**
	 * Determines if a chess piece's movement is valid or not
	 * @param board matrix representing the chess board
	 * @param inPosition initial position on the board
	 * @param finalPosition desired position to move the chess piece
	 * @return true if it's a valid move or false if it's not
	 */
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
	
	/**
	 * Checks if initial and final positions are within the board's limits, if they are the same<br>
	 * (ie. no movement) and if there is a chess piece at the initial position
	 * @param board Matrix representing the chess board
	 * @param inPos Initial position of the chess piece
	 * @param finPos Desired Final position of the piece
	 * @return True if it passes the verifications, false if it doesn't
	 */
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

	/**
	 * Finds the piece's direction of movement, according to its initial and final positions.
	 * @param inPosition Piece's initial position.
	 * @param finalPosition Piece's desired final position.
	 * @return The direction of movement (enum <movement>).
	 */
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

	/**
	 * Checks if there's a chess piece between initial position and the slot before final position,<br>
	 * according to the direction of movement.
	 * @param board Matrix representing the chess board.
	 * @param inPosition Initial Position.
	 * @param finalPosition The piece's desired final position.
	 * @return True if the path is clear, false if ther's at least a chess piece impeding the move.
	 */
	public static boolean checkLeftToRight(char[][] board, int[] inPosition, int[] finalPosition) {
		
		for (int j = inPosition[1] + 1; j < finalPosition[1]; j++) {
			if (board[inPosition[0]][j] != 'l') {
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if there's a chess piece between initial position and the slot before final position,<br>
	 * according to the direction of movement.
	 * @param board Matrix representing the chess board.
	 * @param inPosition Initial Position.
	 * @param finalPosition The piece's desired final position.
	 * @return True if the path is clear, false if ther's at least a chess piece impeding the move.
	 */
	public static boolean checkRightToLeft(char[][] board, int[] inPosition, int[] finalPosition) {
		
		for (int j = inPosition[1] - 1; j > finalPosition[1]; j--) {
			if (board[inPosition[0]][j] != 'l') {
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if there's a chess piece between initial position and the slot before final position,<br>
	 * according to the direction of movement.
	 * @param board Matrix representing the chess board.
	 * @param inPosition Initial Position.
	 * @param finalPosition The piece's desired final position.
	 * @return True if the path is clear, false if ther's at least a chess piece impeding the move.
	 */
	public static boolean checkTopToBottom(char[][] board, int[] inPosition, int[] finalPosition) {
		
		for (int i = inPosition[0] + 1; i < finalPosition[0]; i++) {
			if (board[i][inPosition[1]] != 'l') {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if there's a chess piece between initial position and the slot before final position,<br>
	 * according to the direction of movement.
	 * @param board Matrix representing the chess board.
	 * @param inPosition Initial Position.
	 * @param finalPosition The piece's desired final position.
	 * @return True if the path is clear, false if ther's at least a chess piece impeding the move.
	 */
	public static boolean checkBottomToTop(char[][] board, int[] inPosition, int[] finalPosition) {
		
		for (int i = inPosition[0] - 1; i > finalPosition[0]; i--) {
			if (board[i][inPosition[1]] != 'l') {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if there's a chess piece between initial position and the slot before final position,<br>
	 * according to the direction of movement. Also checks if it's the "proper" main diagonal, ie,<br>
	 * it has to travel the same absolute number of slots vertically and horizontally.
	 * @param board Matrix representing the chess board.
	 * @param inPosition Initial Position.
	 * @param finalPosition The piece's desired final position.
	 * @return True if the path is clear, false if ther's at least a chess piece impeding the move.
	 */
	public static boolean checkMainDiagonal(char[][] board, int[] inPosition, int[] finalPosition) {
		
		if(Math.abs((finalPosition[0] - inPosition[0])) != Math.abs((finalPosition[1] - inPosition[1]))) {
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
	
	/**
	 * Checks if there's a chess piece between initial position and the slot before final position,<br>
	 * according to the direction of movement. Also checks if it's the "proper" secondary diagonal, ie,<br>
	 * it has to travel the same absolute number of slots vertically and horizontally.
	 * @param board Matrix representing the chess board.
	 * @param inPosition Initial Position.
	 * @param finalPosition The piece's desired final position.
	 * @return True if the path is clear, false if ther's at least a chess piece impeding the move.
	 */
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
	
	/**
	 * Checks if the final position is clear or has an opponent piece
	 * @param pieceInInitialPosition Character representing the piece at the inital position.
	 * @param pieceInFinalPosition Character representing the piece (or lack thereof, represented by 'l').
	 * @return True if the piece at the initial position can occupy the final position, false if it cannot.
	 */
	public static boolean canPieceOccupyFinalPosition(char pieceInInitialPosition, char pieceInFinalPosition) {
		
		if (pieceInFinalPosition != 'l') {
			if (Character.isLowerCase(pieceInInitialPosition) == Character.isLowerCase(pieceInFinalPosition)) {
				return false;
			}
		}
		return true;	
	}
	
	/**
	 * Selects and calls the appropriate method to ascertain if the path between the piece's initial<br>
	 * position and the slot before the final position is clear. Exempts the knight from this verification<br>
	 * as the knight can "leap" over all the chess pieces. 
	 * @param mov The direction of movement.
	 * @param board Matrix representing the chess board.
	 * @param inPos Initial Position.
	 * @param finPos The desired final position.
	 * @return True if the path is clear, false if it's not.
	 */
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

	/**
	 * Selects the specific rules of valid moves, according to each piece.
	 * @param board Matrix representing the chess board. 
	 * @param dirOfMov The direction of movement.
	 * @param inPos Initial position.
	 * @param finPos Desired final position.
	 * @return True if movement is by the rules, false if it's not.
	 */
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

	/**
	 * Validates rook's movements.
	 * @param directionOfMovement The direction of movement. 
	 * @return True if it's a valid rook move, false if it is not.
	 */
	public static boolean rookValidations(movement directionOfMovement) {
		
		if (diagonalMovement.contains(directionOfMovement)) return false;
		
		return true;
	}

	/**
	 * Validates bishop's movements.
	 * @param directionOfMovement The direction of movement. 
	 * @return True if it's a valid bishop move, false if it is not.
	 */
	public static boolean bishopValidations(movement directionOfMovement) {

		if (nonDiagonalMovement.contains(directionOfMovement)) return false;
		
		return true;
	}

	/**
	 * Validates knight's movements.
	 * @param inPos Initial position.
	 * @param finPos The desired final position.
	 * @return True if it's a valid knight move, false if it's not.
	 */
	public static boolean knightValidations(int[] inPos, int[] finPos) {
		
		if ((Math.abs(finPos[0] - inPos[0]) > 2) || (Math.abs(finPos[1] - inPos[1]) > 2)) return false;
		if ((Math.abs(finPos[0] - inPos[0]) == 2) && (Math.abs(finPos[1] - inPos[1]) != 1)) return false;
		if ((Math.abs(finPos[0] - inPos[0]) == 1) && (Math.abs(finPos[1] - inPos[1]) != 2)) return false;
		
		return true;
	}

	/**
	 * Empty method.
	 * @param directionOfMovement The direction of movement.
	 * @return True.
	 */
	public static boolean queenValidations(movement directionOfMovement) {
		
		//no restrictions of movement other than those previously caught in initialValidations
		
		return true;
	}
	
	/**
	 * Validates the king's movements.
	 * @param inPos Initial position.
	 * @param finPos The desired final position.
	 * @return True if it's a valid king move, false if it's not.
	 */
	public static boolean kingValidations(int[] inPos, int[] finPos) {
		
		if ((Math.abs(inPos[0] - finPos[0]) > 1) || (Math.abs(inPos[1] - finPos[1]) > 1)) return false; 
		
		return true;
	}
	
	/**
	 * Validates the white pawn's movements. More complex than the other pieces.
	 * @param board Matrix representing the chess board.
	 * @param dirOfMov The direction of movement.
	 * @param inPos The initial position.
	 * @param finPos The desired final position.
	 * @return True if it's a valid white pawn's move, false if it's not.
	 */
	public static boolean whitePawnValidations(char[][] board, movement dirOfMov, int[] inPos, int[] finPos) {
		
		char takeOpponentLeft = 'l'; 
		char takeOpponentRight = 'l';
		
		if (inPos[1] > 0) takeOpponentLeft = board[inPos[0] + 1][inPos[1] - 1];
		if (inPos[1] < (board.length - 1)) takeOpponentRight = board[inPos[0] + 1][inPos[1] + 1];
		
		//Only moves down
		if ((dirOfMov != movement.TO_LOWER_LEFT) && (dirOfMov != movement.TO_LOWER_RIGHT) &&
				(dirOfMov != movement.TOP_TO_BOTTOM)) return false;
		//Sideways, can only move by one slot
		if (Math.abs(finPos[1] - inPos[1]) > 1) return false;
		//Except on line one, pawn can only move by one slot down
		if ((inPos[0] != 1) && ((finPos[0] - inPos[0]) != 1)) return false;
		//On line one, pawn can move by two slots down, at most
		if ((inPos[0] == 1) && ((finPos[0] - inPos[0]) > 2)) return false;
		//Can move down, only if the slots are unoccupied.
		if ((dirOfMov == movement.TOP_TO_BOTTOM) && (board[finPos[0]][finPos[1]] != 'l')) return false;
		//Can move diagonally, only if the desired slot has an opponent piece in it
		if ((dirOfMov == movement.TO_LOWER_LEFT) && 
				((takeOpponentLeft == 'l') || (Character.isUpperCase(takeOpponentLeft)))) return false; 
		if ((dirOfMov == movement.TO_LOWER_RIGHT) && 
				((takeOpponentRight == 'l') || (Character.isUpperCase(takeOpponentRight)))) return false;
		//On line one, can move by two slots down, only if the path is totally clear
		if ((inPos[0] == 1) && (finPos[0] - inPos[0] == 2))
			if ((board[finPos[0]][finPos[1]] != 'l') || (board[finPos[0] - 1][finPos[1]] != 'l')) return false;
		
		return true;
	}
	
	/**
	 * Validates the black pawn's movements. More complex than the other pieces.
	 * @param board Matrix representing the chess board.
	 * @param dirOfMov The direction of movement.
	 * @param inPos The initial position.
	 * @param finPos The desired final position.
	 * @return True if it's a valid black pawn's move, false if it's not.
	 */
	public static boolean blackPawnValidations(char[][] board, movement dirOfMov, int[] inPos, int[] finPos) {
			
		char takeOpponentLeft = 'l'; 
		char takeOpponentRight = 'l';
		
		if (inPos[1] > 0) takeOpponentLeft = board[inPos[0] - 1][inPos[1] - 1];
		if (inPos[1] < (board.length - 1)) takeOpponentRight = board[inPos[0] - 1][inPos[1] + 1];
		
		//Only moves up
		if ((dirOfMov == movement.TO_LOWER_LEFT) || (dirOfMov == movement.TO_LOWER_RIGHT) ||
				(dirOfMov == movement.TOP_TO_BOTTOM)) return false;
		//Sideways, can only move by one slot
		if (Math.abs(finPos[1] - inPos[1]) > 1) return false;
		//Except on line six, pawn can only move by one slot up
		if ((inPos[0] != 6) && ((inPos[0] - finPos[0]) != 1)) return false;
		//On line six, pawn can move by two slots up, at most
		if ((inPos[0] == 6) && ((inPos[0] - finPos[0]) > 2)) return false;
		//Can move up, only if the slots are unoccupied.
		if ((dirOfMov == movement.BOTTOM_UP) && (board[finPos[0]][finPos[1]] != 'l')) return false;
		//Can move diagonally, only if the desired slot has an opponent piece in it
		if ((dirOfMov == movement.TO_UPPER_LEFT) && 
				((takeOpponentLeft == 'l') || (Character.isLowerCase(takeOpponentLeft)))) return false; 
		if ((dirOfMov == movement.TO_UPPER_RIGHT) && 
				((takeOpponentRight == 'l') || (Character.isLowerCase(takeOpponentRight)))) return false;
		//On line six, can move by two slots up, only if the path is totally clear
		if ((inPos[0] == 6) && (inPos[0] - finPos[0] == 2))
			if ((board[finPos[0]][finPos[1]] != 'l') || (board[finPos[0] + 1][finPos[1]] != 'l')) return false;
		
		return true;
	}
	
	/**
	 * Moves piece to the desired position.
	 * @param board Matrix representing chess board.
	 * @param inPos Initial Position.
	 * @param finPos Piece's desired final position.
	 * @return Chess board with movement executed.
	 */
	public static char[][] movePiece(char[][] board, int[] inPos, int[] finPos) {
		
			char pieceInInitialPosition = board[inPos[0]][inPos[1]];
		
			board[inPos[0]][inPos[1]] = 'l';
			board[finPos[0]][finPos[1]] = pieceInInitialPosition;
		
			return board;
	}
}

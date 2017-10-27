package aula07_24102017;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

import aula07_24102017.ChessPieceMovement.movement;

public class ChessPieceMovementTest {

	// Tests to validade main method isValidMovement
	@Test
	public void testIsValidMovementLeftToRight() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'T','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'p','p','p','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {2,0};
		int[] finalPosition = {2,2};
		boolean result = ChessPieceMovement.isValidMovement(board, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsValidMovementRightToLeft() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','T','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'p','p','p','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {3,3};
		int[] finalPosition = {3,1};
		boolean result = ChessPieceMovement.isValidMovement(board, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsValidMovementTopToBottom() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'T','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'p','p','p','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {2,0};
		int[] finalPosition = {5,0};
		boolean result = ChessPieceMovement.isValidMovement(board, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsValidMovementBottomToUp() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','T','l','l','l','l'},
						 {'p','p','p','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {5,3};
		int[] finalPosition = {2,3};
		boolean result = ChessPieceMovement.isValidMovement(board, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsValidMovementMainDiagonalTopToBottom() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'T','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'p','p','p','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {2,0};
		int[] finalPosition = {5,3};
		boolean result = ChessPieceMovement.isValidMovement(board, inPosition, finalPosition);
		
		assertFalse(result);
	}
	
	@Test
	public void testIsValidMovementMainDiagonalBottomUp() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','T','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'p','p','p','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {4,4};
		int[] finalPosition = {2,2};
		boolean result = ChessPieceMovement.isValidMovement(board, inPosition, finalPosition);
		
		assertFalse(result);
	}
	
	@Test
	public void testIsValidMovementSecondaryDiagonalTopToBottom() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','T','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'p','p','p','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {4,2};
		int[] finalPosition = {5,1};
		boolean result = ChessPieceMovement.isValidMovement(board, inPosition, finalPosition);
		
		assertFalse(result);
	}
	
	@Test
	public void testIsValidMovementSecondaryDiagonalBottomUp() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','T','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'p','p','p','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {4,2};
		int[] finalPosition = {2,4};
		boolean result = ChessPieceMovement.isValidMovement(board, inPosition, finalPosition);
		
		assertFalse(result);
	}
	
	@Test
	public void testIsValidMovementTakeOpponentTopToBottom() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','T','l','l','l','l'},
						 {'p','p','p','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {5,3};
		int[] finalPosition = {6,3};
		boolean result = ChessPieceMovement.isValidMovement(board, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsValidMovementTakeOpponentBottomUp() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'l','l','l','p','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','T','l','l','l','l'},
						 {'p','p','p','p','l','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {5,3};
		int[] finalPosition = {2,3};
		boolean result = ChessPieceMovement.isValidMovement(board, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsValidMovementTakeOpponentLeftToRight() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'l','l','l','p','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','T','l','p','l','l'},
						 {'p','p','p','p','p','l','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {5,3};
		int[] finalPosition = {5,5};
		boolean result = ChessPieceMovement.isValidMovement(board, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	//Tests to validate method initialValidations
	@Test
	public  void testInitialValidationsReturnsTrue() {
	
		char[][] board = {{'T','C','B','R','Q','B','C','T'},
						  {'P','P','P','P','P','P','P','P'},
						  {'l','l','l','p','l','l','l','l'},
						  {'l','l','l','l','l','l','l','l'},
						  {'l','l','l','l','l','l','l','l'},
						  {'l','l','l','l','l','p','l','l'},
						  {'p','p','p','p','p','l','p','p'},
						  {'t','c','b','q','r','b','c','t'}};
		int[] inPos = {0,0};
		int[] finPos = {7,7}; 
	    boolean result = ChessPieceMovement.initialValidations(board, inPos, finPos);
	    assertTrue(result);
	}
	
	@Test
	public  void testInitialValidationsInitialPositionFree() {
	
		char[][] board = {{'T','C','B','R','Q','B','C','T'},
						  {'P','P','P','P','P','P','P','P'},
						  {'l','l','l','p','l','l','l','l'},
						  {'l','l','l','l','l','l','l','l'},
						  {'l','l','l','l','l','l','l','l'},
						  {'l','l','l','l','l','p','l','l'},
						  {'p','p','p','p','p','l','p','p'},
						  {'t','c','b','q','r','b','c','t'}};
		int[] inPos = {3,2};
		int[] finPos = {5,7}; 
	    boolean result = ChessPieceMovement.initialValidations(board, inPos, finPos);
	    assertFalse(result);
	}
	
	@Test
	public  void testInitialValidationsReturnInitialPositionOutOfBounds() {
	
		char[][] board = {{'T','C','B','R','Q','B','C','T'},
						  {'P','P','P','P','P','P','P','P'},
						  {'l','l','l','p','l','l','l','l'},
						  {'l','l','l','l','l','l','l','l'},
						  {'l','l','l','l','l','l','l','l'},
						  {'l','l','l','l','l','p','l','l'},
						  {'p','p','p','p','p','l','p','p'},
						  {'t','c','b','q','r','b','c','t'}};
		int[] inPos = {9,0};
		int[] finPos = {7,7}; 
	    boolean result = ChessPieceMovement.initialValidations(board, inPos, finPos);
	    assertFalse(result);
	}
	
	@Test
	public  void testInitialValidationsReturnFinalPositionOutOfBounds() {
	
		char[][] board = {{'T','C','B','R','Q','B','C','T'},
						  {'P','P','P','P','P','P','P','P'},
						  {'l','l','l','p','l','l','l','l'},
						  {'l','l','l','l','l','l','l','l'},
						  {'l','l','l','l','l','l','l','l'},
						  {'l','l','l','l','l','p','l','l'},
						  {'p','p','p','p','p','l','p','p'},
						  {'t','c','b','q','r','b','c','t'}};
		int[] inPos = {0,7};
		int[] finPos = {1,-3}; 
	    boolean result = ChessPieceMovement.initialValidations(board, inPos, finPos);
	    assertFalse(result);
	}

	// Tests to validate method checkLeftToRight
	@Test
	public  void testCheckLeftToRightTrue() {
		
		char[][] board = {{'l','l','B','R','Q','B','C','T'},
						{'P','P','P','P','P','P','P','P'},
						{'T','l','C','l','l','l','l','l'},
						{'l','l','l','l','l','l','l','l'},
						{'l','l','l','l','l','l','l','l'},
						{'l','l','l','l','l','l','l','l'},
						{'p','p','p','p','p','p','p','p'},
						{'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {0,0};
		int[] finalPosition = {0,1};
		boolean result = ChessPieceMovement.checkLeftToRight(board, inPosition, finalPosition);

		assertTrue(result);
	}
	
	@Test
	public  void testCheckLeftToRightFalse() {
		
		char[][] board = {{'T','C','B','R','Q','B','C','T'},
						{'P','P','P','P','P','P','P','P'},
						{'l','l','l','l','l','l','l','l'},
						{'l','l','l','l','P','l','l','l'}, //not all 'l'
						{'l','l','l','l','l','l','l','l'},
						{'l','l','l','l','l','l','l','l'},
						{'p','p','p','p','p','p','p','p'},
						{'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {3,2};
		int[] finalPosition = {3,5};
		boolean result = ChessPieceMovement.checkLeftToRight(board, inPosition, finalPosition);

		assertFalse(result);
	}
	
	// Tests to validate method checkRightToLeft
	@Test
	public  void testCheckRightToLeftTrue() {
	
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
				 		{'P','P','P','P','P','P','P','P'},
				 		{'l','l','l','l','l','l','l','l'},
				 		{'l','l','l','T','l','l','l','l'},
				 		{'l','l','l','l','l','l','l','l'},
				 		{'l','l','l','l','l','l','l','l'},
				 		{'p','p','p','p','p','p','p','p'},
				 		{'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {3,3};
		int[] finalPosition = {3,0};
		boolean result = ChessPieceMovement.checkRightToLeft(board, inPosition, finalPosition);

		assertTrue(result);
	}
	
	@Test
	public  void testCheckRightToLeftFalse() {
	
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
				 		{'P','P','P','P','P','P','P','P'},
				 		{'l','l','l','l','l','l','l','l'},
				 		{'l','l','l','T','l','l','l','l'},
				 		{'l','l','l','l','l','l','l','l'},
				 		{'l','l','l','l','l','l','l','l'},
				 		{'p','p','p','p','p','p','p','p'},
				 		{'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {3,4};
		int[] finalPosition = {3,1};
		boolean result = ChessPieceMovement.checkRightToLeft(board, inPosition, finalPosition);

		assertFalse(result);
	}
	
	// Tests to validate method checkTopToBottom
	@Test
	public void testCheckTopToBottomTrue() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'T','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'p','p','p','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {2,0};
		int[] finalPosition = {5,0};
		boolean result = ChessPieceMovement.checkTopToBottom(board, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testCheckTopToBottomFalse() {
		
		char[][] board = {{'l','C','B','R','Q','B','l','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'T','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','C','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'p','p','p','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {1,5};
		int[] finalPosition = {5,5};
		boolean result = ChessPieceMovement.checkTopToBottom(board, inPosition, finalPosition);
		
		assertFalse(result);
	}
	
	// Tests to validate method checkBottomToUp
	@Test
	public void testCheckBottomToTopTrue() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','T','l','l','l','l'},
						 {'p','p','p','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {5,3};
		int[] finalPosition = {2,3};
		boolean result = ChessPieceMovement.checkBottomToTop(board, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testCheckBottomToTopFalse() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','l','P','P','P','P'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','P','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','T','l','l','l','l'},
						 {'p','p','p','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {5,3};
		int[] finalPosition = {1,3};
		boolean result = ChessPieceMovement.checkBottomToTop(board, inPosition, finalPosition);
		
		assertFalse(result);
	}
	
	// Tests to validate method checkMainDiagonal
	@Test
	public void testCheckMainDiagonalDownTrue() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'T','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'p','p','p','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {2,0};
		int[] finalPosition = {5,3};
		boolean result = ChessPieceMovement.checkMainDiagonal(board, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testCheckMainDiagonalDownFalse() {
		
		char[][] board = {{'T','C','l','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','B','l','l','l','l'},
						 {'l','l','l','l','p','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'p','p','p','p','l','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {3,3};
		int[] finalPosition = {5,5};
		boolean result = ChessPieceMovement.checkMainDiagonal(board, inPosition, finalPosition);
		
		assertFalse(result);
	}
	
	@Test
	public void testCheckMainDiagonalUpTrue() {
		
		char[][] board = {{'l','C','l','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','B','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'p','p','p','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {4,3};
		int[] finalPosition = {2,1};
		boolean result = ChessPieceMovement.checkMainDiagonal(board, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testCheckMainDiagonalUpFalse() {
		
		char[][] board = {{'T','C','l','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','B','l','l','l','l'},
						 {'l','l','l','l','p','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'p','p','p','p','l','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {4,4};
		int[] finalPosition = {2,2};
		boolean result = ChessPieceMovement.checkMainDiagonal(board, inPosition, finalPosition);
		
		assertFalse(result);
	}
	
	// Tests to validate method checkSecondaryDiagonal
	@Test
	public void testCheckSecondaryDiagonalDownTrue() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','T','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'p','p','p','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {4,2};
		int[] finalPosition = {5,1};
		boolean result = ChessPieceMovement.checkSecondaryDiagonal(board, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testCheckSecondaryDiagonalDownFalse() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','T','l','l','l','l'},
						 {'l','l','p','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'p','p','l','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {3,3};
		int[] finalPosition = {5,1};
		boolean result = ChessPieceMovement.checkSecondaryDiagonal(board, inPosition, finalPosition);
		
		assertFalse(result);
	}
	
	@Test
	public void testCheckSecondaryDiagonalUpTrue() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','T','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'p','p','p','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {4,2};
		int[] finalPosition = {2,4};
		boolean result = ChessPieceMovement.checkSecondaryDiagonal(board, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testCheckSecondaryDiagonalUpFalse() {
		
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
						 {'P','P','P','P','P','P','P','P'},
						 {'l','l','l','l','l','l','l','l'},
						 {'l','l','l','T','l','l','l','l'},
						 {'l','l','p','l','l','l','l','l'},
						 {'l','l','l','l','l','l','l','l'},
						 {'p','p','l','p','p','p','p','p'},
						 {'t','c','b','q','r','b','c','t'}};
		int[] inPosition = {4,2};
		int[] finalPosition = {2,4};
		boolean result = ChessPieceMovement.checkSecondaryDiagonal(board, inPosition, finalPosition);
		
		assertFalse(result);
	}

	// Tests to validate method canPieceOccupyFinalPosition
		@Test
	public  void testCanPieceOccupyFinalPositionTakeTrue() {
			
		char pieceInPos = 'b';
		char pieceFinPos = 'T';
		boolean result = ChessPieceMovement.canPieceOccupyFinalPosition(pieceInPos, pieceFinPos);
		
		assertTrue(result);
	}
	
	@Test
	public  void testCanPieceOccupyFinalPositionTakeFalse() {
		
		char pieceInPos = 'b';
		char pieceFinPos = 't';
		boolean result = ChessPieceMovement.canPieceOccupyFinalPosition(pieceInPos, pieceFinPos);
		
		assertFalse(result);
	}

	@Test
	public  void testCanPieceOccupyFinalPositionFreePosition() {
		
		char pieceInPos = 'P';
		char pieceFinPos = 'l';
		boolean result = ChessPieceMovement.canPieceOccupyFinalPosition(pieceInPos, pieceFinPos);
		
		assertTrue(result);
	}

	// Tests to validate method findDirectionOfMovement
	@Test
	public  void testFindDirectionOfMovementBOTTOM_UP() {
		
		int[] inPos = {2,3};
		int[] finPos = {0,3};
		movement expResult = movement.BOTTOM_UP;
		movement result = ChessPieceMovement.findDirectionOfMovement(inPos, finPos);
		assertEquals(expResult, result);
	}
	
	@Test
	public  void testFindDirectionOfMovementTOP_TO_BOTTOM() {
		
		int[] inPos = {2,3};
		int[] finPos = {5,3};
		movement expResult = movement.TOP_TO_BOTTOM;
		movement result = ChessPieceMovement.findDirectionOfMovement(inPos, finPos);
		assertEquals(expResult, result);
	}
	
	@Test
	public  void testFindDirectionOfMovementLEFT_TO_RIGHT() {
		
		int[] inPos = {2,3};
		int[] finPos = {2,5};
		movement expResult = movement.LEFT_TO_RIGHT;
		movement result = ChessPieceMovement.findDirectionOfMovement(inPos, finPos);
		assertEquals(expResult, result);
	}
	
	@Test
	public  void testFindDirectionOfMovementRIGHT_TO_LEFT() {
		
		int[] inPos = {2,3};
		int[] finPos = {2,0};
		movement expResult = movement.RIGHT_TO_LEFT;
		movement result = ChessPieceMovement.findDirectionOfMovement(inPos, finPos);
		assertEquals(expResult, result);
	}
	
	@Test
	public  void testFindDirectionOfMovementTO_UPPER_LEFT() {
		
		int[] inPos = {2,3};
		int[] finPos = {0,2};
		movement expResult = movement.TO_UPPER_LEFT;
		movement result = ChessPieceMovement.findDirectionOfMovement(inPos, finPos);
		assertEquals(expResult, result);
	}
	
	@Test
	public  void testFindDirectionOfMovementTO_LOWER_LEFT() {
		
		int[] inPos = {2,3};
		int[] finPos = {5,0};
		movement expResult = movement.TO_LOWER_LEFT;
		movement result = ChessPieceMovement.findDirectionOfMovement(inPos, finPos);
		assertEquals(expResult, result);
	}
	
	@Test
	public  void testFindDirectionOfMovementTO_UPPER_RIGHT() {
		
		int[] inPos = {2,3};
		int[] finPos = {0,7};
		movement expResult = movement.TO_UPPER_RIGHT;
		movement result = ChessPieceMovement.findDirectionOfMovement(inPos, finPos);
		assertEquals(expResult, result);
	}
	
	@Test
	public  void testFindDirectionOfMovementTO_LOWER_RIGHT() {
		
		int[] inPos = {2,3};
		int[] finPos = {7,7};
		movement expResult = movement.TO_LOWER_RIGHT;
		movement result = ChessPieceMovement.findDirectionOfMovement(inPos, finPos);
		assertEquals(expResult, result);
	}

	// Test to validate method isPathClear
	@Test
	public  void testIsPathClearKnightReturnsTrue() {
	
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
				 		  {'P','P','P','P','P','P','P','P'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'l','l','T','l','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'p','p','p','p','p','p','p','p'},
				 		  {'t','c','b','q','r','b','c','t'}};
		int[] inPos = {7,6};
		int[] finPos = {5,1};
		movement mov = movement.TO_LOWER_RIGHT;
		boolean result = ChessPieceMovement.isPathClear(mov, board, inPos, finPos);
			
	assertTrue(result);
	}
	
	// Test to validate method rookValidations

	@Test
	public  void testRookValidationsValidMove() {
	
		movement directionOfMovement = movement.BOTTOM_UP;
	    boolean result = ChessPieceMovement.rookValidations(directionOfMovement);
	    
	    assertTrue(result);
	}	
	
	@Test
	public  void testRookValidationsIllegalMove() {
	
		movement directionOfMovement = movement.TO_LOWER_LEFT;
	    boolean result = ChessPieceMovement.rookValidations(directionOfMovement);
	    
	    assertFalse(result);
	}

	
	// Tests to validate method bishopValidations
	@Test
	public  void testBishopValidationsValidMove() {
	
		movement directionOfMovement = movement.TO_LOWER_LEFT;
	    boolean result = ChessPieceMovement.bishopValidations(directionOfMovement);
	    
	    	assertTrue(result);
	}	
	
	@Test
	public  void testBishopValidationsIllegalMove() {
	
		movement directionOfMovement = movement.LEFT_TO_RIGHT;
	    boolean result = ChessPieceMovement.bishopValidations(directionOfMovement);
	    
	    	assertFalse(result);
	}
	
	// Tests to validate method knightValidations

	@Test
	public void testKnightValidationsValidMove() {

		int[] inPos = {0,2};
		int[] finPos = {2,1};
		boolean result = ChessPieceMovement.knightValidations(inPos, finPos);
		assertTrue(result);
	}
	
	@Test
	public void testKnightValidationsIllegalMove() {

		int[] inPos = {3,2};
		int[] finPos = {2,1};
		boolean result = ChessPieceMovement.knightValidations(inPos, finPos);
		assertFalse(result);
	}
	
	@Test
	public void testKnightValidationsVerticalMovementLargerThanTwo() {

		int[] inPos = {0,2};
		int[] finPos = {4,1};
		boolean result = ChessPieceMovement.knightValidations(inPos, finPos);
		assertFalse(result);
	}
	
	@Test
	public void testKnightValidationsHorizontalMovementLargerThanTwo() {

		int[] inPos = {0,2};
		int[] finPos = {1,5};
		boolean result = ChessPieceMovement.knightValidations(inPos, finPos);
		assertFalse(result);
	}
	
	// Tests to validate method kingValidations
	@Test
	public void testKingValidationsValidMove() {

		int[] inPos = {0,2};
		int[] finPos = {1,1};
		boolean result = ChessPieceMovement.kingValidations(inPos, finPos);
		assertTrue(result);
	}
	
	@Test
	public void testKingValidationsIllegalVerticalMove() {

		int[] inPos = {5,2};
		int[] finPos = {3,2};
		boolean result = ChessPieceMovement.kingValidations(inPos, finPos);
		assertFalse(result);
	}
	
	@Test
	public void testKingValidationsIllegalHorizontalMove() {

		int[] inPos = {5,2};
		int[] finPos = {3,2};
		boolean result = ChessPieceMovement.kingValidations(inPos, finPos);
		assertFalse(result);
	}

	// Tests to validate method whitePawnValidations
	@Test
	public  void testWhitePawnValidationsOneMoveValid() {
	
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
				 		  {'P','P','P','P','P','P','P','P'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'l','l','T','l','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'p','p','p','p','p','p','p','p'},
				 		  {'t','c','b','q','r','b','c','t'}};
		movement dirOfMov = movement.TOP_TO_BOTTOM;
		int[] inPos = {1,2};
		int[] finPos = {2,2};
		boolean result = ChessPieceMovement.whitePawnValidations(board, dirOfMov, inPos, finPos);
		assertTrue(result);
	}
	
	@Test
	public  void testWhitePawnValidationsOneMoveIllegalMove() {
	
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
				 		  {'P','P','l','P','P','P','P','P'},
				 		  {'l','l','b','l','l','l','l','l'},
				 		  {'l','l','P','l','l','l','l','l'},
				 		  {'l','l','T','l','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'p','p','p','p','p','p','p','p'},
				 		  {'t','c','b','q','r','b','c','t'}};
		movement dirOfMov = movement.TOP_TO_BOTTOM;
		int[] inPos = {3,2};
		int[] finPos = {4,2};
		boolean result = ChessPieceMovement.whitePawnValidations(board, dirOfMov, inPos, finPos);
		assertFalse(result);
	}
	
	@Test
	public  void testWhitePawnValidationsFirstLineTwoMovesValid() {
	
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
				 		  {'P','P','P','P','P','P','P','P'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'l','l','T','l','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'p','p','p','p','p','p','p','p'},
				 		  {'t','c','b','q','r','b','c','t'}};
		movement dirOfMov = movement.TOP_TO_BOTTOM;
		int[] inPos = {1,2};
		int[] finPos = {3,2};
		boolean result = ChessPieceMovement.whitePawnValidations(board, dirOfMov, inPos, finPos);
		assertTrue(result);
	}
	
	@Test
	public  void testWhitePawnValidationsFirstLineTwoMovesIllegalMoveFirstSlotOccupied() {
	
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
				 		  {'P','P','P','P','P','P','P','P'},
				 		  {'l','l','b','l','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'l','l','T','l','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'p','p','p','p','p','p','p','p'},
				 		  {'t','c','b','q','r','b','c','t'}};
		movement dirOfMov = movement.TOP_TO_BOTTOM;
		int[] inPos = {1,2};
		int[] finPos = {3,2};
		boolean result = ChessPieceMovement.whitePawnValidations(board, dirOfMov, inPos, finPos);
		assertFalse(result);
	}
	
	@Test
	public  void testWhitePawnValidationsFirstLineTwoMovesIllegalMoveSecondSlotOccupied() {
	
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
				 		  {'P','P','P','P','P','P','P','P'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'l','l','b','l','l','l','l','l'},
				 		  {'l','l','T','l','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'p','p','p','p','p','p','p','p'},
				 		  {'t','c','b','q','r','b','c','t'}};
		movement dirOfMov = movement.TOP_TO_BOTTOM;
		int[] inPos = {1,2};
		int[] finPos = {3,2};
		boolean result = ChessPieceMovement.whitePawnValidations(board, dirOfMov, inPos, finPos);
		assertFalse(result);
	}
	
	@Test
	public  void testWhitePawnValidationsTakeOpponentValid() {
	
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
				 		  {'P','P','P','P','P','P','P','P'},
				 		  {'l','l','l','l','b','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'l','l','T','l','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'p','p','p','p','p','p','p','p'},
				 		  {'t','c','b','q','r','b','c','t'}};
		movement dirOfMov = movement.TO_LOWER_RIGHT;
		int[] inPos = {1,3};
		int[] finPos = {2,4};
		boolean result = ChessPieceMovement.whitePawnValidations(board, dirOfMov, inPos, finPos);
		assertTrue(result);
	}
	
	@Test
	public  void testWhitePawnValidationsTakeOpponentIllegalMoveSlotOccupiedByWhite() {
	
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
				 		  {'P','P','P','P','P','P','P','P'},
				 		  {'l','l','l','l','B','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'l','l','T','l','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'p','p','p','p','p','p','p','p'},
				 		  {'t','c','b','q','r','b','c','t'}};
		movement dirOfMov = movement.TO_LOWER_RIGHT;
		int[] inPos = {1,3};
		int[] finPos = {2,4};
		boolean result = ChessPieceMovement.whitePawnValidations(board, dirOfMov, inPos, finPos);
		assertFalse(result);
	}
	
	@Test
	public  void testWhitePawnValidationsTakeOpponentIllegalMoveSlotFree() {
	
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
				 		  {'P','P','P','P','P','P','P','P'},
				 		  {'l','l','l','l','B','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'l','l','T','l','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'p','p','p','p','p','p','p','p'},
				 		  {'t','c','b','q','r','b','c','t'}};
		movement dirOfMov = movement.TO_LOWER_LEFT;
		int[] inPos = {1,3};
		int[] finPos = {2,2};
		boolean result = ChessPieceMovement.whitePawnValidations(board, dirOfMov, inPos, finPos);
		assertFalse(result);
	}
	
	@Test
	public  void testWhitePawnValidationsOneMoveIllegalMoveSlotOccupied() {
	
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
				 		  {'P','P','P','l','P','P','P','P'},
				 		  {'l','l','b','P','l','l','l','l'},
				 		  {'l','l','l','B','l','l','l','l'},
				 		  {'l','l','T','l','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'p','p','p','p','p','p','p','p'},
				 		  {'t','c','b','q','r','l','c','t'}};
		movement dirOfMov = movement.TOP_TO_BOTTOM;
		int[] inPos = {2,3};
		int[] finPos = {3,3};
		boolean result = ChessPieceMovement.whitePawnValidations(board, dirOfMov, inPos, finPos);
		assertFalse(result);
	}
	
	@Test
	public  void testWhitePawnValidationsOneMoveIllegalMoveUpwardMove() {
	
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
				 		  {'P','P','P','l','P','P','P','P'},
				 		  {'l','l','b','P','l','l','l','l'},
				 		  {'l','l','l','b','l','l','l','l'},
				 		  {'l','l','T','l','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'p','p','p','p','p','p','p','p'},
				 		  {'t','c','b','q','r','l','c','t'}};
		movement dirOfMov = movement.BOTTOM_UP;
		int[] inPos = {2,3};
		int[] finPos = {1,3};
		boolean result = ChessPieceMovement.whitePawnValidations(board, dirOfMov, inPos, finPos);
		assertFalse(result);
	}
	
	@Test
	public  void testWhitePawnValidationsIllegalMoveTwoMovesNotOnLineOne() {
	
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
				 		  {'P','P','P','l','P','P','P','P'},
				 		  {'l','l','b','P','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'l','l','T','l','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'p','p','p','p','p','p','p','p'},
				 		  {'t','c','b','q','r','b','c','t'}};
		movement dirOfMov = movement.TOP_TO_BOTTOM;
		int[] inPos = {2,3};
		int[] finPos = {4,3};
		boolean result = ChessPieceMovement.whitePawnValidations(board, dirOfMov, inPos, finPos);
		assertFalse(result);
	}
	
	@Test
	public  void testWhitePawnValidationsIllegalMoveLateralMovementMoreThanOne() {
	
		char[][] board = {{'l','C','B','R','Q','B','C','T'},
				 		  {'P','P','P','l','P','P','P','P'},
				 		  {'l','l','b','P','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'l','l','T','l','l','l','l','l'},
				 		  {'l','l','l','l','l','l','l','l'},
				 		  {'p','p','p','p','p','p','p','p'},
				 		  {'t','c','b','q','r','b','c','t'}};
		movement dirOfMov = movement.TO_LOWER_RIGHT;
		int[] inPos = {2,3};
		int[] finPos = {3,5};
		boolean result = ChessPieceMovement.whitePawnValidations(board, dirOfMov, inPos, finPos);
		assertFalse(result);
	}
	
	// Tests to validate method BlackPawnValidations
		@Test
		public  void testBlackPawnValidationsOneMoveValid() {
		
			char[][] board = {{'l','C','B','R','Q','B','C','T'},
					 		  {'P','P','P','P','P','P','P','P'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'l','l','T','l','l','l','l','l'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'p','p','p','p','p','p','p','p'},
					 		  {'t','c','b','q','r','b','c','t'}};
			movement dirOfMov = movement.BOTTOM_UP;
			int[] inPos = {6,2};
			int[] finPos = {5,2};
			boolean result = ChessPieceMovement.blackPawnValidations(board, dirOfMov, inPos, finPos);
			assertTrue(result);
		}
		
		@Test
		public  void testBlackPawnValidationsOneMoveIllegalMove() {
		
			char[][] board = {{'l','C','B','R','Q','B','C','T'},
					 		  {'P','P','l','P','P','P','P','P'},
					 		  {'l','l','b','l','l','l','l','l'},
					 		  {'l','l','P','l','K','l','l','l'},
					 		  {'l','l','l','l','p','l','l','l'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'p','p','p','p','p','p','p','p'},
					 		  {'t','c','b','q','r','b','c','t'}};
			movement dirOfMov = movement.BOTTOM_UP;
			int[] inPos = {4,4};
			int[] finPos = {3,4};
			boolean result = ChessPieceMovement.blackPawnValidations(board, dirOfMov, inPos, finPos);
			assertFalse(result);
		}
		
		@Test
		public  void testBlackPawnValidationsFirstLineTwoMovesValid() {
		
			char[][] board = {{'l','C','B','R','Q','B','C','T'},
					 		  {'P','P','P','P','P','P','P','P'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'l','l','T','l','l','l','l','l'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'p','p','p','p','p','p','p','p'},
					 		  {'t','c','b','q','r','b','c','t'}};
			movement dirOfMov = movement.BOTTOM_UP;
			int[] inPos = {6,3};
			int[] finPos = {4,3};
			boolean result = ChessPieceMovement.blackPawnValidations(board, dirOfMov, inPos, finPos);
			assertTrue(result);
		}
		
		@Test
		public  void testBlackPawnValidationsFirstLineTwoMovesIllegalMoveFirstSlotOccupied() {
		
			char[][] board = {{'l','C','B','R','Q','B','C','T'},
					 		  {'P','P','P','P','P','P','P','P'},
					 		  {'l','l','b','l','l','l','l','l'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'l','l','T','l','l','l','l','l'},
					 		  {'C','l','l','l','l','l','l','l'},
					 		  {'p','p','p','p','p','p','p','p'},
					 		  {'t','c','b','q','r','b','c','t'}};
			movement dirOfMov = movement.BOTTOM_UP;
			int[] inPos = {6,0};
			int[] finPos = {4,0};
			boolean result = ChessPieceMovement.blackPawnValidations(board, dirOfMov, inPos, finPos);
			assertFalse(result);
		}
		
		@Test
		public  void testBlackPawnValidationsFirstLineTwoMovesIllegalMoveSecondSlotOccupied() {
		
			char[][] board = {{'l','C','B','R','Q','B','C','T'},
					 		  {'P','P','P','P','P','P','P','P'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'l','l','b','l','l','l','l','l'},
					 		  {'l','l','T','l','l','c','l','l'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'p','p','p','p','p','p','p','p'},
					 		  {'t','c','b','q','r','b','c','t'}};
			movement dirOfMov = movement.BOTTOM_UP;
			int[] inPos = {6,5};
			int[] finPos = {4,5};
			boolean result = ChessPieceMovement.blackPawnValidations(board, dirOfMov, inPos, finPos);
			assertFalse(result);
		}
		
		@Test
		public  void testBlackPawnValidationsTakeOpponentValid() {
		
			char[][] board = {{'l','C','B','R','Q','B','C','T'},
					 		  {'P','P','P','P','P','P','P','P'},
					 		  {'l','l','l','l','b','l','l','l'},
					 		  {'l','l','l','l','B','l','l','l'},
					 		  {'l','l','T','p','l','l','l','l'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'p','p','p','l','p','p','p','p'},
					 		  {'t','c','b','q','r','b','c','t'}};
			movement dirOfMov = movement.TO_UPPER_RIGHT;
			int[] inPos = {4,3};
			int[] finPos = {3,4};
			boolean result = ChessPieceMovement.blackPawnValidations(board, dirOfMov, inPos, finPos);
			assertTrue(result);
		}
		
		@Test
		public  void testBlackPawnValidationsTakeOpponentIllegalMoveSlotOccupiedByBlack() {
		
			char[][] board = {{'l','C','B','R','Q','B','C','T'},
					 		  {'P','P','P','P','P','P','P','P'},
					 		  {'l','l','l','l','B','l','l','l'},
					 		  {'l','l','c','l','l','l','c','l'},
					 		  {'l','l','T','p','l','l','l','p'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'p','p','p','l','p','p','p','l'},
					 		  {'t','l','b','q','r','b','l','t'}};
			movement dirOfMov = movement.TO_UPPER_LEFT;
			int[] inPos = {4,7};
			int[] finPos = {3,6};
			boolean result = ChessPieceMovement.blackPawnValidations(board, dirOfMov, inPos, finPos);
			assertFalse(result);
		}
		
		@Test
		public  void testBlackPawnValidationsTakeOpponentIllegalMoveSlotFree() {
		
			char[][] board = {{'l','C','B','R','Q','B','C','T'},
					 		  {'P','P','P','P','P','P','P','P'},
					 		  {'l','l','l','l','B','l','l','l'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'l','p','T','l','l','l','l','l'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'p','l','p','p','p','p','p','p'},
					 		  {'t','c','b','q','r','b','c','t'}};
			movement dirOfMov = movement.TO_UPPER_LEFT;
			int[] inPos = {4,1};
			int[] finPos = {3,0};
			boolean result = ChessPieceMovement.blackPawnValidations(board, dirOfMov, inPos, finPos);
			assertFalse(result);
		}
		
		@Test
		public  void testBlackPawnValidationsOneMoveIllegalMoveSlotOccupied() {
		
			char[][] board = {{'l','C','B','R','Q','B','C','T'},
					 		  {'P','P','P','l','P','P','P','P'},
					 		  {'l','l','b','P','l','l','l','l'},
					 		  {'l','l','l','B','l','l','l','l'},
					 		  {'l','l','T','l','l','l','l','l'},
					 		  {'l','l','p','l','l','l','l','l'},
					 		  {'p','p','l','p','p','p','p','p'},
					 		  {'t','c','b','q','r','l','c','t'}};
			movement dirOfMov = movement.BOTTOM_UP;
			int[] inPos = {6,2};
			int[] finPos = {5,2};
			boolean result = ChessPieceMovement.blackPawnValidations(board, dirOfMov, inPos, finPos);
			assertFalse(result);
		}
		
		@Test
		public  void testBlackPawnValidationsOneMoveIllegalMoveDownwardMove() {
		
			char[][] board = {{'l','C','B','R','Q','B','C','T'},
					 		  {'P','P','P','l','P','P','P','P'},
					 		  {'l','l','b','P','l','l','l','l'},
					 		  {'l','l','l','b','l','l','l','l'},
					 		  {'l','l','T','l','l','l','l','l'},
					 		  {'l','l','l','p','l','l','l','l'},
					 		  {'p','p','p','l','p','p','p','p'},
					 		  {'t','c','b','q','r','l','c','t'}};
			movement dirOfMov = movement.TOP_TO_BOTTOM;
			int[] inPos = {5,3};
			int[] finPos = {6,3};
			boolean result = ChessPieceMovement.blackPawnValidations(board, dirOfMov, inPos, finPos);
			assertFalse(result);
		}
		
		@Test
		public  void testBlackPawnValidationsIllegalMoveTwoMovesNotOnLineSix() {
		
			char[][] board = {{'l','C','B','R','Q','B','C','T'},
					 		  {'P','P','P','l','P','P','P','P'},
					 		  {'l','l','b','P','l','l','l','l'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'l','l','T','l','p','l','l','l'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'p','p','p','p','l','p','p','p'},
					 		  {'t','c','b','q','r','b','c','t'}};
			movement dirOfMov = movement.BOTTOM_UP;
			int[] inPos = {4,4};
			int[] finPos = {2,4};
			boolean result = ChessPieceMovement.blackPawnValidations(board, dirOfMov, inPos, finPos);
			assertFalse(result);
		}
		
		@Test
		public  void testBlackPawnValidationsOneMoveIllegalMoveLateralMovementMoreThanOne() {
		
			char[][] board = {{'l','C','B','R','Q','B','C','T'},
					 		  {'P','P','P','l','P','P','P','P'},
					 		  {'l','l','b','P','l','l','l','l'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'l','l','T','l','p','l','l','l'},
					 		  {'l','l','l','l','l','l','l','l'},
					 		  {'p','p','p','p','l','p','p','p'},
					 		  {'t','c','b','q','r','b','c','t'}};
			movement dirOfMov = movement.TO_UPPER_LEFT;
			int[] inPos = {6,4};
			int[] finPos = {5,2};
			boolean result = ChessPieceMovement.blackPawnValidations(board, dirOfMov, inPos, finPos);
			assertFalse(result);
		}

		@Test
		public  void testMovePieceNormalResult() {
		
			char[][] board = {{'T','C','B','R','Q','B','C','T'},
							  {'P','P','P','P','P','P','P','P'},
							  {'l','l','l','l','l','l','l','l'},
							  {'l','l','l','l','l','l','l','l'},
							  {'l','l','l','l','l','l','l','l'},
							  {'l','l','l','l','l','l','l','l'},
							  {'p','p','p','p','p','p','p','p'},
							  {'t','c','b','q','r','b','c','t'}};
			int[] inPos = {1,1};
			int[] finPos = {3,1};
			char[][] expResult = {{'T','C','B','R','Q','B','C','T'},
					  			  {'P','l','P','P','P','P','P','P'},
					  			  {'l','l','l','l','l','l','l','l'},
					  			  {'l','P','l','l','l','l','l','l'},
					  			  {'l','l','l','l','l','l','l','l'},
					  			  {'l','l','l','l','l','l','l','l'},
					  			  {'p','p','p','p','p','p','p','p'},
					  			  {'t','c','b','q','r','b','c','t'}};
			char[][] result = ChessPieceMovement.movePiece(board, inPos, finPos);
			assertThat (expResult, equalTo(result));
		}
		
		@Test
		public  void testMovePieceAbnormalResult() {
		
			char[][] board = {{'T','C','B','R','Q','B','C','T'},
							  {'P','P','P','P','P','P','P','P'},
							  {'l','l','l','l','l','l','l','l'},
							  {'l','l','l','l','l','l','l','l'},
							  {'l','l','l','l','l','l','l','l'},
							  {'l','l','l','l','l','l','l','l'},
							  {'p','p','p','p','p','p','p','p'},
							  {'t','c','b','q','r','b','c','t'}};
			int[] inPos = {1,1};
			int[] finPos = {3,1};
			char[][] expResult = {{'T','C','B','R','Q','B','C','T'},
					  			  {'P','P','P','P','P','P','P','P'},
					  			  {'l','l','l','l','l','l','l','l'},
					  			  {'l','l','l','l','l','l','l','l'},
					  			  {'l','l','l','l','l','l','l','l'},
					  			  {'l','l','l','l','l','l','l','l'},
					  			  {'p','p','p','p','p','p','p','p'},
					  			  {'t','c','b','q','r','b','c','t'}};
			char[][] result = ChessPieceMovement.movePiece(board, inPos, finPos);
			assertThat (expResult, not(equalTo(result)));
		}
}

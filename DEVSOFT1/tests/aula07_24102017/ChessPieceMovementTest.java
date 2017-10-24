package aula07_24102017;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChessPieceMovementTest {

//	@Test
//	public void testIsValidPawnMovement() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testIsValidRookMovementLeftToRight() {
		
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
		char c = 'T';
		boolean result = ChessPieceMovement.isValidRookMovement(board, c, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsValidRookMovementRightToLeft() {
		
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
		char c = 'T';
		boolean result = ChessPieceMovement.isValidRookMovement(board, c, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsValidRookMovementTopToBottom() {
		
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
		char c = 'T';
		boolean result = ChessPieceMovement.isValidRookMovement(board, c, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsValidRookMovementBottomToUp() {
		
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
		char c = 'T';
		boolean result = ChessPieceMovement.isValidRookMovement(board, c, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsValidRookMovementMainDiagonalTopToBottom() {
		
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
		char c = 'T';
		boolean result = ChessPieceMovement.isValidRookMovement(board, c, inPosition, finalPosition);
		
		assertFalse(result);
	}
	
	@Test
	public void testIsValidRookMovementMainDiagonalBottomUp() {
		
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
		char c = 'T';
		boolean result = ChessPieceMovement.isValidRookMovement(board, c, inPosition, finalPosition);
		
		assertFalse(result);
	}
	
	@Test
	public void testIsValidRookMovementSecondaryDiagonalTopToBottom() {
		
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
		char c = 'T';
		boolean result = ChessPieceMovement.isValidRookMovement(board, c, inPosition, finalPosition);
		
		assertFalse(result);
	}
	
	@Test
	public void testIsValidRookMovementSecondaryDiagonalBottomUp() {
		
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
		char c = 'T';
		boolean result = ChessPieceMovement.isValidRookMovement(board, c, inPosition, finalPosition);
		
		assertFalse(result);
	}
	
	@Test
	public void testIsValidRookMovementTakeOpponentTopToBottom() {
		
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
		char c = 'T';
		boolean result = ChessPieceMovement.isValidRookMovement(board, c, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsValidRookMovementTakeOpponentBottomUp() {
		
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
		char c = 'T';
		boolean result = ChessPieceMovement.isValidRookMovement(board, c, inPosition, finalPosition);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsValidRookMovementTakeOpponentLeftToRight() {
		
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
		char c = 'T';
		boolean result = ChessPieceMovement.isValidRookMovement(board, c, inPosition, finalPosition);
		
		assertTrue(result);
	}

//	@Test
//	public void testIsValidBishopMovement() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testIsValidKnightMovement() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testIsValidKingMovement() {
//		
//	}
//
//	@Test
//	public void testIsValidQueenMovement() {
//		fail("Not yet implemented");
//	}

}

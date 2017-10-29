package aula11_27102017;

import static org.junit.Assert.*;

import org.junit.Test;

import aula11_27102017.DrawMatrix.move;

public class DrawMatrixTest {

	@Test
	public void testPaintMatrixCharArrayTrueResult() {
		
		DrawMatrix.dirOfMovement = move.LEFT_TO_RIGHT;
		char[] orders = {'F','P','R','F','P','R','F','P','R','R','F','F','F','F','P','R','R','R',
						 'F','P','R','F','R','F','P','F','F','P','F','F','R','F','F','P','F','P',
						 'F','F','R','F','F','P','R','F','F','F','F','R','F','P','R','F','F','F','P'};
		DrawMatrix.paintMatrix(orders);
		
	}

	//Tests to validate method isValidOrder
	@Test
	public void testIsValidOrderValidPaint() {
		
		char order = 'P';
		boolean result = DrawMatrix.isValidOrder(order);
		
		assertTrue(result);
	}

	@Test
	public void testIsValidOrderValidRotate() {
		
		char order = 'R';
		boolean result = DrawMatrix.isValidOrder(order);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsValidOrderInvalidLowerCase() {
		
		char order = 'f';
		boolean result = DrawMatrix.isValidOrder(order);
		
		assertFalse(result);
	}

	// Tests to validate method moveForward
	@Test
	public void testMoveForwardMoveDown() {
	
		int[] cursorPosition = {1,1}; 
		DrawMatrix.dirOfMovement = move.DOWNWARD;
		int[] expResult = {2,1};
		int[] result = DrawMatrix.moveForward(cursorPosition);
		
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public void testMoveForwardMoveUp() {
	
		int[] cursorPosition = {5,5}; 
		DrawMatrix.dirOfMovement = move.UPWARD;
		int[] expResult = {4,5};
		int[] result = DrawMatrix.moveForward(cursorPosition);
		
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public void testMoveForwardMoveLeft() {
	
		int[] cursorPosition = {3,4};
		DrawMatrix.dirOfMovement = move.RIGHT_TO_LEFT;
		int[] expResult = {3,3};
		int[] result = DrawMatrix.moveForward(cursorPosition);
		
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public void testMoveForwardMoveRight() {
	
		int[] cursorPosition = {4,0};
		DrawMatrix.dirOfMovement = move.LEFT_TO_RIGHT;
		int[] expResult = {4,1};
		int[] result = DrawMatrix.moveForward(cursorPosition);
		
		assertArrayEquals(expResult, result);
	}

	//Tests to validate method rotateRight
	@Test
	public void testRotateRightgoesLeft_To_Right() {
		
		DrawMatrix.dirOfMovement = move.UPWARD;
		move result = DrawMatrix.rotateRight();
		
		assertEquals(move.LEFT_TO_RIGHT, result);
	}

	@Test
	public void testRotateRightGoesDownward() {
		
		DrawMatrix.dirOfMovement = move.LEFT_TO_RIGHT;
		move result = DrawMatrix.rotateRight();
		
		assertEquals(move.DOWNWARD, result);
		
	}
	
	// Tests to validate method isValidForwardMove
	@Test
	public void testIsValidForwardMoveValidMovement() {

		int[] cursorPosition = { 0, 0 };
		DrawMatrix.dirOfMovement = move.DOWNWARD;
		boolean result = DrawMatrix.isValidForwardMove(cursorPosition);

		assertTrue(result);
	}

	@Test
	public void testIsValidForwardMoveInvalidMoveUp() {

		int[] cursorPosition = { 0, 0 };
		DrawMatrix.dirOfMovement = move.UPWARD;
		boolean result = DrawMatrix.isValidForwardMove(cursorPosition);

		assertFalse(result);
	}

	@Test
	public void testIsValidForwardMoveInvalidMoveDown() {

		int[] cursorPosition = { 5, 3 };
		DrawMatrix.dirOfMovement = move.DOWNWARD;
		boolean result = DrawMatrix.isValidForwardMove(cursorPosition);

		assertFalse(result);
	}

	@Test
	public void testIsValidForwardMoveInvalidMoveRight() {

		int[] cursorPosition = { 4, 5 };
		DrawMatrix.dirOfMovement = move.LEFT_TO_RIGHT;
		boolean result = DrawMatrix.isValidForwardMove(cursorPosition);

		assertFalse(result);
	}

	@Test
	public void testIsValidForwardMoveInvalidMoveLeft() {

		int[] cursorPosition = { 5, 0 };
		DrawMatrix.dirOfMovement = move.RIGHT_TO_LEFT;
		boolean result = DrawMatrix.isValidForwardMove(cursorPosition);

		assertFalse(result);
	}
}

package aula07_24102017;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumOfCornerAndCentralPointsTest {

	//Tests for validating square and odd matrix
	@Test
	public void testIsMatrixOddAndSquareTrue() {
		
		int[][] testMatrix = {{1,2,3},{3,4,5},{5,6,7}};
		boolean result = SumOfCornerAndCentralPoints.isMatrixOddAndSquare(testMatrix);
		
		assertTrue(result);
	}

	@Test
	public void testIsMatrixOddAndSquareNotOdd() {
		
		int[][] testMatrix = {{1,2,3,5},{3,4,5,7},{5,6,7,8},{1,2,3,4}};
		boolean result = SumOfCornerAndCentralPoints.isMatrixOddAndSquare(testMatrix);
		
		assertFalse(result);
	}
	
	@Test
	public void testIsMatrixOddAndSquareNotSquare() {
		
		int[][] testMatrix = {{1,2,3},{3,4,5}};
		boolean result = SumOfCornerAndCentralPoints.isMatrixOddAndSquare(testMatrix);
		
		assertFalse(result);
	}
	
	@Test
	public void testIsMatrixOddAndSquareEmptyMatrix() {
		
		int[][] testMatrix = {{},{},{}};
		boolean result = SumOfCornerAndCentralPoints.isMatrixOddAndSquare(testMatrix);
		
		assertFalse(result);
	}
	
	//Tests for validating the sum of central and corner points
	@Test
	public void testCalculateSumOfCornerAndCentralPointsUpperLeft() {
		
		int[][] testMatrix = {{1,0,0},{0,0,0},{0,0,0}};
		int expResult = 1;
		int result = SumOfCornerAndCentralPoints.calculateSumOfCornerAndCentralPoints(testMatrix);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public void testCalculateSumOfCornerAndCentralPointsUpperRight() {
		
		int[][] testMatrix = {{0,0,1},{0,0,0},{0,0,0}};
		int expResult = 1;
		int result = SumOfCornerAndCentralPoints.calculateSumOfCornerAndCentralPoints(testMatrix);
		
		assertEquals(expResult, result);
	}

	@Test
	public void testCalculateSumOfCornerAndCentralPointsLowerLeft() {
		
		int[][] testMatrix = {{0,0,0},{0,0,0},{1,0,0}};
		int expResult = 1;
		int result = SumOfCornerAndCentralPoints.calculateSumOfCornerAndCentralPoints(testMatrix);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public void testCalculateSumOfCornerAndCentralPointsLowerRight() {
		
		int[][] testMatrix = {{0,0,0},{0,0,0},{0,0,1}};
		int expResult = 1;
		int result = SumOfCornerAndCentralPoints.calculateSumOfCornerAndCentralPoints(testMatrix);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public void testCalculateSumOfCornerAndCentralPointsCentralPoint() {
		
		int[][] testMatrix = {{0,0,0},{0,2,0},{0,0,0}};
		int expResult = 2;
		int result = SumOfCornerAndCentralPoints.calculateSumOfCornerAndCentralPoints(testMatrix);
		
		assertEquals(expResult, result);
	}
	
	//Test for validating the sum of points
	@Test
	public  void testSumOfPointsTrue() {
		
		int[][] testMatrix = {{1,2,3},{3,4,5},{5,6,7}};
		int expResult = 20;
		int result = SumOfCornerAndCentralPoints.sumOfPoints(testMatrix);
		
		assertEquals(expResult, result);
	}

}

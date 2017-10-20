package aula08_20102017;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.junit.Test;

public class FuncoesTest {

	//Tests to verify if number is prime
	@Test
	public void testIsPrimeNumberTrue() throws Exception {
		
		int num = 269;
		boolean result = Funcoes.isPrimeNumber(num);
		assertTrue(result);
		
	}

	@Test
	public void testIsPrimeNumberFalse() throws Exception {
		
		int num = 27;
		boolean result = Funcoes.isPrimeNumber(num);
		assertFalse(result);
	}
	
	@Test (expected = Exception.class)
	public void testIsPrimeNumberNegativeNumber() throws Exception {
		
		int num = -27;
		boolean result = Funcoes.isPrimeNumber(num);
		assertFalse(result);
	}

	//Tests to verify divide number into its digits
	@Test
	public  void testDivideNumberIntoDigitsNormal() {
		
		int num = 12345;
		int[] expResult = {1,2,3,4,5};
		int[] result = Funcoes.divideNumberIntoDigits(num);
		
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public  void testDivideNumberIntoDigitsZero() {
		
		int num = 0;
		int[] expResult = {0};
		int[] result = Funcoes.divideNumberIntoDigits(num);
		
		assertArrayEquals(expResult, result);
	}

	//Tests to verify sum of digits in a vector
	@Test
	public  void testSumOfDigitsNormal() {
	
		int[] array = {1,2,3,4,5};
		int expResult = 15;
		int result = Funcoes.sumOfDigits(array);
		
		assertEquals (expResult, result);
	}
	
	@Test
	public  void testSumOfDigitsOneDigit() {
	
		int[] array = {9};
		int expResult = 9;
		int result = Funcoes.sumOfDigits(array);
		
		assertEquals (expResult, result);
	}

	//Tests to verify if matrix is square
	@Test
	public  void testIsSquareMatrixNormal() {
		
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
			  	     {7,4,9,6,3,1,5,2,8},
			  	     {5,1,3,8,4,2,9,6,7},
			  	     {3,7,8,9,2,6,1,5,4},
			  	     {1,2,4,5,8,7,6,9,3},
			  	     {6,9,5,4,1,3,8,7,2},
			  	     {4,5,1,2,6,8,7,3,9},
			  	     {2,8,6,3,7,9,4,1,5},
			  	     {9,3,7,1,5,4,2,8,6}};
		
		boolean result = Funcoes.isSquareMatrix(a);

		assertTrue(result);	
	}
	
	@Test
	public  void testIsSquareMatrixNotSquare() {
	
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
		  	  		  {7,4,9,6,3,1,5,2,8},
		  	  		  {5,1,3,8,4,2,9,6,7},
		  	  		  {3,7,8,9,2,6,1,5,4}, 
		  	  		  {1,2,4,5,8,7,6,9,3},
		  	  		  {4,5,1,2,6,8,7,3,9},
		  	  		  {2,8,6,3,7,9,4,1,5},
		  	  		  {9,3,7,1,5,4,2,8,6}};
		boolean result = Funcoes.isSquareMatrix(a);

		assertFalse(result);
	}
	
	@Test
	public void testisSquareMatrixLinesDifferentSize() {
		
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
					  {7,4,9,6,3,1,5,2,8},
					  {5,1,3,4,2,9,6,7},
					  {3,7,8,9,4,6,1,5,4}, 
					  {1,2,4,5,8,7,6,9,3},
					  {6,9,5,4,1,3,8,7,2},
					  {4,5,1,2,6,8,7,3,9},
					  {2,8,6,3,7,9,4,1,5},
					  {9,3,7,1,5,4,2,8,6}};
		boolean result = Funcoes.isSquareMatrix(a);
		
		assertFalse(result);
	}
	
	@Test
	public void testisSquareMatrixEmptyMatrix() {
		
		int [][] a = {{},{},{}};
		boolean result = Funcoes.isSquareMatrix(a);
		
		assertFalse(result);
	}
	
	//Tests to verify is matrix is triangular superior

	@Test
	public  void testIsSuperiorTriangularMatrixTrue() {

		int[][] matrix = {{1,0,0}, {1,2,0},{1,2,3}};
		boolean result = Funcoes.isSuperiorTriangularMatrix(matrix);
		
		assertTrue(result);
	}
	
	@Test
	public  void testIsSuperiorTriangularMatrixFalse() {
		
		int[][] matrix = {{1,2,0}, {1,2,0},{1,2,3}};
		boolean result = Funcoes.isSuperiorTriangularMatrix(matrix);
		
		assertFalse(result);
	}
	
	@Test
	public  void testIsSuperiorTriangularMatrixAllZeros() {
		
		int[][] matrix = {{0,0,0}, {0,0,0},{0,0,0}};
		boolean result = Funcoes.isSuperiorTriangularMatrix(matrix);
		
		assertTrue(result);
	}
	
	//Tests to verify normalized array

	@Test
	public  void testNormalizeVectorNormal() {
	
		double[] testVector = {2,3,4};
		double[] expResult = new double[3];
		expResult[0] = 0;
		expResult[1] = 0.5;
		expResult[2] = 1;
		double[] result = Funcoes.normalizeVector(testVector);
		
		//assertArrayEquals(expResult, result);
		assertThat(expResult, equalTo(result));
		//assertTrue(Arrays.equals(expResult, result));
	}

	@Test
	public  void testNormalizeVectorFalseResults() {
	
		double[] testVector = {2,3,4};
		double[] expResult = new double[3];
		expResult[0] = 0;
		expResult[1] = 0.5;
		expResult[2] = 5;
		double[] result = Funcoes.normalizeVector(testVector);
		
		assertThat(expResult, not(equalTo(result)));
	}
}

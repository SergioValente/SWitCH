package aula06_18102017;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSudokuSolutionTest {

	@Test
	public void testIsValidSudokuSolutionTrue() {
		
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
				  	  {7,4,9,6,3,1,5,2,8},
				  	  {5,1,3,8,4,2,9,6,7},
				  	  {3,7,8,9,2,6,1,5,4},
				  	  {1,2,4,5,8,7,6,9,3},
				  	  {6,9,5,4,1,3,8,7,2},
				  	  {4,5,1,2,6,8,7,3,9},
				  	  {2,8,6,3,7,9,4,1,5},
				  	  {9,3,7,1,5,4,2,8,6}};
	boolean result = TestSudokuSolution.isValidSudokuSolution(a);
	
	assertTrue(result);	
	}

	@Test
	public  void testIsValidSudokuSolutionFalse() {
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
				  	  {7,4,9,6,3,1,5,2,8},
				  	  {5,1,3,8,4,2,9,6,7},
				  	  {3,7,8,9,4,6,1,5,4}, //falso nesta linha, o 1º 4 deve ser um 2
				  	  {1,2,4,5,8,7,6,9,3},
				  	  {6,9,5,4,1,3,8,7,2},
				  	  {4,5,1,2,6,8,7,3,9},
				  	  {2,8,6,3,7,9,4,1,5},
				  	  {9,3,7,1,5,4,2,8,6}};
	boolean result = TestSudokuSolution.isValidSudokuSolution(a);
	
	assertFalse(result);
	}

	@Test
	public void testIsValidSudokuSolutionLinesDifferentSize() {
		
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
					  {7,4,9,6,3,1,5,2,8},
					  {5,1,3,4,2,9,6,7},
					  {3,7,8,9,4,6,1,5,4}, 
					  {1,2,4,5,8,7,6,9,3},
					  {6,9,5,4,1,3,8,7,2},
					  {4,5,1,2,6,8,7,3,9},
					  {2,8,6,3,7,9,4,1,5},
					  {9,3,7,1,5,4,2,8,6}};
		boolean result = TestSudokuSolution.isValidSudokuSolution(a);
		
		assertFalse(result);
	}
	
	@Test
	public void testIsValidSudokuSolutionEmptyMatrix() {
		
		int [][] a = {{},{},{}};
		boolean result = TestSudokuSolution.isValidSudokuSolution(a);
		
		assertFalse(result);
	}

	
	@Test
	public  void testIsValidSudokuSolutionNumerosInvalidos() {
	
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
			  	  	  {7,4,9,6,3,1,5,2,8},
			  	  	  {5,1,3,8,4,2,9,6,7},
			  	  	  {3,7,8,9,2,6,1,5,4},
			  	  	  {1,2,4,5,8,7,6,9,3},
			  	  	  {6,9,5,4,1,3,8,7,2},
			  	  	  {4,5,1,2,6,8,12,3,9}, // linha com o número 12
			  	  	  {2,8,6,3,7,9,4,1,5},
			  	  	  {9,3,7,1,5,4,2,8,6}};
		boolean result = TestSudokuSolution.isValidSudokuSolution(a);

		assertFalse(result);	
	}
}

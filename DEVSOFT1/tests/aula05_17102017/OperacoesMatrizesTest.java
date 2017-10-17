package aula05_17102017;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperacoesMatrizesTest {

	// Testes para calcular soma de cada linha de uma matriz
	@Test
	public void testSomaCadaLinhaMatrizNormal() {
		
		int[][] a = {{1,2,3}, {4,5,6}, {7,8,9}};
		int[] expResult = {6,15,24};
		int[] result = OperacoesMatrizes.somaCadaLinhaMatriz(a);
		
		assertArrayEquals(expResult, result);
	}

	@Test
	public void testSomaCadaLinhaMatrizEmpty() {
		
		int[][] a = {{}, {}};
		int[] expResult = {0,0};
		int[] result = OperacoesMatrizes.somaCadaLinhaMatriz(a);
		
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public void testSomaCadaLinhaMatrizDifferentLines() {
		
		int[][] a = {{1,2,3}, {4,5}, {7,8,9}};
		int[] expResult = {6,9,24};
		int[] result = OperacoesMatrizes.somaCadaLinhaMatriz(a);
		
		assertArrayEquals(expResult, result);
	}
	
	//Testes para verificar se todos os elementos de um vetor estão presentes numa matriz
	@Test
	public void testExistsInMatrixTrue() {
		
		int[][] a = {{1,2,3}, {4,5,6}, {7,8,9}};
		int[] b = {1,4,8};
		boolean result = OperacoesMatrizes.existsInMatrix(a, b);
		
		assertTrue(result);
	}
	
	@Test
	public void testExistsInMatrixFalse() {
		
		int[][] a = {{1,2,3}, {4,5,6}, {7,8,9}};
		int[] b = {1,4,10};
		boolean result = OperacoesMatrizes.existsInMatrix(a, b);
		
		assertFalse(result);
	}
	
	@Test
	public void testExistsInMatrixEmptyMatrix() {
		
		int[][] a = {{}, {}, {}};
		int[] b = {1,4,10};
		boolean result = OperacoesMatrizes.existsInMatrix(a, b);
		
		assertFalse(result);
	}
	
	@Test
	public void testExistsInMatrixEmptyVector() {
		
		int[][] a = {{1,2,3}, {4,5,6}, {7,8,9}};
		int[] b = {};
		boolean result = OperacoesMatrizes.existsInMatrix(a, b);
		
		assertFalse(result);
	}
	
	//Testes para verificar se a solução do Sudoku é válida
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
		boolean result = OperacoesMatrizes.isValidSudokuSolution(a);
		
		assertTrue(result);	
	}
	
	@Test
	public void testIsValidSudokuSolutionFalse() {
		
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
					  {7,4,9,6,3,1,5,2,8},
					  {5,1,3,8,4,2,9,6,7},
					  {3,7,8,9,4,6,1,5,4}, //falso nesta linha, o 1º 4 deve ser um 2
					  {1,2,4,5,8,7,6,9,3},
					  {6,9,5,4,1,3,8,7,2},
					  {4,5,1,2,6,8,7,3,9},
					  {2,8,6,3,7,9,4,1,5},
					  {9,3,7,1,5,4,2,8,6}};
		boolean result = OperacoesMatrizes.isValidSudokuSolution(a);
		
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
		boolean result = OperacoesMatrizes.isValidSudokuSolution(a);
		
		assertFalse(result);
	}
}

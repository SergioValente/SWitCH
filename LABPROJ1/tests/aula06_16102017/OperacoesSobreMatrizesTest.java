package aula06_16102017;

import static org.junit.Assert.*;

import org.junit.Test;

import aula06_16102017.OperacoesSobreMatrizes;

public class OperacoesSobreMatrizesTest {

	//Testes para verificar igualdade de duas matrizes
	@Test
	public void testisEqualMatricesEqual() {
		
		int a[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
		int b[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
		
		boolean result = OperacoesSobreMatrizes.isEqualMatrices(a, b);
		
		assertTrue(result);
	}
	
	@Test
	public void testisEqualMatricesNotEqual() {
		
		int a[][] = {{1,2,3}, {10,5,6}};
		int b[][] = {{1,2,3}, {4,5,6}};
		
		boolean result = OperacoesSobreMatrizes.isEqualMatrices(a, b);
		
		assertFalse(result);
	}
	
	@Test
	public void testisEqualMatricesEmpty() {
		
		int a[][] = {{}, {}};
		int b[][] = {{}, {}};
		
		boolean result = OperacoesSobreMatrizes.isEqualMatrices(a, b);
		
		assertTrue(result);
	}
	
	@Test
	public void testisEqualMatricesDifferentDimensions() {
		
		int a[][] = {{1,2}, {1,2}};
		int b[][] = {{1,2,3}, {1,2}};
		
		boolean result = OperacoesSobreMatrizes.isEqualMatrices(a, b);
		
		assertFalse(result);
	}

	//Testes para verificar se matriz é simétrica em relação à diagonal principal
	@Test
	public void testIsSimetricaDiagonalPrincipalTrue() {
		
		int[][] a = new int[][] {{1,2,3}, {2,4,6}, {3,6,5}};
		
		boolean result = OperacoesSobreMatrizes.isSimetricaDiagonalPrincipal(a);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsSimetricaDiagonalPrincipalFalse() {
		
		int[][] a = new int[][] {{1,2,3}, {3,4,6}, {3,6,5}};
		
		boolean result = OperacoesSobreMatrizes.isSimetricaDiagonalPrincipal(a);
		
		assertFalse(result);
	}
	
	@Test
	public void testIsSimetricaDiagonalPrincipalNotSquareMatrix() {
		
		int[][] a = new int[][] {{1,2,3}, {3,4,6}};
		
		boolean result = OperacoesSobreMatrizes.isSimetricaDiagonalPrincipal(a);
		
		assertFalse(result);
	}
	
	@Test
	public void testIsSimetricaDiagonalPrincipalEmpty() {
		
		int[][] a = new int[][] {{}, {}};
		
		boolean result = OperacoesSobreMatrizes.isSimetricaDiagonalPrincipal(a);
		
		assertFalse(result);
	}
}

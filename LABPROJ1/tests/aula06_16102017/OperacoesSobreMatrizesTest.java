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
	
	@Test
	public void testIsSimetricaDiagonalSecundariaTrue() {
		
		int[][] a = new int[][] {{1,2,3,4}, {6,5,8,3}, {9,7,5,2}, {4,9,6,1}};
		
		boolean result = OperacoesSobreMatrizes.isSimetricaDiagonalSecundaria(a);
		
		assertTrue(result);
	}
	
	@Test
	public void testIsSimetricaDiagonalSecundariaFalse() {
		
		int[][] a = new int[][] {{1,2,3,4}, {2,5,8,3}, {9,7,5,2}, {4,9,6,1}};
		
		boolean result = OperacoesSobreMatrizes.isSimetricaDiagonalSecundaria(a);
		
		assertFalse(result);
	}
	
	@Test
	public void testIsSimetricaDiagonalSecundariaNotSquareMatrix() {
		
		int[][] a = new int[][] {{1,2,3}, {4,8,2}};
		
		boolean result = OperacoesSobreMatrizes.isSimetricaDiagonalSecundaria(a);
		
		assertFalse(result);
	}
	
	@Test
	public void testIsSimetricaDiagonalSecundariaEmpty() {
		
		int[][] a = new int[][] {{}, {}, {}, {}};
		
		boolean result = OperacoesSobreMatrizes.isSimetricaDiagonalSecundaria(a);
		
		assertFalse(result);
	}
	
	@Test
	public void testMatrizTranspostaNormal() {
		
		int[][] a = new int[][] {{1,2,3}, {3,4,6}};
		int[][] expResult = {{1,3}, {2,4}, {3,6}}; 
		int[][] result = OperacoesSobreMatrizes.matrizTransposta(a);
		
		for (int i = 0; i < result.length; i++) {
			assertArrayEquals(expResult[i], result[i]);
		}
	}
	
	@Test
	public void testMatrizTranspostaEmpty() {
		
		int[][] a = new int[][] {{}, {}};
		int[][] expResult = {{}, {}}; 
		int[][] result = OperacoesSobreMatrizes.matrizTransposta(a);
		
		for (int i = 0; i < result.length; i++) {
			assertArrayEquals(expResult[i], result[i]);
		}
	}
	
	@Test
	public void testMatrizTranspostaVectorTwoElements() {
		
		int[][] a = new int[][] {{1,2}};
		int[][] expResult = {{1}, {2}}; 
		int[][] result = OperacoesSobreMatrizes.matrizTransposta(a);
		
		for (int i = 0; i < result.length; i++) {
			assertArrayEquals(expResult[i], result[i]);
		}
	}
	
	//Testes para verificar matriz simétrica usando o método da matriz transposta
		@Test
		public void testisSimetricaUsandoTranspostaTrue() {
			
			int a[][] = {{1,2,3}, {2,4,6}, {3,6,5}};
			
			boolean result = OperacoesSobreMatrizes.isSimetricaUsandoTransposta(a);
			
			assertTrue(result);
		}
		
		@Test
		public void testisSimetricaUsandoTranspostaFalse() {
			
			int a[][] = {{1,2,3}, {10,5,6}, {2,3,4}};
			
			boolean result = OperacoesSobreMatrizes.isSimetricaUsandoTransposta(a);
			
			assertFalse(result);
		}
		
		@Test
		public void testisSimetricaUsandoTranspostaEmpty() {
			
			int a[][] = {{}, {}};
			
			boolean result = OperacoesSobreMatrizes.isSimetricaUsandoTransposta(a);
			
			assertFalse(result);
		}
		
		@Test
		public void testisSimetricaUsandoTranspostaDifferentDimensions() {
			
			int a[][] = {{1,2}, {1,2},{2,4}};
			
			boolean result = OperacoesSobreMatrizes.isSimetricaUsandoTransposta(a);
			
			assertFalse(result);
		}

}

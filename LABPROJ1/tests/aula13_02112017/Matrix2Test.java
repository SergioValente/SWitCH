package aula13_02112017;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Matrix2Test {

	int[][] m1 = {{1,2},{3,4}};
	int[][] m2 = {{4,5},{6,7}};
	Matrix2 testMatrix = new Matrix2(m1);
	Matrix2 testMatrix2 = new Matrix2 (m2);
	
	//Tests to validate method addMatrix
	@Test
	public void testAddMatrix() {
		
		Matrix2 expResult = new Matrix2 (new int[][] {{5,7},{9,11}});
		Matrix2 result = testMatrix.addMatrix(testMatrix2);
		
		assertEquals(expResult, result); //Só funciona pois fizemos um override de equals e toString!!!!!
	}

	//Tests to validate method multiplyMatrix
	@Test
	public void testMultiplyMatrixSuccess() throws Exception {
		
		Matrix2 expResult = new Matrix2 (new int[][] {{16,19},{36,43}});
		Matrix2 result = testMatrix.multiplyMatrix(testMatrix2);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public void testMultiplyMatrixNotSquareMatricesSuccess() throws Exception {
		
		Matrix2 a = new Matrix2 (new int[][] {{1,2,3},{4,5,6}});
		Matrix2 b = new Matrix2(new int[][] {{7,8},{9,10},{11,12}});
		Matrix2 expResult = new Matrix2 (new int[][] {{58,64},{139,154}});
		Matrix2 result = a.multiplyMatrix(b);
		
		assertEquals(expResult, result);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testMultiplyMatrixThrowExcetption() throws Exception {
		
		Matrix2 a = new Matrix2 (new int[][] {{1,2,3,4},{4,5,6,6}});
		Matrix2 b = new Matrix2(new int[][] {{7,8},{9,10},{11,12}});
		
		a.multiplyMatrix(b);
		
	}

	//Tests to validate method getPointsWithNumber
	@Test
	public void testGetPointsWithNumber() throws Exception {
		
		int num = 2;
		Matrix2 a = new Matrix2 (new int[][] {{1,2,3},{4,2,6}});
		List<Ponto> expResult = new ArrayList<>();
		expResult.add(new Ponto(0,1));
		expResult.add(new Ponto(1,1));
		List<Ponto> result =  a.getPointsWithNumber(num);
		
		assertEquals(expResult, result);	
	}
	
	@Test
	public void testGetPointsWithNumberEmptyMatrix() throws Exception {
		
		int num = 2;
		Matrix2 a = new Matrix2 (new int[][] {{},{}});
		List<Ponto> expResult = new ArrayList<>();
		List<Ponto> result =  a.getPointsWithNumber(num);
		
		assertEquals(expResult, result);	
	}
	
	//Tests to validate method setValue

	@Test
	public void testSetValue() throws Exception {

		
		Ponto i = new Ponto(1,1);
		int num = 8;
		testMatrix.setValue(i, num);
		
		assertEquals(8, testMatrix.getValue(i));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetValuePointOutOfBounds() throws Exception {
		
		int num = 10;
		Ponto i = new Ponto (1,5);
		testMatrix.setValue(i, num);
	}

	//Tests to validate method getValue
	@Test
	public void testGetValueSuccess() throws Exception {
		
		Ponto i = new Ponto (1,1);
		int expResult = 4;
		int result = testMatrix.getValue(i);
		
		assertEquals(expResult, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetValuePointOutOfBounds() throws Exception {
		
		Ponto i = new Ponto (1,5);
		testMatrix.getValue(i);
	}
	
	@Test
	public void testSomaCadaLinhaMatrizNormal() {
		
		Matrix2 a = new Matrix2 (new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
		Vetor expResult = new Vetor (new int[]{6,15,24});
		Vetor result = a.somaCadaLinhaMatriz();
		
		assertEquals(expResult, result);
	}

	@Test(expected = Exception.class)
	public void testSomaCadaLinhaMatrizEmpty() {
		
		Matrix2 a = new Matrix2 (new int[][]{{}, {}});
		Vetor expResult = new Vetor (new int[]{});
		Vetor result = a.somaCadaLinhaMatriz();
		
		assertEquals(expResult, result);
	}
	
	@Test
	public void testSomaCadaLinhaMatrizDifferentLines() {
		
		Matrix2 a = new Matrix2 (new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
		Vetor expResult = new Vetor (new int[]{6,15,24});
		Vetor result = a.somaCadaLinhaMatriz();
		
		assertEquals(expResult, result);
	}
	
	//Testes para verificar se todos os elementos de um vetor estão presentes numa matriz
	@Test
	public void testExistsInMatrixTrue() {

		Matrix2 a = new Matrix2(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		int[] b = { 1, 4, 8 };
		boolean result = a.existsInMatrix(b);

		assertTrue(result);
	}

	@Test
	public void testExistsInMatrixFalse() {

		Matrix2 a = new Matrix2(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		int[] b = { 1, 4, 10 };
		boolean result = a.existsInMatrix(b);

		assertFalse(result);
	}

	@Test
	public void testExistsInMatrixEmptyMatrix() {

		Matrix2 a = new Matrix2(new int[][] { {}, {}, {} });
		int[] b = { 1, 4, 10 };
		boolean result = a.existsInMatrix(b);

		assertFalse(result);
	}

	@Test
	public void testExistsInMatrixEmptyVector() {

		Matrix2 a = new Matrix2(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		int[] b = {};
		boolean result = a.existsInMatrix(b);

		assertFalse(result);
	}
	
	// Testes para verificar igualdade de duas matrizes
	@Test
	public void testisEqualMatricesEqual() {

		Matrix2 a = new Matrix2 (new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		Matrix2 b = new Matrix2 (new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });

		boolean result = a.isEqualMatrices(b);

		assertTrue(result);
	}

	@Test
	public void testisEqualMatricesNotEqual() {

		Matrix2 a = new Matrix2 (new int[][]{ { 1, 2, 3 }, { 4, 5, 6 } });
		Matrix2 b = new Matrix2 (new int[][]{ { 1, 2, 3 }, { 10, 5, 6 } });

		boolean result = a.isEqualMatrices(b);

		assertFalse(result);
	}

	@Test
	public void testisEqualMatricesEmpty() {

		Matrix2 a = new Matrix2 (new int[][]{ {}, {} });
		Matrix2 b = new Matrix2 (new int[][]{ {}, {} });

		boolean result = a.isEqualMatrices(b);

		assertTrue(result);
	}

	@Test
	public void testisEqualMatricesDifferentDimensions() {

		Matrix2 a = new Matrix2 (new int[][]{ { 1, 2 }, { 1, 2 } });
		Matrix2 b = new Matrix2 (new int[][]{ { 1, 2, 3 }, { 1, 2, 3 } });

		boolean result = a.isEqualMatrices(b);

		assertFalse(result);
	}
	
	// Testes para calcular matriz transposta
	@Test
	public void testMatrizTranspostaNormal() throws Exception{

		Matrix2 a = new Matrix2 (new int[][] { { 1, 2, 3 }, { 3, 4, 6 } });
		Matrix2 expResult = new Matrix2 (new int[][]{ { 1, 3 }, { 2, 4 }, { 3, 6 } });
		Matrix2 result = a.matrizTransposta();
		
		assertEquals(expResult, result);
	}

	@Test(expected = Exception.class)
	public void testMatrizTranspostaEmpty() throws Exception{

		Matrix2 a = new Matrix2 (new int[][] { {}, {} });
		Matrix2 expResult = new Matrix2 (new int[][]{ {}, {}, {} });
		Matrix2 result = a.matrizTransposta();
		
		assertEquals(expResult, result);
	}

	@Test
	public void testMatrizTranspostaVectorTwoElements() throws Exception{

		Matrix2 a = new Matrix2(new int[][] { { 1, 2 } });
		Matrix2 expResult = new Matrix2(new int[][]{ { 1 }, { 2 } });
		Matrix2 result = a.matrizTransposta();

		assertEquals(expResult, result);
	}
	
	// Testes para verificar se matriz é simétrica em relação à diagonal principal
	@Test
	public void testIsSimetricaDiagonalPrincipalTrue() {

		Matrix2 a = new Matrix2 (new int[][] { { 1, 2, 3 }, { 2, 4, 6 }, { 3, 6, 5 } });

		boolean result = a.isSimetricaDiagonalPrincipal();

		assertTrue(result);
	}

	@Test
	public void testIsSimetricaDiagonalPrincipalFalse() {

		Matrix2 a = new Matrix2 (new int[][] { { 1, 2, 3 }, { 3, 4, 6 }, { 3, 6, 5 } });
		boolean result = a.isSimetricaDiagonalPrincipal();

		assertFalse(result);
	}

	@Test
	public void testIsSimetricaDiagonalPrincipalNotSquareMatrix() {

		Matrix2 a = new Matrix2 (new int[][] { { 1, 2, 3 }, { 3, 4, 6 } });

		boolean result = a.isSimetricaDiagonalPrincipal();

		assertFalse(result);
	}

	@Test
	public void testIsSimetricaDiagonalPrincipalEmpty() {

		Matrix2 a = new Matrix2 (new int[][] { {}, {} });

		boolean result = a.isSimetricaDiagonalPrincipal();

		assertFalse(result);
	}
	
	// Testes para verificar se matriz é simétrica em relação à diagonal secundária
	@Test
	public void testIsSimetricaDiagonalSecundariaTrue() {

		Matrix2 a = new Matrix2(new int[][] { { 1, 2, 3, 4 }, { 6, 5, 8, 3 }, { 9, 7, 5, 2 }, { 4, 9, 6, 1 } });

		boolean result = a.isSimetricaDiagonalSecundaria();

		assertTrue(result);
	}

	@Test
	public void testIsSimetricaDiagonalSecundariaFalse() {

		Matrix2 a = new Matrix2 (new int[][] { { 1, 2, 3, 4 }, { 2, 5, 8, 3 }, { 9, 7, 5, 2 }, { 4, 9, 6, 1 } });

		boolean result = a.isSimetricaDiagonalSecundaria();

		assertFalse(result);
	}

	@Test
	public void testIsSimetricaDiagonalSecundariaNotSquareMatrix() {

		Matrix2 a = new Matrix2(new int[][] { { 1, 2, 3 }, { 4, 8, 2 } });
		boolean result = a.isSimetricaDiagonalSecundaria();
		assertFalse(result);
	}

	@Test
	public void testIsSimetricaDiagonalSecundariaEmpty() {

		Matrix2 a = new Matrix2 (new int[][] { {}, {}, {}, {} });
		boolean result = a.isSimetricaDiagonalSecundaria();

		assertFalse(result);
	}
}

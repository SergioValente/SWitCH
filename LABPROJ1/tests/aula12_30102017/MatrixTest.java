package aula12_30102017;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MatrixTest {

	int[][] m1 = {{1,2},{3,4}};
	int[][] m2 = {{4,5},{6,7}};
	Matrix testMatrix = new Matrix(m1);
	Matrix testMatrix2 = new Matrix (m2);
	
	//Tests to validate method addMatrix
	@Test
	public void testAddMatrix() {
		
		Matrix expResult = new Matrix (new int[][] {{5,7},{9,11}});
		Matrix result = testMatrix.addMatrix(testMatrix2);
		
		assertEquals(expResult, result); //Só funciona pois fizemos um override de equals e toString!!!!!
	}

	//Tests to validate method multiplyMatrix
	@Test
	public void testMultiplyMatrixSuccess() throws Exception {
		
		Matrix expResult = new Matrix (new int[][] {{16,19},{36,43}});
		Matrix result = testMatrix.multiplyMatrix(testMatrix2);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public void testMultiplyMatrixNotSquareMatricesSuccess() throws Exception {
		
		Matrix a = new Matrix (new int[][] {{1,2,3},{4,5,6}});
		Matrix b = new Matrix(new int[][] {{7,8},{9,10},{11,12}});
		Matrix expResult = new Matrix (new int[][] {{58,64},{139,154}});
		Matrix result = a.multiplyMatrix(b);
		
		assertEquals(expResult, result);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testMultiplyMatrixThrowExcetption() throws Exception {
		
		Matrix a = new Matrix (new int[][] {{1,2,3,4},{4,5,6,6}});
		Matrix b = new Matrix(new int[][] {{7,8},{9,10},{11,12}});
		
		a.multiplyMatrix(b);
		
	}

	//Tests to validate method getPointsWithNumber
	@Test
	public void testGetPointsWithNumber() throws Exception {
		
		int num = 2;
		Matrix a = new Matrix (new int[][] {{1,2,3},{4,2,6}});
		List<Ponto> expResult = new ArrayList<>();
		expResult.add(new Ponto(0,1));
		expResult.add(new Ponto(1,1));
		List<Ponto> result =  a.getPointsWithNumber(num);
		
		assertEquals(expResult, result);	
	}
	
	@Test
	public void testGetPointsWithNumberEmptyMatrix() throws Exception {
		
		int num = 2;
		Matrix a = new Matrix (new int[][] {{},{}});
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
}

package aula12_30102017;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

	int[][] m1 = {{1,2},{3,4}};
	int[][] m2 = {{4,5},{6,7}};
	Matrix testMatrix = new Matrix(m1);
	Matrix testMatrix2 = new Matrix (m2);
	
	@Test
	public void testAddMatrix() {
		
		Matrix expResult = new Matrix (new int[][] {{5,7},{9,11}});
		Matrix result = testMatrix.addMatrix(testMatrix2);
		
		assertEquals(expResult, result); //Só funciona pois fizemos um override de equals!!!!!
	}

	@Test
	public void testMultiplyMatrix() throws Exception {
		
		Matrix expResult = new Matrix (new int[][] {{16,19},{36,43}});
		Matrix result = testMatrix.multiplyMatrix(testMatrix2);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public void testMultiplyMatrixNotSquareMatrices() throws Exception {
		
		Matrix a = new Matrix (new int[][] {{1,2,3},{4,5,6}});
		Matrix b = new Matrix(new int[][] {{7,8},{9,10},{11,12}});
		Matrix expResult = new Matrix (new int[][] {{58,64},{139,154}});
		Matrix result = a.multiplyMatrix(b);
		
		assertEquals(expResult, result);
	}
	
	@Test (expected = Exception.class)
	public void testMultiplyMatrixThrowExcetption() throws Exception {
		
		Matrix a = new Matrix (new int[][] {{1,2,3,4},{4,5,6,6}});
		Matrix b = new Matrix(new int[][] {{7,8},{9,10},{11,12}});
		
		a.multiplyMatrix(b);
		
	}
	
}

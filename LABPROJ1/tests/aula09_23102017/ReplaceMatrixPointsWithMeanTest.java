package aula09_23102017;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class ReplaceMatrixPointsWithMeanTest {

	@Test
	public void testReplaceMatrixPointsWithMeanMatrixAllZeros() {
		
		int[][] testMatrix = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		int[][] expResult = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		int[][] result = ReplaceMatrixPointsWithMean.replaceMatrixPoints(testMatrix);
		
		assertThat(expResult, equalTo(result));
	}

	@Test
	public void testReplaceMatrixPointsWithMeanValidResult() {
		
		int[][] testMatrix = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
		int[][] expResult = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
		int[][] result = ReplaceMatrixPointsWithMean.replaceMatrixPoints(testMatrix);
		
		assertThat(expResult, equalTo(result));
	}
	
	@Test
	public void testReplaceMatrixPointsWithMeanInvalidResult() {
		
		int[][] testMatrix = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
		int[][] expResult = {{1,5,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
		int[][] result = ReplaceMatrixPointsWithMean.replaceMatrixPoints(testMatrix);
		
		assertThat(expResult, not(equalTo(result)));
	}
	
	@Test
	public void testReplaceMatrixPointsWithMeanValidResult2() {
		
		int[][] testMatrix = {{2,5,3,4},{1,7,1,0},{0,2,5,10},{0,0,1,2}};
		int[][] expResult = {{2,5,3,4},{1,2,4,0},{0,3,4,10},{0,0,1,2}};
		int[][] result = ReplaceMatrixPointsWithMean.replaceMatrixPoints(testMatrix);
		
		assertThat(expResult, equalTo(result));
	}
	
	@Test
	public void testReplaceMatrixPointsWithMeanNotSquareMatrix() {
		
		int[][] testMatrix = {{1,2,3,4},{1,2,3,4},{1,2,3,4}};
		int[][] expResult = {{1,2,3,4},{1,2,3,4},{1,2,3,4}};
		int[][] result = ReplaceMatrixPointsWithMean.replaceMatrixPoints(testMatrix);
		
		assertThat(expResult, equalTo(result));
	}

	@Test
	public  void testMeanOfFourPointsValidResult() {
	
		int[][] testMatrix = {{2,5,3,4},{2,7,1,0},{0,2,5,10},{0,0,1,2}};
		int i = 2;
		int j = 2;
		int expResult = 4;
		int result = ReplaceMatrixPointsWithMean.meanOfFourPoints(testMatrix, i, j);
	
		assertThat(expResult, equalTo(result));
	}

	@Test
	public  void testMeanOfAllNeighbourPointsValidResult() {
	
		int[][] testMatrix = {{2,5,3,4},{2,7,1,0},{0,2,5,10},{0,0,1,2}};
		int i = 2;
		int j = 2;
		int expResult = 3;
		int result = ReplaceMatrixPointsWithMean.meanOfAllNeighbourPoints(testMatrix, i, j);
	
		assertThat(expResult, equalTo(result));
	}

	@Test
	public  void testFillBorderlineValuesValidResult() {
	
		int[][] testMatrix = {{2,5,3,4},{2,7,1,0},{0,2,5,10},{0,0,1,2}};
		int[][] expResult = {{2,5,3,4},{2,0,0,0},{0,0,0,10},{0,0,1,2}};
		int[][] result = ReplaceMatrixPointsWithMean.fillBorderlineValues(testMatrix);
	
		assertThat(expResult, equalTo(result));
	}

	@Test
	public  void testMeanOfAllNeighbourPointsExceptCenter() {
	
		int[][] testMatrix = {{2,5,3,4},{2,7,1,0},{0,2,5,10},{0,0,1,2}};
		int i = 2;
		int j = 2;
		int expResult = 3;
		int result = ReplaceMatrixPointsWithMean.meanOfAllNeighbourPoints(testMatrix, i, j);
	
		assertThat(expResult, equalTo(result));
	}
}

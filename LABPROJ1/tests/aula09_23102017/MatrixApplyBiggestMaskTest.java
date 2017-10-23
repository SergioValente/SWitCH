package aula09_23102017;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixApplyBiggestMaskTest {

	@Test
	public void testBiggestMaskSizeNormalResult() {
		int numLines = 10;
		int numColumns = 10;
		int maxMaskSize = 25;
		int indexLine = 1;
		int indexColumn = 5;
		int expResult = 3;
		int result = MatrixApplyBiggestMask.biggestMaskSize(numLines, numColumns, 
				maxMaskSize, indexLine, indexColumn);
		
		assertEquals(expResult, result);
	}

	@Test
	public void testCalculateMeanValueApplyingMaskNormalResult() {
		
		int[][] testMatrix = {{2,5,3,4},{2,7,1,0},{0,2,5,10},{0,0,1,2}};
		int maskSize = 3;
		int i = 2;
		int j = 2;
		int expResult = 3;
		int result = MatrixApplyBiggestMask.calculateMeanValueApplyingMask(testMatrix, maskSize, i, j);	
		
		assertThat(expResult, equalTo(result));
		}
	
	@Test
	public void testCalculateMeanValueApplyingMaskMatrixAllZeros() {
		
		int[][] testMatrix = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		int maskSize = 3;
		int i = 2;
		int j = 2;
		int expResult = 0;
		int result = MatrixApplyBiggestMask.calculateMeanValueApplyingMask(testMatrix, maskSize, i, j);	
		
		assertThat(expResult, equalTo(result));
		}

	@Test
	public  void testApplyMaskNormalResult() {
		
		int userMaskSize = 21;
		int[][] testMatrix = {{1,2,3,7,3},
				              {23,0,0,4,6},
				              {2,78,255,2,0},
				              {6,4,3,2,1},
				              {98,4,5,7,10},
				              {0,9,38,65,23}};
		int[][] expResult = {{1,2,3,7,3},
							 {23,40,39,31,6},
							 {2,41,21,30,0},
							 {6,51,26,32,1},
							 {98,19,15,17,10},
							 {0,9,38,65,23}};
		int[][] result = MatrixApplyBiggestMask.applyMask(testMatrix, userMaskSize); 
		assertThat(expResult, equalTo(result));
	}
}

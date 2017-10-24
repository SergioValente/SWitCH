package aula07_24102017;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberOcurrencesCharTest {

	@Test
	public void testOcurrencesNormalResult() {
		
		char[][] testMatrix = {{'a','b','c'}, 
							   {'d','e','c'},
							   {'c','w','r'}};
		char testCharacter = 'c';
		int expResult = 3;
		int result = NumberOcurrencesChar.ocurrences(testMatrix, testCharacter);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public void testOcurrencesEmptyMatrix() {
		
		char[][] testMatrix = {{}, {},{}};
		char testCharacter = 'c';
		int expResult = 0;
		int result = NumberOcurrencesChar.ocurrences(testMatrix, testCharacter);
		
		assertEquals(expResult, result);
	}

	@Test
	public  void testNumberOcurrencesBlackWhiteAndFreeNormalResult() {
	
		char[][] testMatrix = {{'l','l','b','b','b'},
							  {'b','w','w','w','b'},
							  {'l','b','b','w','w'},
							  {'l','l','l','w','b'},
							  {'w','w','w','w','w'}};
		int[] expResult = {6,8,11};
		int[] result = NumberOcurrencesChar.numberOcurrencesBlackWhiteAndFree(testMatrix);
	
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public  void testNumberOcurrencesBlackWhiteAndFreeEmptyMatrix() {
	
		char[][] testMatrix = {{},{},{},{},{}};
		int[] expResult = {0,0,0};
		int[] result = NumberOcurrencesChar.numberOcurrencesBlackWhiteAndFree(testMatrix);
	
		assertArrayEquals(expResult, result);
	}
}

package aula11_27102017;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayTransformTest {

	@Test
	public void testTransformsArray() {
		
		char[] orders = {'F','P','R','F','P','R','F','P','R','R','F','F','F','F','P','R','R','R',
				 'F','P'};
		char[] expResult = {'F','P','R','F','P','R','F','P','I','F','F','F','F','P','L','F','P','P','P','P'};
		char[] result = ArrayTransform.transformsArray(orders);
		
		assertArrayEquals(expResult, result);
		assertTrue(ArrayTransform.lastArrayPosition == 16);
	}

	//Tests to validate method arrayIsEmpty
	@Test
	public void testArrayIsEmptyTrue() {
		
		char[] orders = {};
		boolean result = ArrayTransform.arrayIsEmpty(orders);
		
		assertTrue(result);
	}
	
	@Test
	public void testArrayIsEmptyFalse() {
		
		char[] orders = {'R'};
		boolean result = ArrayTransform.arrayIsEmpty(orders);
		
		assertFalse(result);
	}

	//Tests to validate arrayHasOnlyOneElement
	@Test
	public void testArrayHasOnlyOneElementTrue() {
		
		char[] orders = {'R'};
		boolean result = ArrayTransform.arrayHasOnlyOneElement(orders);
		
		assertTrue(result);
	}
	
	@Test
	public void testArrayHasOnlyOneElementFalse() {
		
		char[] orders = {'R','P'};
		boolean result = ArrayTransform.arrayHasOnlyOneElement(orders);
		
		assertFalse(result);
	}

	//Tests to validate method removeElement
	@Test
	public  void testRemoveElementSuccess() {
		
		char[] orders = {'F','P','f','F','P','R','F','P','R','R','F','F','F','F'};
		ArrayTransform.lastArrayPosition = orders.length - 1;
		int index = 2;
		char[] expResult = {'F','P','F','P','R','F','P','R','R','F','F','F','F','F'};
		char[] result = ArrayTransform.removeElement(orders, index);
		
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public  void testRemoveElementSuccessPenultimateElement() {
		
		char[] orders = {'F','P','F','P','R','F','P','R','R','F','F','F','f','P'};
		ArrayTransform.lastArrayPosition = orders.length - 1;
		int index = 12;
		char[] expResult = {'F','P','F','P','R','F','P','R','R','F','F','F','P','P'};
		char[] result = ArrayTransform.removeElement(orders, index);
		
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public  void testRemoveElementSuccessLastElement() {
		
		char[] orders = {'F','P','F','P','R','F','P','R','R','F','F','F','P','p'};
		ArrayTransform.lastArrayPosition = orders.length - 1;
		int index = 13;
		char[] expResult = {'F','P','F','P','R','F','P','R','R','F','F','F','P','p'};
		char[] result = ArrayTransform.removeElement(orders, index);
		
		assertArrayEquals(expResult, result);
		assertTrue(ArrayTransform.lastArrayPosition == 12);
	}

	//Test to validate method arrayHasNextElement
	@Test
	public void testArrayHasNextElementTrue() {

		int index = 5;
		ArrayTransform.lastArrayPosition = 9;
		boolean result = ArrayTransform.arrayHasNextElement(index);

		assertTrue(result);
	}

	@Test
	public void testArrayHasNextElementFalse() {

		int index = 8;
		ArrayTransform.lastArrayPosition = 8;
		boolean result = ArrayTransform.arrayHasNextElement(index);

		assertFalse(result);
	}

	// Tests to validate method fetchNextArrayElement
	@Test
	public void testFetchNextArrayElement() {

		char[] orders = { 'F', 'P', 'F', 'P', 'R', 'F', 'P', 'R', 'R', 'F', 'F', 'F', 'f', 'P' };
		int index = 5;
		char expResult = 'P';
		char result = ArrayTransform.fetchNextArrayElement(orders, index);
		assertEquals(expResult, result);
	}

//	@Test
//	public void testVerifyArrayErrors() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCompareWithNextOrder() {
//		fail("Not yet implemented");
//	}

	// Tests to validate method invertMovement
	@Test
	public void testInvertMovementSuccess() {

		char[] orders = { 'F', 'P', 'F', 'P', 'R', 'F', 'P', 'R', 'R', 'F', 'F', 'F', 'f', 'P' };
		int index = 7;
		ArrayTransform2.lastArrayPosition = orders.length - 1;
		char[] expResult = { 'F', 'P', 'F', 'P', 'R', 'F', 'P', 'I', 'F', 'F', 'F', 'f', 'P', 'P' };
		char[] result = ArrayTransform2.invertMovement(orders, index);

		assertArrayEquals(expResult, result);
	}

//	@Test
//	public void testMoveLeft() {
//		fail("Not yet implemented");
//	}

}

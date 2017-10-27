package aula11_27102017;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayTransform2Test {

	@Test
	public void testTransformsArray() {
		
		char[] orders = {'F','P','R','F','P','R','F','P','R','R','F','F','F','F','P','R','R','R',
				 'F','P'};
		char[] expResult = {'F','P','R','F','P','R','F','P','I','F','F','F','F','P','L','F','P','P','P','P'};
		char[] result = ArrayTransform2.transformsArray(orders);
		
		assertArrayEquals(expResult, result);
		assertTrue(ArrayTransform2.lastArrayPosition == 16);
	}

	//Tests to validate method arrayIsEmpty
	@Test
	public void testArrayIsEmptyTrue() {
		
		char[] orders = {};
		boolean result = ArrayTransform2.arrayIsEmpty(orders);
		
		assertTrue(result);
	}
	
	@Test
	public void testArrayIsEmptyFalse() {
		
		char[] orders = {'R'};
		boolean result = ArrayTransform2.arrayIsEmpty(orders);
		
		assertFalse(result);
	}

	//Tests to validate arrayHasOnlyOneElement
	@Test
	public void testArrayHasOnlyOneElementTrue() {
		
		char[] orders = {'R'};
		boolean result = ArrayTransform2.arrayHasOnlyOneElement(orders);
		
		assertTrue(result);
	}
	
	@Test
	public void testArrayHasOnlyOneElementFalse() {
		
		char[] orders = {'R','P'};
		boolean result = ArrayTransform2.arrayHasOnlyOneElement(orders);
		
		assertFalse(result);
	}

	//Tests to validate method removeElement
	@Test
	public  void testRemoveElementSuccess() {
		
		char[] orders = {'F','P','f','F','P','R','F','P','R','R','F','F','F','F'};
		ArrayTransform2.lastArrayPosition = orders.length - 1;
		int index = 2;
		char[] expResult = {'F','P','F','P','R','F','P','R','R','F','F','F','F','F'};
		char[] result = ArrayTransform2.removeElement(orders, index);
		
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public  void testRemoveElementSuccessPenultimateElement() {
		
		char[] orders = {'F','P','F','P','R','F','P','R','R','F','F','F','f','P'};
		ArrayTransform2.lastArrayPosition = orders.length - 1;
		int index = 12;
		char[] expResult = {'F','P','F','P','R','F','P','R','R','F','F','F','P','P'};
		char[] result = ArrayTransform2.removeElement(orders, index);
		
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public  void testRemoveElementSuccessLastElement() {
		
		char[] orders = {'F','P','F','P','R','F','P','R','R','F','F','F','P','p'};
		ArrayTransform2.lastArrayPosition = orders.length - 1;
		int index = 13;
		char[] expResult = {'F','P','F','P','R','F','P','R','R','F','F','F','P','p'};
		char[] result = ArrayTransform2.removeElement(orders, index);
		
		assertArrayEquals(expResult, result);
		assertTrue(ArrayTransform2.lastArrayPosition == 12);
	}

	//Test to validate method arrayHasNextElement
	@Test
	public void testArrayHasNextElementTrue() {

		int index = 5;
		ArrayTransform2.lastArrayPosition = 9;
		boolean result = ArrayTransform2.arrayHasNextElement(index);

		assertTrue(result);
	}

	@Test
	public void testArrayHasNextElementFalse() {

		int index = 8;
		ArrayTransform2.lastArrayPosition = 8;
		boolean result = ArrayTransform2.arrayHasNextElement(index);

		assertFalse(result);
	}

	// Tests to validate method fetchNextArrayElement
	@Test
	public void testFetchNextArrayElement() {

		char[] orders = { 'F', 'P', 'F', 'P', 'R', 'F', 'P', 'R', 'R', 'F', 'F', 'F', 'f', 'P' };
		int index = 5;
		char expResult = 'P';
		char result = ArrayTransform2.fetchNextArrayElement(orders, index);
		assertEquals(expResult, result);
	}

	//Tests to validate method compareWithNextOrder
	@Test
	public  void testCompareWithNextOrderSuccess() {
	
		char[] orders = { 'F', 'P', 'F', 'P', 'R', 'F', 'P', 'R', 'R', 'F', 'F', 'F', 'f', 'P' };
		int index = 7;
		boolean result = ArrayTransform2.compareWithNextOrder(orders, index);
		
		assertTrue(result);
	}
	
	@Test
	public  void testCompareWithNextOrderFalse() {
	
		char[] orders = { 'F', 'P', 'F', 'P', 'R', 'F', 'P', 'R', 'R', 'F', 'F', 'F', 'f', 'P' };
		int index = 4;
		boolean result = ArrayTransform2.compareWithNextOrder(orders, index);
		
		assertFalse(result);
	}
	
	@Test
	public  void testCompareWithNextOrderWithInvalidOrder() {
	
		char[] orders = { 'F', 'P', 'F', 'P', 'R', 'o', 'P', 'R', 'R', 'F', 'F', 'F', 'f', 'P' };
		ArrayTransform2.lastArrayPosition = orders.length - 1;
		int index = 4;
		boolean result = ArrayTransform2.compareWithNextOrder(orders, index);
		
		assertFalse(result);
	}
	
	@Test
	public  void testCompareWithNextOrderWithInvalidOrdersNextValidIsR() {
	
		char[] orders = { 'F', 'P', 'F', 'P', 'R', 'o', 'v', 'R', 'R', 'F', 'F', 'F', 'f', 'P' };
		ArrayTransform2.lastArrayPosition = orders.length - 1;
		int index = 4;
		boolean result = ArrayTransform2.compareWithNextOrder(orders, index);
		
		assertTrue(result);
	}
	
	@Test
	public  void testCompareWithNextOrderWithInvalidOrdersUntilTheEnd() {
	
		char[] orders = { 'F', 'P', 'F', 'P', 'R', 'o', 'v', 'R', 'R', 'i', 'y', 'e', 'f', 'm' };
		ArrayTransform2.lastArrayPosition = orders.length - 1;
		int index = 8;
		boolean result = ArrayTransform2.compareWithNextOrder(orders, index);
		
		assertFalse(result);
	}
	
	//Tests to validate method invertMovement
	@Test
	public  void testInvertMovementSuccess() {
	
		char[] orders = { 'F', 'P', 'F', 'P', 'R', 'F', 'P', 'R', 'R', 'F', 'F', 'F', 'f', 'P' };
		int index = 7;
		ArrayTransform2.lastArrayPosition = orders.length - 1;
		char[] expResult = { 'F', 'P', 'F', 'P', 'R', 'F', 'P', 'I', 'F', 'F', 'F', 'f', 'P', 'P'};
		char[] result = ArrayTransform2.invertMovement(orders, index);
		
		assertArrayEquals(expResult, result);
	}
}

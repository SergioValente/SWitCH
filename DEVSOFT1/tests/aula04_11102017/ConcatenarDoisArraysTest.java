package aula04_11102017;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConcatenarDoisArraysTest {

	@Test
	public final void testConcatenarDoisArrays1() {
		
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {6, 7};
		
		int[] expResult = {1, 2, 3, 4, 5, 6, 7};
		int[] result = aula04_11102017.ConcatenarDoisArrays.concatenarDoisArrays(a, b);
		
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public final void testConcatenarDoisArrays2() {
		
		int[] a = {};
		int[] b = {6, 7};
		
		int[] expResult = {6, 7};
		int[] result = aula04_11102017.ConcatenarDoisArrays.concatenarDoisArrays(a, b);
		
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public final void testConcatenarDoisArrays3() {
		
		int[] a = {1, 2, 3, 4};
		int[] b = {};
		
		int[] expResult = {1, 2, 3, 4};
		int[] result = aula04_11102017.ConcatenarDoisArrays.concatenarDoisArrays(a, b);
		
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public final void testConcatenarDoisArrays4() {
		
		int[] a = {};
		int[] b = {};
		
		int[] expResult = {};
		int[] result = aula04_11102017.ConcatenarDoisArrays.concatenarDoisArrays(a, b);
		
		assertArrayEquals(expResult, result);
	}
}

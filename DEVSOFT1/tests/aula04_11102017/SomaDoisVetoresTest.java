package aula04_11102017;

import static org.junit.Assert.*;

import org.junit.Test;

public class SomaDoisVetoresTest {

	@Test
	public final void testSomaDoisVetores1() {
		
		int[] a = {1, 2, 3, 4};
		int[] b = {-1, 3, 4, 5};
		
		int[] expResult = {0, 5, 7, 9};
		int[] result = aula04_11102017.SomaDoisVetores.somaDoisVetores(a, b);
		
		assertArrayEquals(expResult, result);	
	}
	
	@Test
	public final void testSomaDoisVetores2() {
		
		int[] a = {0, 0, 0};
		int[] b = {0, 0, 0};
		
		int[] expResult = {0, 0, 0};
		int[] result = aula04_11102017.SomaDoisVetores.somaDoisVetores(a, b);
		
		assertArrayEquals(expResult, result);	
	}
	
	@Test (expected = Exception.class)
	public final void testSomaDoisVetores3() {
		
		int[] a = {1, 2, 3};
		int[] b = {2, 3, 4, 5};
		
		aula04_11102017.SomaDoisVetores.somaDoisVetores(a, b);
	}
	
	@Test
	public final void testSomaDoisVetores4() {
		
		int[] a = {};
		int[] b = {};
		
		int[] expResult = {};
		int[] result = aula04_11102017.SomaDoisVetores.somaDoisVetores(a, b);
		
		assertArrayEquals(expResult, result);	
	}
	
	@Test
	public final void testSomaDoisVetores5() {
		
		int[] a = new int[0];
		int[] b = new int[0];
		
		int[] expResult = {};
		int[] result = aula04_11102017.SomaDoisVetores.somaDoisVetores(a, b);
		
		assertArrayEquals(expResult, result);	
	}
}

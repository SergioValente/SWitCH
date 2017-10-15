package aula03_09102017;

import static org.junit.Assert.*;


import org.junit.Test;

import aula03_09102017.MaximoDivisorComum;

public class MaximoDivisorComumTest {

	@Test
	public void testMaxDivComum() {
		
		assertEquals(5, MaximoDivisorComum.maxDivComum(10, 15));
		assertEquals(6, MaximoDivisorComum.maxDivComum(12, 18));
		assertEquals(200, MaximoDivisorComum.maxDivComum(200, 400));
		assertEquals(0, MaximoDivisorComum.maxDivComum(0, 0));
		assertEquals(15, MaximoDivisorComum.maxDivComum(0, 15));
		
		//Teste NetBeans
		int maior = 18;
		int menor = 12;
		int expResult = 6;
		int result = MaximoDivisorComum.maxDivComum(maior, menor);
		assertEquals(expResult, result);
		
	}

}

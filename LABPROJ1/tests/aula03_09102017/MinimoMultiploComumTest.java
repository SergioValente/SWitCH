package aula03_09102017;

import static org.junit.Assert.*;

import org.junit.Test;

import aula03_09102017.MinimoMultiploComum;

public class MinimoMultiploComumTest {

	@Test
	public final void testMMC() {
		
		assertEquals(60, aula03_09102017.MinimoMultiploComum.MMC(15, 4));
		assertEquals(2, aula03_09102017.MinimoMultiploComum.MMC(100, 150));
		assertEquals((int) Double.NaN, aula03_09102017.MinimoMultiploComum.MMC(0, 0));
		assertEquals(13, aula03_09102017.MinimoMultiploComum.MMC(1, 13));
		
		
		//Teste NetBeans
		int num1 = 2;
		int num2 = 4;
		int expResult = 2;
		int result = MinimoMultiploComum.MMC(num1, num2);
		assertEquals(expResult, result);
	}

}

package aula03_09102017;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NumeroPerfeito2Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsNumPerfeito() {
		
		assertEquals(true, aula03_09102017.NumeroPerfeito2.isNumPerfeito(153));
		assertEquals(false, aula03_09102017.NumeroPerfeito2.isNumPerfeito(3));
		assertTrue(aula03_09102017.NumeroPerfeito2.isNumPerfeito(407));
		
		//Teste Netbeans
		//System.out.println("isNumPerfeito");
		long num = 153L;
		boolean expResult = true;
		boolean result = aula03_09102017.NumeroPerfeito2.isNumPerfeito(num);
		assertEquals(expResult, result);
	}

}

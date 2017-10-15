package aula03_10102017;

import static org.junit.Assert.*;

import org.junit.Test;

import aula03_10102017.Funcoes;

public class FuncoesTest {

	@Test 
	public final void testFactorial1() {
		
		int result;
		try {
			result = Funcoes.factorial(0);
			assertEquals(1, result);
		} catch (Exception e) {
			fail(e.getMessage());
		}	
	}
	
	@Test
	public final void testFactorial2() {
		
		int result;
		try {
			result = Funcoes.factorial(1);
			assertEquals(1, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public final void testFactorial3() {
		
		int result;
		try {
			result = Funcoes.factorial(2);
			assertEquals(2, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public final void testFactorial4() {
		
		int result;
		try {
			result = Funcoes.factorial(5);
			assertEquals(120, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test(expected = Exception.class)
	public final void testFactorial5() throws Exception {
		
		//neste caso não é necessário o try/catch pelo expected a seguir a @Test!!!!!
		Funcoes.factorial(-2);
	}
	
	@Test
	public final void testMaior1() {
		
		int result;
		int a = 2;
		int b = 3;
		
		result = Funcoes.maior(a, b);
		assertEquals(3, result);	
	}
	
	@Test
	public final void testMaior2() {
		
		int result;
		int a = 2;
		int b = 5;
		int c = -3;
		
		result = Funcoes.maior(a, b, c);
		assertEquals(5, result);	
	}
	
	@Test
	public final void testMaior3() {
		
		int result;
		int a = 2;
		int b = -3;
		int c = 234;
		int d = 34;
		
		result = Funcoes.maior(a, b, c, d);
		assertEquals(234, result);	
	}
	
	@Test
	public final void testMaior4() {
		
		int[] numeros = {2,3,6, -2, 10, 20, -45};
		int result = Funcoes.maior(numeros);
		
		assertEquals(20, result);
	}
	
	@Test
	public final void testFibonacci1() {
		
		int[] expResult = {0,1,1,2,3,5,8,13,21,34,55};
		int numero = expResult.length;
		
		int[] result;
		try {
			result = Funcoes.fibonacci(numero);
			assertArrayEquals(expResult, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test (expected = Exception.class)
	public final void testFibonacci2() throws Exception {
		
		Funcoes.fibonacci(1);
	}
	
	@Test
	public final void invertedArrayTest() {
		
		char[] charTest = {'d', 'c', 'b', 'a'};
		char[] expResult = {'a', 'b', 'c', 'd'};
		char[] result = Funcoes.invertedArray(charTest);
		
		assertArrayEquals(expResult, result);
	}
}

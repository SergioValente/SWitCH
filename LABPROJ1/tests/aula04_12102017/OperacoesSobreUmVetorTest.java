package aula04_12102017;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperacoesSobreUmVetorTest {

	@Test
	public final void testTamanhoVetor1() {
		
		int[] a = {1,2};
		
		int expResult = 2;
		int result = aula04_12102017.OperacoesSobreUmVetor.tamanhoVetor(a);
		
		assertEquals(expResult, result);
	}

	@Test
	public final void testTamanhoVetor2() {
		
		int[] a = {};
		
		int expResult = 0;
		int result = aula04_12102017.OperacoesSobreUmVetor.tamanhoVetor(a);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public final void testTamanhoVetor3() {
		
		int[] a = new int[] {};
		
		int expResult = 0;
		int result = aula04_12102017.OperacoesSobreUmVetor.tamanhoVetor(a);
		
		assertEquals(expResult, result);
	}
	
	@Test(expected = Exception.class)
	public final void testMaiorNoVetor1() throws Exception {
		
		int[] a = {};
		
		aula04_12102017.OperacoesSobreUmVetor.maiorNoVetor(a);
	}
	
	@Test
	public final void testMaiorNoVetor2() throws Exception {
		
		int[] a = {1,2,3};
		
		int expResult = 3;
		int result = aula04_12102017.OperacoesSobreUmVetor.maiorNoVetor(a);
		
		assertEquals(expResult, result);
	}

	@Test(expected = Exception.class)
	public final void testMaiorNoVetor3() throws Exception {
		
		int[] a = new int[] {};
		
		aula04_12102017.OperacoesSobreUmVetor.maiorNoVetor(a);
		
	}
	
	@Test
	public final void testMaiorNoVetor4() throws Exception {
		
		int[] a = {1,3,2};
		
		int expResult = 3;
		int result = aula04_12102017.OperacoesSobreUmVetor.maiorNoVetor(a);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public final void testMaiorNoVetor5() throws Exception {
		
		int[] a = {3,2,1};
		
		int expResult = 3;
		int result = aula04_12102017.OperacoesSobreUmVetor.maiorNoVetor(a);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public final void testMaiorNoVetor6() throws Exception {
		
		int[] a = {-10,2,3};
		
		int expResult = 3;
		int result = aula04_12102017.OperacoesSobreUmVetor.maiorNoVetor(a);
		
		assertEquals(expResult, result);
	}
	
	@Test(expected = Exception.class)
	public final void testMenorNoVetor1() throws Exception {

		int[] a = new int[] {};
		
		aula04_12102017.OperacoesSobreUmVetor.menorNoVetor(a);
		
	}
	
	@Test(expected = Exception.class)
	public final void testMenorNoVetor2() throws Exception {

		int[] a = {};
		
		aula04_12102017.OperacoesSobreUmVetor.menorNoVetor(a);
		
	}
	
	@Test
	public final void testMenorNoVetor3() throws Exception {
		
		int[] a = {1,2,3};
		
		int expResult = 1;
		int result = aula04_12102017.OperacoesSobreUmVetor.menorNoVetor(a);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public final void testSomatorioElementosVetor1() {

		int[] a = new int[] {};
		
		int expResult = 0;
		int result = aula04_12102017.OperacoesSobreUmVetor.somatorioElementosVetor(a);
		
		assertEquals(expResult, result);
		
	}
	
	@Test
	public final void testSomatorioElementosVetor2() {

		int[] a = {};
		
		int expResult = 0;
		int result = aula04_12102017.OperacoesSobreUmVetor.somatorioElementosVetor(a);
		
		assertEquals(expResult, result);
		
	}
	
	@Test
	public final void testSomatorioElementosVetor3() {
		
		int[] a = {1,2,3};
		
		int expResult = 6;
		int result = aula04_12102017.OperacoesSobreUmVetor.somatorioElementosVetor(a);
		
		assertEquals(expResult, result);
	}

	@Test
	public final void testSomatorioParesVetor1() {

		int[] a = new int[] {};
		
		int expResult = 0;
		int result = aula04_12102017.OperacoesSobreUmVetor.somatorioElementosVetor(a);
		
		assertEquals(expResult, result);
		
	}
	
	@Test
	public final void testSomatorioParesVetor2() {

		int[] a = {};
		
		int expResult = 0;
		int result = aula04_12102017.OperacoesSobreUmVetor.somatorioElementosVetor(a);
		
		assertEquals(expResult, result);
		
	}
	
	@Test
	public final void testSomatorioParesVetor3() {
		
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		
		int expResult = 30;
		int result = aula04_12102017.OperacoesSobreUmVetor.somatorioParesVetor(a);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public final void testSomatorioMultiplosDeUmNumero1() {
		
		int[] a = {1,-2,3,4,5,6,7,8,9,10};
		int num = 2;
		
		int expResult = 26;
		int result = aula04_12102017.OperacoesSobreUmVetor.somatorioMultiplosDeUmNumero(a, num);
		
		assertEquals(expResult, result);
	}

	@Test(expected = Exception.class)
	public final void testSomatorioMultiplosDeUmNumero2() {
		
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		int num = 0;
		
		aula04_12102017.OperacoesSobreUmVetor.somatorioMultiplosDeUmNumero(a, num);
		
	}
	
	@Test
	public final void testIsEmpty1() {
	
		int[] a = {1,-2,3,4,5,6,7,8,9,10};
		
		boolean result = aula04_12102017.OperacoesSobreUmVetor.isEmpty(a);
		
		assertFalse(result);
		
	}

	@Test
	public final void testIsEmpty2() {
	
		int[] a = {};
		
		boolean result = aula04_12102017.OperacoesSobreUmVetor.isEmpty(a);
		
		assertTrue(result);
		
	}
	
	@Test
	public final void testHasOnlyOneElement1() {
		
		int[] a = {1,2};
		
		boolean result = aula04_12102017.OperacoesSobreUmVetor.hasOnlyOneElement(a);
		
		assertFalse(result);
		
	}

	@Test
	public final void testHasOnlyOneElement2() {
		
		int[] a = {1};
		
		boolean result = aula04_12102017.OperacoesSobreUmVetor.hasOnlyOneElement(a);
		
		assertTrue(result);
		
	}
	
	@Test
	public final void testHasOnlyInts1() {
		
		double[] a = {1,2,3,4,5};
		
		boolean result = aula04_12102017.OperacoesSobreUmVetor.hasOnlyInts(a);
		
		assertTrue(result);
	}
	
	@Test
	public final void testHasOnlyInts2() {
		
		double[] a = {1,2,3.5,4.356,5};
		
		boolean result = aula04_12102017.OperacoesSobreUmVetor.hasOnlyInts(a);
		
		assertFalse(result);
	}
	
	@Test
	public final void testHasDuplicates1() {
		
		int[] a = {1,2,3,4,5};
	
		boolean result = aula04_12102017.OperacoesSobreUmVetor.hasDuplicates(a);
		
		assertFalse(result);
	}

	@Test
	public final void testHasDuplicates2() {
		
		int[] a = {1,2,3,2,5,5};

		boolean result = aula04_12102017.OperacoesSobreUmVetor.hasDuplicates(a);
		
		assertTrue(result);
	}
	
	@Test
	public final void testHasDuplicatesEmptyArray() {
		
		int[] a = {};

		boolean result = aula04_12102017.OperacoesSobreUmVetor.hasDuplicates(a);
		
		assertFalse(result);
	}
}

package aula06_16102017;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaisOperacoesSobreVetoresTest {

	//Testes para verificar se dois vetores são iguais
	@Test
	public void testIsEqualVectorsEquals() {
		
		int[] a = {1,2,3,4};
		int[] b = {1,2,3,4};
		
		boolean result = MaisOperacoesSobreVetores.isEqualVectors(a, b);
		
		assertTrue(result);	
	}
	
	@Test
	public void testIsEqualVectorsNotEquals() {
		
		int[] a = {1,2,3,23};
		int[] b = {1,2,3,4};
		
		boolean result = MaisOperacoesSobreVetores.isEqualVectors(a, b);
		
		assertFalse(result);	
	}
	
	@Test
	public void testIsEqualVectorsEmpty() {
		
		int[] a = {};
		int[] b = {};
		
		boolean result = MaisOperacoesSobreVetores.isEqualVectors(a, b);
		
		assertTrue(result);	
	}

	@Test
	public void testIsEqualVectorsDifferentSize() {
		
		int[] a = {1,2};
		int[] b = {1,2,3};
		
		boolean result = MaisOperacoesSobreVetores.isEqualVectors(a, b);
		
		assertFalse(result);	
	}
	
	// testes ao vetor simétrico
	@Test
	public void testisSimetricVectorsSimetric() {
		
		int[] a = {1,2,3,4,3,2,1};
		
		boolean result = MaisOperacoesSobreVetores.isSimetricVectors(a);
		
		assertTrue(result);
	}
	
	@Test
	public void testisSimetricVectorsNonSimetric() {
		
		int[] a = {1,2,3,4,3,2};
		
		boolean result = MaisOperacoesSobreVetores.isSimetricVectors(a);
		
		assertFalse(result);
	}
	
	@Test
	public void testisSimetricVectorsEmpty() {
		
		int[] a = {};
		
		boolean result = MaisOperacoesSobreVetores.isSimetricVectors(a);
		
		assertTrue(result);
	}
	
	//Testes para encontrar primeiro valor num vetor
	@Test
	public void testEncontrarPrimeiroValorEmpty() {
		
		int[] a = {};
		int num = 10;
		
		int expResult = -1;
		int result = MaisOperacoesSobreVetores.encontrarPrimeiroValor(a, num);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public void testEncontrarPrimeiroValorFinds() {
		
		int[] a = {1,2,3,4,10};
		int num = 10;
		
		int expResult = 4;
		int result = MaisOperacoesSobreVetores.encontrarPrimeiroValor(a, num);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public void testEncontrarPrimeiroValorDoesntFind() {
		
		int[] a = {1,2,3,4,5};
		int num = 10;
		
		int expResult = -1;
		int result = MaisOperacoesSobreVetores.encontrarPrimeiroValor(a, num);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public void testEncontrarPrimeiroValorDuplicate() {
		
		int[] a = {1,2,3,4,5,1,3,5};
		int num = 5;
		
		int expResult = 4;
		int result = MaisOperacoesSobreVetores.encontrarPrimeiroValor(a, num);
		
		assertEquals(expResult, result);
	}
}

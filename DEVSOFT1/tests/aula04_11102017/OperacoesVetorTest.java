package aula04_11102017;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperacoesVetorTest {

	// Testes do método somarVetor
	@Test
	public final void testSomarVetor1() {
		
		int[] vetor = {1,2,3,4};
		int expResult = 10;
		int result = aula04_11102017.OperacoesVetor.somarVetor(vetor);
		
		assertEquals(expResult, result);	
	}

	@Test
	public final void testSomarVetor2() {
		
		int[] vetor = {1,-2,-3,-4, -5};
		int expResult = -13;
		int result = aula04_11102017.OperacoesVetor.somarVetor(vetor);
		
		assertEquals(expResult, result);	
	}
	
	@Test
	public final void testSomarVetor3() {
		
		int[] vetor = new int[] {0,0,0};
		int expResult = 0;
		int result = aula04_11102017.OperacoesVetor.somarVetor(vetor);
		
		assertEquals(expResult, result);	
	}
	
	@Test
	public final void testSomarVetor4() {
		
		int[] vetor = new int[4];
		int expResult = 0;
		int result = aula04_11102017.OperacoesVetor.somarVetor(vetor);
		
		assertEquals(expResult, result);	
	}
	
	@Test
	public final void testSomarVetor5() {
		
		int[] vetor = new int[] {};
		int expResult = 0;
		int result = aula04_11102017.OperacoesVetor.somarVetor(vetor);
		
		assertEquals(expResult, result);	
	}
	// Testes do método mediaVetor
	@Test
	public final void testMediaVetor1() {
		
		int[] vetor = {1,2,3,4};
		double expResult = 2.5;
		double result = aula04_11102017.OperacoesVetor.mediaVetor(vetor);
		
		assertEquals(expResult, result, 0.0001);	
	}

	@Test
	public final void testMediaVetor2() {
		
		int[] vetor = {1,-2,-3,-4, -5};
		double expResult = -13 / 5.0;
		double result = aula04_11102017.OperacoesVetor.mediaVetor(vetor);
		
		assertEquals(expResult, result, 0.0001);		
	}
	
	@Test
	public final void testMediaVetor3() {
		
		int[] vetor = new int[] {0,0,0};
		double expResult = 0;
		double result = aula04_11102017.OperacoesVetor.mediaVetor(vetor);
		
		assertEquals(expResult, result, 0.0001);	
	}
	
	@Test
	public final void testMediaVetor4() {
		
		int[] vetor = new int[4];
		double expResult = 0;
		double result = aula04_11102017.OperacoesVetor.mediaVetor(vetor);
		
		assertEquals(expResult, result, 0.0001);	
	}
	
	@Test
	public final void testMediaVetor5() {
		
		int[] vetor = new int[] {};
		double expResult = Double.NaN; //Não lança exceção!! Tem que ver com a norma IEEE 754 (floating point math)
		double result = aula04_11102017.OperacoesVetor.mediaVetor(vetor);
		
		assertEquals(expResult, result, 0.0001);	
	}
}

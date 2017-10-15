package aula05_13102017;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExerciciosVetorTest {
	
	//Declarações de arrays "vazios" comuns à maioria dos testes
	int[] a = {};
	int[] b = new int[] {};
	int[] c = new int[4];

	@Test
	public final void testMediaVetorA() {
		
		double expResult = Double.NaN;
		double result = aula05_13102017.ExerciciosVetor.mediaVetor(a);
		
		assertEquals(expResult, result, 0.0001);
	}
	
	@Test
	public final void testMediaVetorB() {
		
		double expResult = Double.NaN;
		double result = aula05_13102017.ExerciciosVetor.mediaVetor(b);
		
		assertEquals(expResult, result, 0.0001);
	}
	
	@Test
	public final void testMediaVetorC() {
		
		double expResult = 0; //declarar como new int[4] inicializa os 4 elementos a zero!!!
		double result = aula05_13102017.ExerciciosVetor.mediaVetor(c);
		
		assertEquals(expResult, result, 0.0001);
	}
	
	@Test
	public final void testMediaVetorD() {
		
		int[] d = {1,2,3,4,5};
		
		double expResult = 3;
		double result = aula05_13102017.ExerciciosVetor.mediaVetor(d);
		
		assertEquals(expResult, result, 0.0001);
	}
	
	@Test
	public final void testDesvioPadraoVetorA() {
		
		double expResult = Double.NaN;
		double result = aula05_13102017.ExerciciosVetor.desvioPadraoVetor(a);
		
		assertEquals(expResult, result, 0.0001);
	}

	@Test
	public final void testDesvioPadraoVetorB() {
		
		double expResult = Double.NaN;
		double result = aula05_13102017.ExerciciosVetor.desvioPadraoVetor(b);
		
		assertEquals(expResult, result, 0.0001);
	}
	
	@Test
	public final void testDesvioPadraoVetorC() {
		
		double expResult = 0;
		double result = aula05_13102017.ExerciciosVetor.desvioPadraoVetor(c);
		
		assertEquals(expResult, result, 0.0001);
	}
	
	@Test
	public final void testDesvioPadraoVetorD() {
		
		int[] d = {1,2,3,4};
		
		double expResult = 1.11803;
		double result = aula05_13102017.ExerciciosVetor.desvioPadraoVetor(d);
		
		assertEquals(expResult, result, 0.0001);
	}

	@Test
	public final void testDesvioPadraoVetorE() {
		
		int[] d = {1};
		
		double expResult = 0;
		double result = aula05_13102017.ExerciciosVetor.desvioPadraoVetor(d);
		
		assertEquals(expResult, result, 0.0001);
	}
	
	@Test
	public final void testInverteOrdem1() {
		
		int[] a = {1,2,3,4};
		
		int[] expResult = {4,3,2,1};
		int[] result = aula05_13102017.ExerciciosVetor.inverteOrdem(a);
		
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public final void testInverteOrdem2() {
		
		int[] a = {1,-2};
		
		int[] expResult = {-2,1};
		int[] result = aula05_13102017.ExerciciosVetor.inverteOrdem(a);
		
		assertArrayEquals(expResult, result);
	}

	@Test
	public final void testOrdenarVetorBubbleSort1() {
		
		int[] a = {-3, -10, 0, 1, 7, 2, -11};
		int[] expResult = {-11, -10, -3, 0, 1, 2, 7};
		
		int[] result = aula05_13102017.ExerciciosVetor.OrdenarVetorBubbleSort(a);
		
		assertArrayEquals(expResult, result);
	}

	@Test
	public final void testOrdenarVetorBubbleSort2() {
		
		int[] a = {-3};
		int[] expResult = {-3};
		
		int[] result = aula05_13102017.ExerciciosVetor.OrdenarVetorBubbleSort(a);
		
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public final void testOrdenarVetorBubbleSort3() {
		
		int[] a = {-3,-10};
		int[] expResult = {-10,-3};
		
		int[] result = aula05_13102017.ExerciciosVetor.OrdenarVetorBubbleSort(a);
		
		assertArrayEquals(expResult, result);
	}
	
	@Test
	public final void testOrdenarVetorBubbleSortA() {
		
		int[] expResult = {};
		int[] result = aula05_13102017.ExerciciosVetor.OrdenarVetorBubbleSort(a);
		
		assertArrayEquals(expResult, result);
	}
}
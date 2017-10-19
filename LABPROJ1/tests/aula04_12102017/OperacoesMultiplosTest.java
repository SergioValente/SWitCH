package aula04_12102017;

import static org.junit.Assert.*;


import org.junit.Before;

import org.junit.Test;

import java.util.ArrayList;

public class OperacoesMultiplosTest {
	
	private int[] a = {};
	//private int[] b;
	//private int[] c;
	private int[] d;
	ArrayList<Integer> expResult = new ArrayList<>();
	ArrayList<Integer> result = new ArrayList<>();
	
	@Before
	public final void create() {
		
		//b = new int[] {};
		//c = new int[4];
		d = new int[] {1,2,3,4,5,6,7,8,9,10};
	}
	
	@Test
	public final void testMultiplosDeTres1() {
		
		expResult.add(3);
		expResult.add(6);
		expResult.add(9);
		
		result = aula04_12102017.OperacoesMultiplos.multiplosDeTres(d);
		
		assertEquals(expResult, result);
	}

	@Test
	public final void testMultiplosDeTres2() {
		
		result = aula04_12102017.OperacoesMultiplos.multiplosDeTres(a);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public final void testMultiplosDeUmNumero() {
		
		int num = 5;
		result = aula04_12102017.OperacoesMultiplos.multiplosDeUmNumero(d, num);
		
		expResult.add(5);
		expResult.add(10);
		
		assertEquals(expResult, result);
		
	}

	@Test
	public final void testMultiplosDeTresECinco() {
		
		result = aula04_12102017.OperacoesMultiplos.multiplosDeTresECinco(d);
		
		assertEquals(expResult, result);
	}

	@Test
	public final void testMultiplosDeDoisInteiros() {
	
		int num1 = 3;
		int num2 = 5;
		
		result = aula04_12102017.OperacoesMultiplos.multiplosDeDoisInteiros(a, num1, num2);
		
		assertEquals(expResult, result);
	}

	@Test
	public final void testMultiplosDeDoisInteirosOrdemDecrescente() {
		
		int num1 = 3;
		int num2 = 5;
		
		result = aula04_12102017.OperacoesMultiplos.multiplosDeDoisInteirosOrdemDecrescente(a, num1, num2);
		
		assertEquals(expResult, result);
		
	}

}

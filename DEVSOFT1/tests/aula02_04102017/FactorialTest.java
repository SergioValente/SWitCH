package aula02_04102017;

import static org.junit.Assert.*;

import org.junit.Test;

import aula02_04102017.Factorial;

public class FactorialTest {

	@Test
	public void testFactorial() {
		
		assertEquals(1, Factorial.factorial(1) );
		//assertEquals(0, Factorial.factorial(0) ); throws exception 
		assertEquals(2432902008176640000L, Factorial.factorial(20) ); //ATENÇÃO AO L NO FINAL PARA LONG!!!!!
		assertEquals(60, Factorial.factorial(60) );
		
		
		
	}

}

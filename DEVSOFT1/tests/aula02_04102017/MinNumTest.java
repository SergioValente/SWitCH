package aula02_04102017;

import static org.junit.Assert.*;

import org.junit.Test;

import aula02_04102017.MinNum;

public class MinNumTest {

	@Test
	public void testMin() {
		
		assertEquals(2, MinNum.min(2,3));
		assertEquals(2, MinNum.min(3,2));
		assertEquals(2, MinNum.min(2,2));
		assertEquals(-1, MinNum.min(-1,0));
		assertEquals(0,  MinNum.min(0,0));
		assertEquals(Integer.MIN_VALUE, MinNum.min(Integer.MAX_VALUE,Integer.MIN_VALUE));

	}

}

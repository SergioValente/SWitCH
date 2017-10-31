package aula09_31102017;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class PontoTest {

	@Test
	public void testGetPontosSuccess() {
		
		char[][] matrix = {{'a','b','c','d'},{'d','t','g','c'},{'r','d','s','f'},{'a','d','h','j'}};
		char c = 'c';
		ArrayList<Ponto> expResult = new ArrayList<>();
		expResult.add(new Ponto(0,2));
		expResult.add(new Ponto(1,3));
		
		ArrayList<Ponto> result = (ArrayList<Ponto>) Utils.getPontos(matrix, c);
		
		assertEquals(expResult, result);
	}

	@Test
	public void testGetPontosEmptyMatrix() {
		
		char[][] matrix = {{},{},{},{}};
		char c = 'c';
		ArrayList<Ponto> expResult = new ArrayList<>();
		
		ArrayList<Ponto> result = (ArrayList<Ponto>) Utils.getPontos(matrix, c);
		
		assertEquals(expResult, result);
	}
}

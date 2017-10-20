package aula06_18102017;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class TestSudokuSolutionTest {

	//Testes para verificação se matriz é nove por nove
	@Test
	public void testisMatrizNovePorNoveTrue() {
		
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
				  	  {7,4,9,6,3,1,5,2,8},
				  	  {5,1,3,8,4,2,9,6,7},
				  	  {3,7,8,9,2,6,1,5,4},
				  	  {1,2,4,5,8,7,6,9,3},
				  	  {6,9,5,4,1,3,8,7,2},
				  	  {4,5,1,2,6,8,7,3,9},
				  	  {2,8,6,3,7,9,4,1,5},
				  	  {9,3,7,1,5,4,2,8,6}};
	boolean result = TestSudokuSolution.isMatrizNovePorNove(a);
	
	assertTrue(result);	
	}

	@Test
	public  void testisMatrizNovePorNoveFalse() {
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
				  	  {7,4,9,6,3,1,5,2,8},
				  	  {5,1,3,8,4,2,9,6,7},
				  	  {3,7,8,9,2,6,1,5,4}, 
				  	  {1,2,4,5,8,7,6,9,3},
				  	  {4,5,1,2,6,8,7,3,9},
				  	  {2,8,6,3,7,9,4,1,5},
				  	  {9,3,7,1,5,4,2,8,6}};
	boolean result = TestSudokuSolution.isMatrizNovePorNove(a);
	
	assertFalse(result);
	}

	@Test
	public void testisMatrizNovePorNoveLinesDifferentSize() {
		
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
					  {7,4,9,6,3,1,5,2,8},
					  {5,1,3,4,2,9,6,7},
					  {3,7,8,9,4,6,1,5,4}, 
					  {1,2,4,5,8,7,6,9,3},
					  {6,9,5,4,1,3,8,7,2},
					  {4,5,1,2,6,8,7,3,9},
					  {2,8,6,3,7,9,4,1,5},
					  {9,3,7,1,5,4,2,8,6}};
		boolean result = TestSudokuSolution.isMatrizNovePorNove(a);
		
		assertFalse(result);
	}
	
	@Test
	public void testisMatrizNovePorNoveEmptyMatrix() {
		
		int [][] a = {{},{},{}};
		boolean result = TestSudokuSolution.isMatrizNovePorNove(a);
		
		assertFalse(result);
	}
	
	//Testes para verificar se matriz tem os números todos entre 1 e 9
	@Test
	public void testmatrizTemNumerosTodosValidosTrue() {
		
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
				  	  {7,4,9,6,3,1,5,2,8},
				  	  {5,1,3,8,4,2,9,6,7},
				  	  {3,7,8,9,2,6,1,5,4},
				  	  {1,2,4,5,8,7,6,9,3},
				  	  {6,9,5,4,1,3,8,7,2},
				  	  {4,5,1,2,6,8,7,3,9},
				  	  {2,8,6,3,7,9,4,1,5},
				  	  {9,3,7,1,5,4,2,8,6}};
	boolean result = TestSudokuSolution.matrizTemNumerosTodosValidos(a);
	
	assertTrue(result);	
	}

	@Test
	public  void testmatrizTemNumerosTodosValidosnFalse() {
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
				  	  {7,4,9,6,3,1,5,2,8},
				  	  {5,1,3,8,4,2,9,6,7},
				  	  {3,7,8,9,2,6,1,5,4}, 
				  	  {1,2,4,5,12,7,6,9,3}, //12 deveria ser 8
				  	  {6,9,5,4,1,3,8,7,2},
				  	  {4,5,1,2,6,8,7,3,9},
				  	  {2,8,6,3,7,9,4,1,5},
				  	  {9,3,7,1,5,4,2,8,6}};
	boolean result = TestSudokuSolution.matrizTemNumerosTodosValidos(a);
	
	assertFalse(result);
	}
	
	@Test
	public  void testmatrizTemNumerosTodosValidosNumerosInvalidos() {
	
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
			  	  	  {7,4,9,6,3,1,5,2,8},
			  	  	  {5,1,3,8,4,2,9,6,7},
			  	  	  {3,7,8,9,2,6,1,5,4},
			  	  	  {1,2,4,5,8,7,6,9,3},
			  	  	  {6,9,5,4,1,3,8,7,2},
			  	  	  {4,5,1,2,6,8,12,3,9}, // linha com o número 12
			  	  	  {2,8,6,3,7,9,4,1,5},
			  	  	  {9,3,7,1,5,4,2,8,6}};
		boolean result = TestSudokuSolution.matrizTemNumerosTodosValidos(a);

		assertFalse(result);	
	}
	
	//Testes para verificar todas as linhas estão conforme as regras do jogo
	@Test
	public void testlinhasCorretasTrue() {
		
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
				  	  {7,4,9,6,3,1,5,2,8},
				  	  {5,1,3,8,4,2,9,6,7},
				  	  {3,7,8,9,2,6,1,5,4},
				  	  {1,2,4,5,8,7,6,9,3},
				  	  {6,9,5,4,1,3,8,7,2},
				  	  {4,5,1,2,6,8,7,3,9},
				  	  {2,8,6,3,7,9,4,1,5},
				  	  {9,3,7,1,5,4,2,8,6}};
	boolean result = TestSudokuSolution.linhasCorretas(a);
	
	assertTrue(result);	
	}

	@Test
	public  void testlinhasCorretasFalse() {
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
				  	  {7,4,9,6,3,1,5,2,8},
				  	  {5,1,3,8,4,2,9,6,7},
				  	  {3,7,8,9,4,6,1,5,4}, //falso nesta linha, o 1º 4 deve ser um 2
				  	  {1,2,4,5,8,7,6,9,3},
				  	  {6,9,5,4,1,3,8,7,2},
				  	  {4,5,1,2,6,8,7,3,9},
				  	  {2,8,6,3,7,9,4,1,5},
				  	  {9,3,7,1,5,4,2,8,6}};
	boolean result = TestSudokuSolution.linhasCorretas(a);
	
	assertFalse(result);
	}
	
	// Testes para verificar a conversão de cada matriz interna para um vetor
	@Test
	public void testconverteMatrizInternaParaVetorTrue() {
		
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
				  	  {7,4,9,6,3,1,5,2,8},
				  	  {5,1,3,8,4,2,9,6,7},
				  	  {3,7,8,9,2,6,1,5,4},
				  	  {1,2,4,5,8,7,6,9,3},
				  	  {6,9,5,4,1,3,8,7,2},
				  	  {4,5,1,2,6,8,7,3,9},
				  	  {2,8,6,3,7,9,4,1,5},
				  	  {9,3,7,1,5,4,2,8,6}};
		int i = 0;
		int j = 0;
		int[] expResult = {8,6,2,7,4,9,5,1,3};
		int[] result = TestSudokuSolution.converteMatrizInternaParaVetor(a, i, j);
	
	assertArrayEquals(expResult, result);	
	}

	@Test
	public void testconverteMatrizInternaParaVetorFalse() {
		
		int [][] a = {{8,6,2,7,9,5,3,4,1}, 
				  	  {7,4,9,6,3,1,5,2,8},
				  	  {5,1,3,8,4,2,9,6,7},
				  	  {3,7,8,9,2,6,1,5,4},
				  	  {1,2,4,5,8,7,6,9,3},
				  	  {6,9,5,4,1,3,8,7,2},
				  	  {4,5,1,2,6,8,7,3,9},
				  	  {2,8,6,3,7,9,4,1,5},
				  	  {9,3,7,1,5,4,2,8,6}};
		int i = 0;
		int j = 3;
		int[] expResult = {8,6,2,7,4,9,5,1,3};
		int[] result = TestSudokuSolution.converteMatrizInternaParaVetor(a, i, j);
	
		assertThat(expResult, not(equalTo(result))); //Temos que usar esta forma do hamcrest.
		//assertNotEquals(expResult, result); //NÃO FUNCIONA!!
	}
}

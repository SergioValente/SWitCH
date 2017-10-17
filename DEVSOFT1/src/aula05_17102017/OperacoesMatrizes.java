package aula05_17102017;

import aula04_12102017.OperacoesSobreUmVetor;
import aula06_16102017.OperacoesSobreMatrizes;

public class OperacoesMatrizes {

	public static int[] somaCadaLinhaMatriz(int[][] a) {
		
		int soma;
		int[] somatorio = new int[a.length];
		
		for (int i = 0; i < a.length; i++) {
			soma = 0;
			for (int j = 0; j < a[i].length; j++) {
				soma += a[i][j];
			}
			somatorio[i] = soma;
		}
		return somatorio;	
	}
	
	public static boolean existsInMatrix(int[][] a, int[] b) {
		
		boolean found;
		
		if(b.length == 0) return false;
		
		for (int elem: b) {
			found = false;
			
			loopCorrerMatriz:
			for(int i = 0; i < a.length; i++ ) {
				for (int j = 0; j < a[i].length; j++) {
					if (elem == a[i][j]) {
						found = true;
						break loopCorrerMatriz;
					}		
				}
			}
			if (!found) return false;
		}	
		
		return true;
	}
	
	/**
	 * Método para calcular se uma dada solução do Sudoku é válida
	 * @param a matriz com a solução
	 * @return boolean true (válida) ou false (existem números duplicados)
	 */
	public static boolean isValidSudokuSolution (int[][] a) {
		
		boolean duplicadosLinha = false;
		boolean duplicadosColuna = false;
		int[][] transposta = OperacoesSobreMatrizes.matrizTransposta(a);
		
		// Verificação dos duplicados nas linhas e nas colunas
		for (int i = 0; i < a.length; i ++) {
	
			if(a[i].length != a.length) return false;
			
			duplicadosLinha = OperacoesSobreUmVetor.hasDuplicates(a[i]);
			duplicadosColuna = OperacoesSobreUmVetor.hasDuplicates(transposta[i]);
			if(duplicadosLinha || duplicadosColuna) return false;
		}
		
		//verificação dos duplicados nas matrizes internas
		for (int i = 0; i < a.length; i += 3) {
			for (int j = 0; j < a.length; j += 3) {
				if (OperacoesSobreUmVetor.hasDuplicates(innerMatrixToVector(a, i, j))) return false;
			}
		}
		return true;	
	}
	
	/**
	 * Método para pegar numa matriz interna do jogo Sudoku e passar para um vetor	
	 * @param a matriz completa
	 * @param x índice da linha
	 * @param y índice da coluna
	 * @return matriz interna na forma de um vetor
	 */
	public static int[] innerMatrixToVector(int[][] a, int x, int y) {

		int indexVector = 0;
		int[] matrixToVector = new int[9];

		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				matrixToVector[indexVector++] = a[i][j];
			}
		}
		return matrixToVector;
	}
	
}

package aula06_18102017;

import aula04_12102017.OperacoesSobreUmVetor;
import aula06_16102017.OperacoesSobreMatrizes;

public class TestSudokuSolution {

	/** Método para calcular se uma dada solução do Sudoku é válida
	 * @param a matriz com a solução
	 * @return boolean true (válida) ou false (existem números duplicados)
	 */
	public static boolean isValidSudokuSolution (int[][] jogo) {
		
		if(!isMatrizNovePorNove(jogo)) return false;
		if (!linhasCorretas(jogo)) return false;
		if(!colunasCorretas(jogo)) return false;
		if(!matrizesInternasCorretas(jogo)) return false;
		
		return true;	
	}
	
	/**
	 * Método para pegar numa matriz interna do jogo Sudoku e passar para um vetor	
	 * @param a matriz completa
	 * @param x índice da linha
	 * @param y índice da coluna
	 * @return matriz interna na forma de um vetor
	 */
	private static int[] converteMatrizInternaParaVetor(int[][] jogo, int x, int y) {

		int indexVector = 0;
		int[] matrixToVector = new int[9];

		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				matrixToVector[indexVector++] = jogo[i][j];
			}
		}
		return matrixToVector;
	}
	
	/**
	 * Método para verificar se as linhas da matriz estão corretas
	 * @param jogo matriz do jogo
	 * @return true se todas as linhas estão corretas, false se pelo menos uma delas falha
	 */
	private static boolean linhasCorretas(int[][] jogo) {
		
		boolean temDuplicadosLinha = false;
		
		for (int i = 0; i < jogo.length; i ++) {
			
			//se matriz não tem o número correto de linhas, retorna false
			if(jogo[i].length != jogo.length) return false;  
			
			temDuplicadosLinha = OperacoesSobreUmVetor.hasDuplicates(jogo[i]);
			if (temDuplicadosLinha) return false;
		}
		return true;
	}
	
	/**
	 * Método para verificar se colunas da matriz estão corretas
	 * @param jogo matriz do jogo
	 * @return true se todas as colunas estão corretas, false se pelo menos uma delas falha
	 */
	private static boolean colunasCorretas(int[][] jogo) {
		
		boolean temDuplicadosColuna = false;
		int[][] transposta = OperacoesSobreMatrizes.matrizTransposta(jogo);
		
		for (int i = 0; i < jogo.length; i ++) {
			
			//se matriz não tem o número correto de colunas, retorna false
			if(jogo[i].length != jogo.length) return false;
			
			temDuplicadosColuna = OperacoesSobreUmVetor.hasDuplicates(transposta[i]);
			if (temDuplicadosColuna) return false;
		}
		return true;
	}
	
	/**
	 * Método que verifica se as matrizes internas 3X3 estão corretas
	 * @param jogo matriz completa do jogo
	 * @return true se as matrizes internas estão corretas, false se não estão corretas
	 */
	private static boolean matrizesInternasCorretas(int[][] jogo) {
		
		int[] vetorMatrizInterna;
		
		for (int i = 0; i < jogo.length; i += 3) {
			for (int j = 0; j < jogo.length; j += 3) {
				vetorMatrizInterna = converteMatrizInternaParaVetor(jogo, i, j);
				if (OperacoesSobreUmVetor.hasDuplicates(vetorMatrizInterna)) return false;
			}
		}
		return true;
	}
	
	/**
	 * Método que verifica se matriz é nove por nove
	 * @param jogo matriz a verificar
	 * @return true se é matriz de nove por nove ou false se matriz não é de nove por nove
	 */
	private static boolean isMatrizNovePorNove(int[][] jogo) {
		
		if(jogo.length != 9 || jogo[0].length != 9) return false;
		
		return true;
	}	
}


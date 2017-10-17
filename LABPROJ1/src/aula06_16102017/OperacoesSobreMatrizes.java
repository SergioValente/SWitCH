package aula06_16102017;

public class OperacoesSobreMatrizes {

	public static boolean isEqualMatrices(int[][] a, int[][] b) {
		
		if ((a.length != b.length) || (a[0].length != b[0].length)) return false;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] != b[i][j]) return false; 
			}
		}
		return true;
	}
	
	public static boolean isSimetricaDiagonalPrincipal(int[][] a) {
		
		if (a.length != a[0].length) return false;
		
		for (int i = 0; i < a.length; i++) {
			
			for (int j = i + 1; j < a.length; j++) { // j = i + 1 para percorrer só a parte de cima da matriz!!!!
				
				if(a[i][j] != a[j][i]) return false;
			}
		}	
		return true;
	}
	
	public static boolean isSimetricaDiagonalSecundaria(int[][] a) {
		
		if (a.length != a[0].length) return false;
		
		for (int i = 0; i < a.length - 1; i++) {
			
			for (int j = 0; j < a.length - 1 - i; j++) { // j < a.length - 1 - i para só percorrer a parte de cima!!!
				
				if(a[i][j] != a[a.length - 1 - j][a.length - 1 - i]) return false;
			}
		}	
		return true;
	}
	
	public static int[][] matrizTransposta(int[][] a) {
		
		int[][] transposed = new int[a[0].length][a.length];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				transposed[j][i] = a[i][j];
			}
		}
		return transposed;
	}
	
	public static boolean isSimetricaUsandoTransposta(int[][] a) {
		
		return isEqualMatrices(a, matrizTransposta(a));
	}
}

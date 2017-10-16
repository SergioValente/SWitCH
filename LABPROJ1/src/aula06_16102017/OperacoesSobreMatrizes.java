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
				
				if(i == j) continue;
				if(a[i][j] != a[j][i]) return false;
			}
		}	
		return true;
	}
}

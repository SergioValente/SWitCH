package aula06_16102017;

public class MaisOperacoesSobreVetores {

	public static boolean isEqualVectors(int[] a, int[] b) {
		
		while (a.length == b.length) {
			for (int i = 0; i < a.length; i++) {
				if (a[i] != b[i]) return false;
			}
			return true;
		}
		return false;
	}
	
	public static boolean isSimetricVectors(int[] a) {
		
		for (int i = 0; i < a.length / 2; i++) {
			
			if (a[i] != a[a.length - 1 -i]) return false;
		}
		return true;
	}
	
	public static int encontrarPrimeiroValor(int[] a, int num) {
		
		for(int i = 0; i < a.length; i++) {
			if (a[i] == num) return i;
		}
		return -1;
	}
}

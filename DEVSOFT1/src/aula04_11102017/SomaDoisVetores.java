package aula04_11102017;

public class SomaDoisVetores {

	public static int[] somaDoisVetores(int[] a, int[] b) {
		
		int[] soma = new int [Math.max(a.length, b.length)];
		
			for (int i = 0; i < soma.length; i++) {
				soma[i] = a[i] + b[i];
			}
		return soma;
	}
}

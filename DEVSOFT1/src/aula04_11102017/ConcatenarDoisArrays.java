package aula04_11102017;

public class ConcatenarDoisArrays {

	public static int[] concatenarDoisArrays(int[] a, int[] b) {
		
		int[] c = new int [a.length + b.length];
		
		for (int i = 0; i < c.length; i++) {
			
			if (i < a.length) {
				c[i] = a[i];
			}
			else {
				c[i] = b[i - a.length];
			}
		}
		
		return c;
	} 
		
}

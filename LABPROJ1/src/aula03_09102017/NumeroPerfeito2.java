package aula03_09102017;

public class NumeroPerfeito2 {

	public static void main(String[] args) {
		
		for (int i = 0; i < 1000; i++) {
			if (isNumPerfeito(i)) {
				System.out.println(i);
			}
		}
		
	}
	public static boolean isNumPerfeito(long num) {
		
		long alg;
		long aux, soma = 0;
		
		if (num >=0) {
			aux = num;
			while (aux > 0) {
				alg = (aux % 10);
				soma += alg*alg*alg;	
				aux = aux / 10;
			}
			return num == soma;
		}
		else return false;
		
		
	}
}

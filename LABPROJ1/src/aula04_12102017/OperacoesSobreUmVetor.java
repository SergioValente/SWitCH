package aula04_12102017;

/**
 * Exercícios sobre vectores

I. Dado um vector de números pretende-se que elabore uma função que retorne:
a) o número de elementos num vector
b) o maior elemento de um vector
c) o menor elemento de um vector
d) o somatório de todos os números
e) o somatório de todos os números pares
f) o somatório de todos os múltiplos de um número
g) True caso o vector esteja vazio, False em caso contrário
h) True caso o vector contenha apenas um elemento, False em caso contrário
i) True se o vector tiver apenas elementos inteiros, False em caso contrário
j) True se o vector tiver elementos duplicados, False em caso contrário

 * @author sergiovalente
 *
 */
public class OperacoesSobreUmVetor {

	public static int tamanhoVetor(int[] a) {
		
		return a.length;
	}
	
	public static int maiorNoVetor(int[] a) throws Exception{
		
		int maior = Integer.MIN_VALUE;
		
		if (isEmpty(a)) throw new Exception();
		
		for (int elem: a) {
			
			if (elem > maior) maior = elem;
		}
		
		return maior;
	}
	
	public static int menorNoVetor(int[] a) throws Exception {
		
		int menor = Integer.MAX_VALUE;
		
		if(isEmpty(a)) throw new Exception();
		
		for (int elem: a) {
			
			if (elem < menor) menor = elem;
		}
		
		return menor;
	}
	
	public static int somatorioElementosVetor(int[] a) {
		
		int soma = 0;
		
		for (int elem: a) {
			
			soma += elem;
		}
		
		return soma;
	}
	
	public static int somatorioParesVetor(int[] a) {
		
		int soma = 0;
		
		for (int elem: a) {
			
			if (elem % 2 == 0) soma += elem;
		}
		
		return soma;
	}
	
	public static int somatorioMultiplosDeUmNumero(int[] a, int num) {
		
		int soma = 0;
		
		for (int elem: a) {
			
			if (elem % num == 0) soma += elem;
		}
		
		return soma;
	}
	
	public static boolean isEmpty(int[] a) {
		
		return (a.length == 0);
	}
	
	public static boolean hasOnlyOneElement(int[] a) {
		
		return (a.length == 1);
	}
	
	public static boolean hasOnlyInts(double[] a) {
		
		for (double elem: a) {
			
			if (elem != (int) elem) return false;
		}
		return true;
	}
	
	public static boolean hasDuplicates(int[] a) {
		
		for (int i = 0; i < (a.length - 1); i++) {
		
			for (int j = (i + 1); j < a.length; j++) {
			
				//if (i == j) continue;
				if (a[i] == a[j]) return true; 
			}		
		}
		return false;
	}
}

package aula05_13102017;

/**
 * Exercícios adicionais Dado um vetor de inteiros:
 * 
 * 1. Calcular a média dos seus elementos; 
 * 2. Calcular o desvio-padrão de cada elemento; 
 * 3. Inverter a ordem dos seus elementos;
 * 4. Ordenar o vetor pelo método das trocas diretas (bubble sort);
 * 
 * @author sergiovalente
 *
 */
public class ExerciciosVetor {
	
	public static double mediaVetor(int[] a) {

		double soma = 0;
		
		for (int elem: a)
			soma += elem;
		
		return (soma / a.length);
	}

	public static double desvioPadraoVetor(int[] a) {
		
		double media = mediaVetor(a);
		double soma = 0;
		
		if (a.length == 0) return Double.NaN;
		if (a.length == 1) return 0;

		for (int elem : a) {
			soma += Math.pow((elem - media), 2);
		}

		return Math.sqrt(soma / (a.length)); // ver bem a fórmula do desvio, pode ser n ou n-1!!!
	}

	public static int[] inverteOrdem(int[] a) {

		int[] reverse = new int[a.length];

		for (int i = 0; i < a.length; i++)
			reverse[a.length - i - 1] = a[i];

		return reverse;
	}

	public static int[] OrdenarVetorBubbleSort(int[] a) {
		
		boolean hasTroca = true;
		int aux;
		int maxIndexVetor = a.length;
		
		while(hasTroca) {
			
			hasTroca = false;
			maxIndexVetor--; //otimizar algoritmo, assim não precisa de pesquisar até ao fim do vetor.
			
			for (int i = 0; i < maxIndexVetor; i++) {
				
				if (a[i] > a[i + 1]) {
					aux = a[i];
					a[i] = a[i + 1];
					a[i + 1] = aux;
					hasTroca = true;
				}
			}
		}
		return a;
	}
}

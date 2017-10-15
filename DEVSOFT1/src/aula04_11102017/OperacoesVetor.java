package aula04_11102017;

public class OperacoesVetor {

	int[] vetor = { 1, 2, 3, 4 };

	public static int somarVetor(int[] vetor) {

		int soma = 0;

		for (int elem : vetor) {
			soma += elem;
		}

		return soma;
	}

	public static double mediaVetor(int[] vetor) {

		double soma = 0;
		double media = 0;

		for (int elem : vetor) {
			soma += elem;
		}
		
		media = soma / vetor.length;
		return media;
	}

}

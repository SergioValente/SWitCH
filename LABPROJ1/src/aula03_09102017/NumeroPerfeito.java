package aula03_09102017;

import java.util.Scanner;

public class NumeroPerfeito {

	public static void main(String[] args) {
		
		
		calcularNumPerfeito();
	}

	public static void calcularNumPerfeito() {
		
		Scanner input = new Scanner(System.in);
		
		int numeroAux, soma = 0;
		
		//input number 
		System.out.println("Digite o número para verificar: ");
		int numero = input.nextInt();
		numeroAux = numero;
		
		//determine size of array
		int numeroAlgarismos = (int) Math.log10(numero) + 1;
		int[] algarismos = new int[numeroAlgarismos];
		
		//populate array with individual digits
		for (int i = 0; i < numeroAlgarismos; i++) {
			algarismos[i] = numeroAux % 10;
			numeroAux /= 10;
		}
		
		//calculate sum of digits ^ 3
		for (int elem: algarismos) {
			soma += Math.pow(elem, 3);
		}
		
		//ascertain if it's a perfect number
		System.out.printf("A soma do cubo dos algarismos é igual a %d%n", soma);
		if (soma == numero) {
			System.out.printf("O número %d é um número perfeito!", numero);
		}
		else {
			System.out.printf("O número %d NÃO é um número perfeito!", numero);
		}
	}
}

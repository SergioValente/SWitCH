package aula02_06102017;

import java.util.Scanner;

public class Palindromo {

	public static void main(String[] args) {
		
		palindromo();

	}

	public static void palindromo() {
		
		Scanner input = new Scanner(System.in);
		boolean isPalindromo = true;
		int indice = 0;
		
		System.out.print("Digite o número inteiro para verificação de palíndromo: ");
		
		String num = Long.toString(input.nextLong());
		
		while(isPalindromo && (indice <= num.length() / 2)) {
			
			if (num.charAt(indice) != num.charAt((num.length() - 1) - indice)) {
				System.out.printf("O número %s não é um palíndromo!%n", num);
				isPalindromo = false;	
			}
			indice++;
		}
		if (isPalindromo) {
			System.out.printf("O número %s é um palíndromo!!%n", num);
		}
		input.close();
	}
}

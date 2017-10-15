package aula02_06102017;

import java.util.Scanner;

public class Fibonacci {
	
	public static void main(String[] args) {
		
		fibonacci();
		
	}
	
	public static void fibonacci() {
		
            try (Scanner input = new Scanner(System.in)) {
                int ordem;
                
                System.out.print("Digite a ordem (número inteiro) para calcular o número de Fibonacci: ");
                
                ordem = input.nextInt();
                
                int[] fibonacci = new int[ordem];
                
                fibonacci[0] = 1;
                fibonacci[1] = 1;
                
                for (int i = 2; i < ordem; i++) {
                    fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
                }
                System.out.print("\nA sequência de Fibonacci de ordem " + ordem + " é: ");
                for(int elem: fibonacci) {
                    System.out.print(elem + ", ");
                }
                
                System.out.printf("%n%nO número de Fibonacci de ordem %d é igual a %d%n", ordem, fibonacci[ordem - 1]);
            }
	}
}

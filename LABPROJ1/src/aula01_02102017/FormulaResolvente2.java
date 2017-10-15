package aula01_02102017;

import java.util.Scanner;

/**
 * Evolução do primeiro programa, com introdução da leitura de números dada pelo user.
 */
public class FormulaResolvente2 {	

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		System.out.print("Introduza o primeiro número: ");
		double a = input.nextDouble();
		System.out.print("Introduza o segundo número: ");
		double b = input.nextDouble();
		System.out.print("Introduza o terceiro número: ");
		double c = input.nextDouble();
		
		calculaFormulaResolvente (a, b, c);
		
		input.close();
		System.out.println("Programa terminado.");

	} //end main
	
	/**
	 * Método para fazer o cálculo da fórmula resolvente das equações de 2ª grau, com respetivas validações 
	 * @param x Valor a
	 * @param y Valor b
	 * @param z Valor c
	 */
	private static void calculaFormulaResolvente(double x, double y, double z) {
		
		if (x == 0) {
			System.out.println("Não é uma equação do segundo grau!");
		}
		else {
			double delta = Math.pow(y, 2) - 4 * x * z;
			if (delta >= 0) {
				System.out.println("Raíz 1: " + ((-y + Math.sqrt(delta))/(2 * x)));
				System.out.println("Raíz 2: " + ((-y - Math.sqrt(delta))/(2 * x)));
			}
			else {
				System.out.println("\nRaízes Imaginárias: " + (-y/2/x + " +/- " + Math.sqrt(-delta)/2/x + "i"));
			}
		}
		
	} //end calculaFormulaResolvente

}

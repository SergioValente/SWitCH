/**
 * Primeiro programa. Implementa a fórmula resolvente.
 */
package aula01_02102017;

public class FormulaResolvente {

	public static void main(String[] args) {
	
		double a, b, c;
		
		a = 1;
		b = 1;
		c = 1;
		
		if (a == 0) {
			System.out.println("Não é uma equação do segundo grau!");
		}
		else {
			double delta = Math.pow(b, 2) - 4 * a * c;
			if (delta >= 0) {
				System.out.println("Raíz 1: " + ((-b + Math.sqrt(delta))/(2 * a)));
				System.out.println("Raíz 2: " + ((-b - Math.sqrt(delta))/(2 * a)));
			}
			else {
				System.out.println("Raízes Imaginárias: " + (-b/2/a + " +/- " + Math.sqrt(-delta)/2/a + "i"));
			}
		}
		
		System.out.println("Programa Terminado");
	}

}

package aula02_06102017;

import java.util.Scanner;
/**
 * Inacabado!!!!
 * @author sergiovalente
 *
 */
public class Palindromo2 {

	public static void main(String[] args) {
		
		palindromo();
		
	}
	
	public static void palindromo() {
		
		Scanner input = new Scanner(System.in);
		long numeroInvertido = 0;
		System.out.println("Digite o número: ");
		long num = input.nextLong();
		
		int[] numero = new int[(int) Math.log10(num) + 1]; // array com o tamanho do número!!!
		
		//inverter número
		for(int i = 0; i < numero.length; i++) {
			numero[i] = (int) num % 10;
			System.out.println(num%10);
			num /= 10;
		}
		
		for (int i = 0; i < numero.length; i++) {
			numeroInvertido += numero[i] * Math.pow(10, ((numero.length - 1) - i));
		}
		System.out.println(numeroInvertido);
		input.close();
	}
}

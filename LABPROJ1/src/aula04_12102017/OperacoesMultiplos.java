package aula04_12102017;

import java.util.ArrayList;
import java.util.Collections;

/**
 * II. Sabendo que o operador % do Java dá o resto da divisão entre dois inteiros pretende-se que elabore um programa, 
 * 	   com funções, que dado um vector:<br><br>
a) retorne todos os múltiplos de 3<br>
b) retorne todos os múltiplos de um dado número inteiro<br>
c) retorne todos os múltiplos de 3 e 5<br>
d) retorne todos os múltiplos de dois números inteiros<br>
e) retorne todos os múltiplos de dois números inteiros num intervalo dado, mas por ordem decrescente
 *
 * @author sergiovalente
 *
 */
public class OperacoesMultiplos {

	public static ArrayList<Integer> multiplosDeTres(int[] a) {
		
		ArrayList<Integer> multiplos = new ArrayList<>();
		
		for (int elem: a) {
			if (elem % 3 == 0) 
				multiplos.add(elem);
		}
		
		return multiplos;
	}
	
	public static ArrayList<Integer> multiplosDeUmNumero(int[] a, int num) {
		
		ArrayList<Integer> multiplos = new ArrayList<>();
		
		for (int elem: a) {
			if (elem % num == 0) 
				multiplos.add(elem);
		}
		
		return multiplos;
	}
	
	public static ArrayList<Integer> multiplosDeTresECinco(int[] a) {
		
		ArrayList<Integer> multiplos = new ArrayList<>();
		
		for (int elem: a) {
			if ((elem % 3 == 0) && (elem % 5 == 0))
				multiplos.add(elem);
		}
		
		return multiplos;
	}
	
	public static ArrayList<Integer> multiplosDeDoisInteiros(int[] a, int num1, int num2) {
		
		ArrayList<Integer> multiplos = new ArrayList<>();
		
		for (int elem: a) {
			if ((elem % num1 == 0) && (elem % num2 == 0))
				multiplos.add(elem);
		}
		
		return multiplos;
	}
	
	public static ArrayList<Integer> multiplosDeDoisInteirosOrdemDecrescente(int[] a, int num1, int num2) {
		
		ArrayList<Integer> multiplos = new ArrayList<>();
		
		multiplos = multiplosDeDoisInteiros(a, num1, num2);
		Collections.sort(multiplos);
		Collections.reverse(multiplos);
		
		return multiplos;
	}
}

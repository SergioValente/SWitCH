package exercicios04102017;

import java.util.Scanner;

/**
 * Exercícios propostos por Prof. Ângelo Martins no Yammer a 4/10/2017.<br><br>
 * I. Sabendo que o operador % do Java dá o resto da divisão entre dois inteiros pretende-se que elabore um programa que:
	<br>a)	liste todos os múltiplos de 3 num intervalo dado
	<br>b)	liste todos os múltiplos de um dado número inteiro num intervalo dado
	<br>c)	liste todos os múltiplos de 3 e 5 num intervalo dado
	<br>d)	liste todos os múltiplos de dois números inteiros num intervalo dado
	<br>e)	liste todos os múltiplos de dois números inteiros num intervalo dado, mas por ordem decrescente
<br><br>
   II. Para cada uma das alíneas seguintes elabore uma função que retorne:
	<br>a)	a soma de todos os números pares: long somaPares(int inf, int sup)
	<br>b)	a soma de todos os múltiplos de “num”: long somaMult(int num, int inf, int sup)
<br><br>
   Teste os resultados das funções com os conjuntos de valores que considere apropriados.
 * @author sergiovalente
 *
 */
public class Multiplo {

/**
 * Imprime os resultados de todas as alíneas	descritas no Javadoc da classe.
 * @param args
 */
public static void main(String[] args) {
		
		System.out.print("Cálculo de todos os múltiplos de 3 num dado intervalo.\n\n");
		multiplosDe1Num(3);
		System.out.println("\n");
		
		System.out.print("Cálculo de todos os múltiplos de um número num dado intervalo.\n\n");
		multiplosDe1Num(getNumber());
		System.out.println("\n");
		
		System.out.print("Cálculo de todos os múltiplos de 3 e 5 num dado intervalo.\n\n");
		multiplosDe2Num(3, 5);
		System.out.println("\n");
		
		System.out.print("Cálculo de todos os múltiplos de dois números num dado intervalo.\n\n");
		multiplosDe2Num(getNumber(), getNumber());
		System.out.println("\n");
		
		System.out.print("Cálculo de todos os múltiplos de dois números num dado intervalo.");
		System.out.println("(imprimidos por ordem descendente)\n\n");
		invertedMultiplos(getNumber(), getNumber());
		System.out.println("\n");
		
		System.out.print("Cálculo da soma de todos os números pares num dado intervalo.\n\n");
		System.out.printf("A soma dos pares contidos no intervalo definido é igual a %d", 
				somaPares());
		System.out.println("\n");
		
		System.out.print("Cálculo da soma de todos os múltiplos de um número num dado intervalo.\n\n");
		System.out.printf("A soma dos múltiplos do número escolhido contidos no intervalo definido é igual a %d", 
				somaMult(getNumber()));
		System.out.println("\n");
		
	}
	
	/**
	 * Método para calcular todos os múltiplos de um número num dado intervalo.
	 */
	public static void multiplosDe1Num(int num) {
		
		int[] limites = new int[2];
		
		getLimits(limites); //afere os limites inferior e superior do intervalo
		
		//Cálculo e impressão dos múltiplos
		for(int i = limites[0]; i <= limites[1]; i++) {
			if (i == 0) continue; //evitar o zero
			if (i % num == 0) {
				System.out.printf("%d é múltiplo de %d.%n", i, num);
			}
		}	
	}
	
	public static void multiplosDe2Num(int primeiroNum, int segundoNum) {
		
		int[] limites = new int[2];
		
		getLimits(limites); //afere os limites inferior e superior do intervalo
		
		//Cálculo e impressão dos múltiplos
		for(int i = limites[0]; i <= limites[1]; i++) {
			if (i == 0) continue;
			if ((i % primeiroNum == 0) && (i % segundoNum == 0)) {
				System.out.printf("%d é múltiplo de %d e múltiplo de %d.%n", i, primeiroNum, segundoNum);
				continue;
			}
		}			
	}
	
	/**
	 * Método que calcula e imprime por ordem decrescente os múltiplos comuns a dois números 
	 * @param primeiroNum número para calcular múltiplos
	 * @param segundoNum número para calcular múltiplos
	 */
	public static void invertedMultiplos(int primeiroNum, int segundoNum) {
		
		int[] limites = new int[2];
		
		getLimits(limites); //afere os limites inferior e superior do intervalo
		
		//Cálculo e impressão dos múltiplos
		for(int i = limites[1]; i >= limites[0]; i--) {
			if (i == 0) continue;
			if ((i % primeiroNum == 0) && (i % segundoNum == 0)) {
				System.out.printf("%d é múltiplo de %d e múltiplo de %d.%n", i, primeiroNum, segundoNum);
				continue;
			}
		}		
	}
	
	/**
	 * Método que irá calcular os limites do intervalo
	 * @param lim: array de dois inteiros que irá conter os limites 
	 * @return mesmo array
	 */
	public static int[] getLimits(int[] lim) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner (System.in);
		lim[0] = 1; //mock value
		lim[1] = 0; //mock value
		
		while(lim[0] > lim[1]) {
		
			//Saber quais os limites do intervalo e o número para se calcular os seus múltiplos
			System.out.print("Digite o limite inferior do intervalo: ");
			lim[0] = input.nextInt();
			System.out.print("Digite o limite superior do intervalo: ");
			lim[1] = input.nextInt();
			
			// teste dos limites
			if (lim[0] > lim[1]) {
				System.out.println("O limite superior deve ser maior que o limite inferior!");
			}
		}
		
		System.out.println();
		return lim;	
	}
	
	/**
	 * Método para retornar o número escolhido para obter os seus múltiplos
	 * @return número
	 */
	public static int getNumber() {
		
		int num = 0; //mock value
		
		Scanner inputNumber = new Scanner(System.in);
		
		while (num == 0) {
			System.out.print("Digite número para obter múltiplos: ");
			num = inputNumber.nextInt();
			
			//teste número diferente de zero
			if(num == 0) {
				System.out.println("O número tem que ser diferente de zero!");
			}
		}
		return num;
	}
	
	/**
	 * Método que calcula a soma de todos os pares num determinado intervalo.
	 * @return soma dos pares
	 */
	public static long somaPares() {
		
		int[] limites = new int[2];
		long soma = 0;
		
		getLimits(limites); //afere os limites inferior e superior do intervalo
		
		//cálculo da soma dos pares no intervalo
		for (int i = limites[0]; i <= limites[1]; i++) {
			if (i % 2 == 0) {
				soma += i;
			}
		}
		return soma;
	}
	
	/**
	 * Método que calcula a soma de todos os múltiplos de um dado número num determinado intervalo.
	 * @param num número escolhido para obter os seus múltiplos
	 * @return soma dos múltiplos de num
	 */
	public static long somaMult(int num) {
		
		int[] limites = new int[2];
		long soma = 0;
		
		getLimits(limites); //afere os limites inferior e superior do intervalo
		
		//cálculo da soma dos pares no intervalo
		for (int i = limites[0]; i <= limites[1]; i++) {
			if (i % num == 0) {
				soma += i;
			}
		}
		return soma;		
	}
}
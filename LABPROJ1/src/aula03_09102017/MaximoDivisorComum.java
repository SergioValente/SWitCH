package aula03_09102017;

public class MaximoDivisorComum {

	public static void main(String[] args) {

		System.out.println(maxDivComum(20,12));
	}

	public static int maxDivComum(int num1, int num2) {
		
		if (num1 == 0 || num2 == 0) return Math.max(num1, num2);
		for (int i = Math.min(num1, num2); i >= 1; i--) {
			if (num1 % i == 0 && num2 % i == 0)
				return i;
		}
		return 1;
	}
}

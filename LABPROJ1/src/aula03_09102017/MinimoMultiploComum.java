package aula03_09102017;

public class MinimoMultiploComum {

	public static void main(String[] args) {
		 
		System.out.println(MMC(12, 16));
	}
	public static int MMC(int num1, int num2) {
		
		if (num1 == 0 || num2 == 0) return (int) Double.NaN;
		if (num1 == 1 || num2 == 1) {
			return Math.max(num1, num2);
		}
		for (int i = 2; i < num1 * num2; i++) {
			if (num1 % i == 0 && num2 % i == 0) {
				return i;
			}
		}
		return num1 * num2;
	}
}

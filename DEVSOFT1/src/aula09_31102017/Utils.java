package aula09_31102017;

import java.util.ArrayList;
import java.util.List;

public class Utils {

	public static List<Ponto> getPontos(char[][] matrix, char c) {
		
		List<Ponto> listaPontos = new ArrayList<>();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == c)
					listaPontos.add(new Ponto(i,j));
			}
		}
		return listaPontos;
	}
}

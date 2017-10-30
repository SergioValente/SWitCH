package aula12_30102017;

import java.util.Arrays;

public class Matrix {

	private int[][] matrix;
	private int numLines;
	private int numColumns;
	
	//contrutores
	public Matrix(int numLines, int numColumns) {
		
		matrix = new int[numLines][numColumns]; 
		this.numLines = numLines;
		this.numColumns = numColumns;
	}
	
	public Matrix(int[][] m) {
		
		matrix= new int[m.length][m[0].length];
		numLines = m.length;
		numColumns = m[0].length;
		
		for (int i = 0; i < numLines; i++) {
			for (int j = 0; j < numColumns; j++) {
				matrix[i][j] = m[i][j];
			}
		}
	}
	
	public Matrix addMatrix (Matrix b) {
		
		Matrix matrixAdded = new Matrix (this.numLines,this.numColumns);
		
		for (int i = 0; i < this.numLines; i++) {
			for (int j = 0; j < this.numColumns; j++) {
				matrixAdded.matrix[i][j] = this.matrix[i][j] + b.matrix[i][j];
			}
		}
		return matrixAdded;
	}
	
	public Matrix multiplyMatrix(Matrix b) throws Exception{
	
		Matrix matrixMultiplied = new Matrix (this.numLines, b.numColumns);
		int soma = 0;
		if ((this.numLines != b.numColumns) || (this.numColumns != b.numLines))
			throw new Exception();
		
		for (int i = 0; i < this.numLines; i++) {
			for (int k = 0; k < b.numColumns; k++) {
				soma = 0;
				for (int j = 0; j < this.numColumns; j++) {
					soma += this.matrix[i][j] * b.matrix[j][k];
				}
				matrixMultiplied.matrix[i][k] = soma;
			}
			
		}
		return matrixMultiplied;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(matrix);
		result = prime * result + numColumns;
		result = prime * result + numLines;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matrix other = (Matrix) obj;
		if (!Arrays.deepEquals(matrix, other.matrix))
			return false;
		if (numColumns != other.numColumns)
			return false;
		if (numLines != other.numLines)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		
		String res = "";
		if ((this.numLines > 0) && (this.numColumns > 0)) {
			for (int i = 0; i < this.numLines; i++) {
				for (int j = 0; j < this.numColumns; j++) {
					res = res + " " + this.matrix[i][j];
				}
				res = res + "\n";
			}
		}
		
		return res;
	}
	
	
}

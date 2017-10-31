package aula12_30102017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	/**
	 * Adds this matrix to matrix b
	 * @param b Matrix to be added
	 * @return Matrix added
	 */
	public Matrix addMatrix (Matrix b) {
		
		Matrix matrixAdded = new Matrix (this.numLines,this.numColumns);
		
		for (int i = 0; i < this.numLines; i++) {
			for (int j = 0; j < this.numColumns; j++) {
				matrixAdded.matrix[i][j] = this.matrix[i][j] + b.matrix[i][j];
			}
		}
		return matrixAdded;
	}
	
	/**
	 * Multiplies this matrix with matrix b
	 * @param b matrix to be multiplied
	 * @return Matrix multiplied
	 * @throws Exception When the two matrices cannot be multiplied (number of lines must be<br>
	 * equal to the other's number of columns).
	 */
	public Matrix multiplyMatrix(Matrix b) throws IllegalArgumentException{
	
		Matrix matrixMultiplied = new Matrix (this.numLines, b.numColumns);
		int soma = 0;
		
		if ((this.numLines != b.numColumns) || (this.numColumns != b.numLines))
			throw new IllegalArgumentException();
		
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
	
	/**
	 * Searches the matrix for a given number
	 * @param num Number to search for
	 * @return A list of <Ponto> containing the positions where its number is equal to num 
	 */
	public List<Ponto> getPointsWithNumber(int num) {
		
		List<Ponto> points = new ArrayList<>();
		
		for(int i = 0; i < this.numLines; i++) {
			for(int j = 0; j < this.numColumns; j++) {
				if (this.matrix[i][j] == num)
					points.add(new Ponto(i,j));
			}
		}
		return points;
	}
	
	/**
	 * Sets a new value for the matrix in point i
	 * @param i Coordinates of the point to be altered
	 * @param value Value that will substitute the one contained in the matrix
	 * @throws Exception When i is out of bounds
	 */
	public void setValue(Ponto i, int value) throws Exception{
		
		if ((i.getX() < 0) || (i.getX() > this.numLines))
			throw new IllegalArgumentException();
		if ((i.getY() < 0) || (i.getY() > this.numColumns)) 
			throw new IllegalArgumentException();
		
		this.matrix[i.getX()][i.getY()] = value;
	}
	
	/**
	 * Given a point (Ponto), retrieves the value contained in that point
	 * @param i Coordinates of the point to be retrieved
	 * @return Value retrieved
	 * @throws Exception When the point is out of bounds
	 */
	public int getValue(Ponto i) throws Exception{	
		
		if ((i.getX() < 0) || (i.getX() > this.numLines))
			throw new IllegalArgumentException();
		if ((i.getY() < 0) || (i.getY() > this.numColumns))
			throw new IllegalArgumentException();
		
		return this.matrix[i.getX()][i.getY()];
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

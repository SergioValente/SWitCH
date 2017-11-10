package aula13_02112017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implements several matrix related methods. Uses OOP rather than static methods.
 * @author sergiovalente
 *
 */
public class Matrix2 {

	private int[][] matrix;
	private int numLines;
	private int numColumns;

	//constructors
	public Matrix2(int numLines, int numColumns) {

		this.matrix = new int[numLines][numColumns];
		this.numLines = numLines;
		this.numColumns = numColumns;
	}

	public Matrix2(int[][] m) {

		// not checking because of other tests.
		//if (!isMatrixRectangular(m))
		//	throw new IllegalArgumentException();

		this.matrix = new int[m.length][m[0].length];
		this.numLines = m.length;
		this.numColumns = m[0].length;

		for (int i = 0; i < this.numLines; i++) {
			for (int j = 0; j < this.matrix[i].length; j++) {
				this.matrix[i][j] = m[i][j];
			}
		}
	}

	/**
	 * Adds this matrix to matrix b
	 * @param b Matrix to be added
	 * @return Matrix added
	 */
	public Matrix2 addMatrix (Matrix2 b) {

		Matrix2 matrixAdded = new Matrix2 (this.numLines,this.numColumns);

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
	public Matrix2 multiplyMatrix(Matrix2 b) throws IllegalArgumentException{

		Matrix2 matrixMultiplied = new Matrix2 (this.numLines, b.numColumns);
		int soma = 0;

		if ((this.numLines != b.numColumns) || (this.numColumns != b.numLines)) {
			throw new IllegalArgumentException();
		}

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
				if (this.matrix[i][j] == num) {
					points.add(new Ponto(i,j));
				}
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

		if ((i.getX() < 0) || (i.getX() > this.numLines)) {
			throw new IllegalArgumentException();
		}
		if ((i.getY() < 0) || (i.getY() > this.numColumns)) {
			throw new IllegalArgumentException();
		}

		this.matrix[i.getX()][i.getY()] = value;
	}

	/**
	 * Given a point (Ponto), retrieves the value contained in that point
	 * @param i Coordinates of the point to be retrieved
	 * @return Value retrieved
	 * @throws Exception When the point is out of bounds
	 */
	public int getValue(Ponto i) throws Exception{

		if ((i.getX() < 0) || (i.getX() > this.numLines)) {
			throw new IllegalArgumentException();
		}
		if ((i.getY() < 0) || (i.getY() > this.numColumns)) {
			throw new IllegalArgumentException();
		}

		return this.matrix[i.getX()][i.getY()];
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(this.matrix);
		result = prime * result + this.numColumns;
		result = prime * result + this.numLines;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Matrix2 other = (Matrix2) obj;
		if (!Arrays.deepEquals(this.matrix, other.matrix)) {
			return false;
		}
		if (this.numColumns != other.numColumns) {
			return false;
		}
		if (this.numLines != other.numLines) {
			return false;
		}
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

	//Previously implemented methods, now transformed to conform with OOP

	/**
	 * Adds each line of a matrix and puts the result in a Vetor object
	 * @return Vetor object containing the sum of each line in the matrix
	 */
	public Vetor somaCadaLinhaMatriz() {

		if (this.numColumns == 0) {
			throw new IllegalArgumentException();

		}
		int soma;
		Vetor somatorio = new Vetor(this.numColumns);

		for (int i = 0; i < this.numLines; i++) {
			soma = 0;
			for (int j = 0; j < this.matrix[i].length; j++) {
				soma += this.matrix[i][j];
			}
			somatorio.setVetorValue(i, soma);
		}
		return somatorio;
	}

	/**
	 * Checks if all elements of a Vetor object exist in the matrix
	 * @param b Vetor object containing all the values to be tested
	 * @return True if all the elements of Vetor b exist in the matrix, false if not.
	 */
	public boolean existsInMatrix(Vetor b) {

		boolean found;

		if(b.getNumElements() == 0) {
			return false;
		}

		for (int k = 0; k < b.getNumElements(); k++) {
			found = false;

			loopCorrerMatriz:
			for(int i = 0; i < this.matrix.length; i++ ) {
				for (int j = 0; j < this.matrix[i].length; j++) {
					if (b.getVetorValue(k) == this.matrix[i][j]) {
						found = true;
						break loopCorrerMatriz;
					}
				}
			}
			if (!found) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks the equality of two matrices
	 * @param b Matrix2 object representing a matrix
	 * @return True if b is equal to this object, false if it's not.
	 */
	public boolean isEqualMatrices(Matrix2 b) {

		if ((this.numLines != b.numLines) || (this.numColumns != b.numColumns)) {
			return false;
		}

		for (int i = 0; i < this.numLines; i++) {
			for (int j = 0; j < this.numColumns; j++) {
				if (this.matrix[i][j] != b.matrix[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Calculates the transposed matrix (out-of-place)
	 * @return Another Matrix2 object containing the transposed matrix of this object.
	 * @throws Exception If the matrix has zero columns
	 */
	public Matrix2 matrizTransposta() throws Exception{

		Matrix2 transposed = new Matrix2(this.numColumns, this.numLines);

		if (this.numColumns == 0) {
			throw new IllegalArgumentException();

		}
		else {
			for (int i = 0; i < this.numLines; i++) {
				for (int j = 0; j < this.numColumns; j++) {
					transposed.matrix[j][i] = this.matrix[i][j];
				}
			}
		}
		return transposed;
	}

	/**
	 * Checks if this Matrix2 object is symmetric matrix relative to the main diagonal.
	 * @return True if it's symmetric, false if it's not.
	 */
	public boolean isSimetricaDiagonalPrincipal() {

		if (this.numLines != this.numColumns) {
			return false;
		}

		for (int i = 0; i < this.numLines; i++) {

			for (int j = i + 1; j < this.numColumns; j++) { // j = i + 1 para percorrer só a parte de cima da matriz!!!!

				if(this.matrix[i][j] != this.matrix[j][i]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Checks if this Matrix2 object is symmetric matrix relative to the secondary diagonal.
	 * @return True if it's symmetric, false if it's not.
	 */
	public boolean isSimetricaDiagonalSecundaria() {

		if (this.numLines != this.numColumns) {
			return false;
		}

		for (int i = 0; i < this.numLines - 1; i++) {

			for (int j = 0; j < this.numLines - 1 - i; j++) { // j < a.length - 1 - i para só percorrer a parte de cima!!!

				if(this.matrix[i][j] != this.matrix[this.numLines - 1 - j][this.numLines - 1 - i]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Clones this matrix
	 * @return Cloned Matrix
	 */
	public Matrix2 cloneMatrix() {

		Matrix2 auxMatrix = new Matrix2(this.matrix);
		return auxMatrix;
	}

	/**
	 * Checks if a given matrix is rectangular
	 * @param m Matrix to be checked
	 * @return true if it's rectangular, false if it's not.
	 */
	@SuppressWarnings("unused")
	private boolean isMatrixRectangular(int[][] m) {

		for (int i = 0; i < m.length; i++) {

			if (m[i].length != m.length) {
				return false;
			}
		}
		return true;
	}
}

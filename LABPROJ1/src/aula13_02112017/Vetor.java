package aula13_02112017;

import java.util.Arrays;

public class Vetor {

	private int[] vector;
	private int numElements;
	
	//Construtores
	public Vetor() {
		
		vector = new int[1];
		numElements = vector.length;
	}
	
	public Vetor(int numElem) {
		
		vector = new int[numElem];
		numElements = numElem;
	}
	
	public Vetor (int[] vet) {
		
		vector = new int[vet.length];
		numElements = vet.length;
		
		for(int i = 0; i < vector.length; i++) {
			vector[i] = vet[i];
		}
	}

	//Getters e Setters
	public int[] getVetor() {
		return vector;
	}

	public void setVetorValue(int index, int value) {
		this.vector[index] = value;
	}

	public int getNumElements() {
		return numElements;
	}

	public void setNumElements(int numElements) {
		this.numElements = numElements;
	}

	//hashCode And Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numElements;
		result = prime * result + Arrays.hashCode(vector);
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
		Vetor other = (Vetor) obj;
		if (numElements != other.numElements)
			return false;
		if (!Arrays.equals(vector, other.vector))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		
		String represent ="";
		for (int i = 0; i < this.numElements; i++) {
			represent = (represent + " " + this.vector[i]);
		}
		return represent;
	}
}

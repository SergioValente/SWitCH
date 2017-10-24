package aula03_17102017;

import java.io.*;

public class Mensagem {

	private int tamanho;
	private byte[] conteudo;
	
	/**
	 * Method that instantiates a Message object using inS
	 * @param inS DataInputStream source 
	 */
	public Mensagem (DataInputStream inS) {
		
		try {
			tamanho = inS.read();
			conteudo = new byte[tamanho];
			inS.read(conteudo, 0, tamanho);
		}
		catch (IOException e) {
			tamanho = -1; //assinala erro IO
		}
	}
	/**
	 * Method to create Object from a string
	 * @param s string source
	 */
	public Mensagem (String s) {
		
		tamanho = s.length();
		conteudo = s.getBytes();
	}
	
	public boolean estaVazia() {
		return (tamanho == 0);
	}
	
	public boolean erro(){
		return (tamanho == -1);
	}
	
	//Enviar mensagem
	public boolean enviar (DataOutputStream outS) {
		
		if (tamanho < 0 || tamanho > 255) return false;
		
		try {
			outS.write(tamanho);
			outS.write(conteudo, 0, tamanho);
		}
		catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public String comoString() {
		
		String s = new String(conteudo, 0, tamanho);
		return s; 
	}
	
	public boolean eComando() {
		
		if (tamanho < 1) return false;
		if (conteudo[0] == '.') return true;
		return false;
		
		//return(this.comoString().startsWith(".")); outra forma de fazer (menos eficiente, em princípio)
		
		
	}
}

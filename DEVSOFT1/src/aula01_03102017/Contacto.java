package aula01_03102017;

/**
 * Criação de uma classe para simular uma lista telefónica.
 * @author sergiovalente
 *
 */
public class Contacto {
	
	private String nome;
	private String numeroTelemovel;
	
	
	/**
	 * Construtor da classe com nome e número de telemóvel
	 * @param nome 
	 * @param numeroTelemovel
	 */
	public Contacto(String nome, String numeroTelemovel) {
		this.nome = nome;
		this.numeroTelemovel = numeroTelemovel;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNumeroTelemovel() {
		return numeroTelemovel;
	}


	public void setNumeroTelemovel(String numeroTelemovel) {
		this.numeroTelemovel = numeroTelemovel;
	}

}

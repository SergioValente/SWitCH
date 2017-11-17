package aula12_14112017;

public class EnderecoPostal {

	private String nomeRua;
	private String codigoPostal;
	private String localidade;
	private String pais;

	public EnderecoPostal() {

	}
	public EnderecoPostal(String nomeRua, String codigoPostal, String localidade, String pais) {
		this.nomeRua = nomeRua;
		this.codigoPostal = codigoPostal;
		this.localidade = localidade;
		this.pais = pais;
	}

	//getters e setters
	public String getNomeRua() {
		return nomeRua;
	}
	public void setNomeRua(String nomeRua) {
		if (nomeRua.isEmpty()) {
			throw new IllegalArgumentException ("O campo \"Rua\" é obrigatório");
		}
		this.nomeRua = nomeRua;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {

		if (codigoPostal.isEmpty()) {
			throw new IllegalArgumentException ("O campo \"Código Postal\" é obrigatório");
		}
		this.codigoPostal = codigoPostal;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {

		if (localidade.isEmpty()) {
			throw new IllegalArgumentException ("O campo \"Localidade\" é obrigatório");
		}
		this.localidade = localidade;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {

		if (pais.isEmpty()) {
			throw new IllegalArgumentException ("O campo \"País\" é obrigatório");
		}
		this.pais = pais;
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
		EnderecoPostal other = (EnderecoPostal) obj;
		if (codigoPostal == null) {
			if (other.codigoPostal != null) {
				return false;
			}
		} else if (!codigoPostal.equals(other.codigoPostal)) {
			return false;
		}
		if (nomeRua == null) {
			if (other.nomeRua != null) {
				return false;
			}
		} else if (!nomeRua.equals(other.nomeRua)) {
			return false;
		}
		return true;
	}

	//toString
	@Override
	public String toString() {
		return "EnderecoPostal [nomeRua=" + nomeRua + ", codigoPostal=" + codigoPostal
				+ ", localidade=" + localidade + ", pais=" + pais + "]";
	}

}

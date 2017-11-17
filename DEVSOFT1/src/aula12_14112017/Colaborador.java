package aula12_14112017;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Colaborador {

	private String nome;
	private String numTelefone;
	private String email;
	private String numMecanografico;
	private String numContribuinte;
	private Date dataNascimento;
	private List<EnderecoPostal> listaEnderecos;
	private List<Tarefa> tarefasConcluidas;
	private List<Tarefa> tarefasPendentes;
	//private Grupo grupo;


	public Colaborador() {

	}

	//Tested
	public Colaborador(String name, String phoneNumber, String email, String numMecanografico,
			String numContribuinte, Date dataNascimento, List<EnderecoPostal> listaEnderecos) {

		tarefasConcluidas = new ArrayList();
		tarefasPendentes = new ArrayList();

		nome = name;
		numTelefone = phoneNumber;
		this.email = email;
		this.numMecanografico = numMecanografico;
		this.numContribuinte = numContribuinte;
		this.dataNascimento = dataNascimento;
		this.listaEnderecos = listaEnderecos;
	}

	public String getNome() {
		return nome;
	}

	//Tested
	public void setNome(String nome) {

		if(nome.isEmpty()) {
			throw new IllegalArgumentException ("O campo \"Nome\" é obrigatório");
		}
		this.nome = nome;
	}

	public String getNumTelefone() {
		return numTelefone;
	}

	//Tested
	public void setNumTelefone(String numTelefone) {

		if(numTelefone.isEmpty()) {
			throw new IllegalArgumentException ("O campo \"Número de Telefone\" é obrigatório");
		}
		this.numTelefone = numTelefone;
	}

	public String getEmail() {
		return email;
	}

	//Tested
	public void setEmail(String email) {

		if(email.isEmpty()) {
			throw new IllegalArgumentException ("O campo \"Email\" é obrigatório");
		}
		this.email = email;
	}

	public String getNumMecanografico() {
		return numMecanografico;
	}

	//Tested
	public void setNumMecanografico(String numMecanografico) {

		if(numMecanografico.isEmpty()) {
			throw new IllegalArgumentException ("O campo \"Número Mecanográfico\" é obrigatório");
		}
		this.numMecanografico = numMecanografico;
	}

	public String getNumContribuinte() {
		return numContribuinte;
	}

	//Tested
	public void setNumContribuinte(String numContribuinte) {

		if(numContribuinte.isEmpty()) {
			throw new IllegalArgumentException ("O campo \"Número de Contribuinte\" é obrigatório");
		}
		this.numContribuinte = numContribuinte;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	//Tested
	public void setDataNascimento(Date dataNascimento) {

		if(dataNascimento == null) {
			throw new IllegalArgumentException ("O campo \"Data de Nascimento\" é obrigatório");
		}
		this.dataNascimento = dataNascimento;
	}

	public List<EnderecoPostal> getListaEnderecos() {
		return listaEnderecos;
	}

	//Tested
	public boolean addEndereco(EnderecoPostal endereco) {

		if (!(listaEnderecos.contains(endereco))) {
			listaEnderecos.add(endereco);
			return true;
		}
		return false;
	}
	//Tested
	public boolean removeEndereco(EnderecoPostal endereco) {

		if (listaEnderecos.contains(endereco)) {
			listaEnderecos.remove(endereco);
			return true;
		}
		return false;
	}


	public List<Tarefa> getTarefasConcluidas() {
		return tarefasConcluidas;
	}

	//tested
	public boolean addTarefa(Tarefa tarefa) {
		return tarefasPendentes.add(tarefa);
	}

	//Tested
	public boolean removeTarefa(Tarefa tarefa) {

		return tarefasPendentes.remove(tarefa);
	}

	//Tested
	public boolean marcarTarefaComoConcluida(Tarefa tarefa) {

		if (!tarefasPendentes.contains(tarefa)) {
			return false;
		}
		tarefasConcluidas.add(tarefa);
		tarefasPendentes.remove(tarefa);
		return true;
	}

	//Tested
	public void consultarTarefasPendentes() {

		for (Tarefa tarefaPendente: tarefasPendentes) {
			System.out.println(tarefaPendente + "\n");

		}
	}

	//Tested
	@Override
	public boolean equals(Object obj) {
		Colaborador other = (Colaborador) obj;
		if (numContribuinte == other.numContribuinte) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Colaborador [nome=" + nome + ", numTelefone=" + numTelefone +
				", email=" + email + ", numMecanografico=" + numMecanografico +
				", numContribuinte=" + numContribuinte + ", dataNascimento=" +
				dataNascimento + ", listaEnderecos=" + listaEnderecos + "]";
	}
}

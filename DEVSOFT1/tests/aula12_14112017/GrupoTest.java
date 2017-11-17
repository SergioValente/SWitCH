package aula12_14112017;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class GrupoTest {

	Grupo grupo = new Grupo();

	String nome = "Sergio";
	String nomeAlt = "Joao";
	String numContribuinte = "234567890";
	Date dataNascimento = new Date();
	String numTelefone = "+351964324567";
	String email = "167423@isep.ipp.pt";
	String numMecanografico = "11874638";
	List<EnderecoPostal> listaEnderecos = new ArrayList<EnderecoPostal>();
	Colaborador col1 = new Colaborador(nome, numTelefone, email, numMecanografico, numContribuinte,
			dataNascimento, listaEnderecos);
	Colaborador col2 = new Colaborador();

	//Tests to validate method addColaborador
	@Test
	public void testAddColaboradorSuccess() {

		boolean result = grupo.addColaborador(col1);
		assertTrue(result);
	}

	@Test
	public void testAddColaboradorFailureAlreadyExists() {

		grupo.addColaborador(col1);
		boolean result = grupo.addColaborador(col1);

		assertFalse(result);
	}

	//Tests to validate method removeColaborador
	@Test
	public void testRemoveColaboradorSuccess() {

		grupo.addColaborador(col1);
		boolean result = grupo.removeColaborador(col1);

		assertTrue(result);
	}

	@Test
	public void testRemoveColaboradorFailureNotInList() {

		grupo.addColaborador(col1);
		boolean result = grupo.removeColaborador(col2);

		assertFalse(result);
	}

	@Test
	public void testRemoveColaboradorFailureEmptyList() {

		boolean result = grupo.removeColaborador(col2);

		assertFalse(result);
	}

	//Tests to validate method existsInGroup
	@Test
	public void testExistsInGroupSuccess() {

		grupo.addColaborador(col1);
		boolean result = grupo.existsInGroup(col1);

		assertTrue(result);
	}

	@Test
	public void testExistsInGroupFailureNotInGroup() {

		grupo.addColaborador(col1);
		boolean result = grupo.existsInGroup(col2);

		assertFalse(result);
	}

	@Test
	public void testExistsInGroupEmptyList() {

		boolean result = grupo.existsInGroup(col2);

		assertFalse(result);
	}

	//Tests to validate method nomeExistsInGroup
	@Test
	public void testNameExistsInGroupSuccess() {

		grupo.addColaborador(col2);
		col2.setNome("Sergio");
		boolean result = grupo.nameExistsInGroup("Sergio");

		assertTrue(result);
	}

	@Test
	public void testNameExistsInGroupFailure() {

		grupo.addColaborador(col2);
		col2.setNome("Joao");
		boolean result = grupo.nameExistsInGroup("Sergio");

		assertFalse(result);
	}

}

package aula12_14112017;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class ColaboradorTest {

	String nome = "Sergio";
	String nomeAlt = "Joao";
	String numContribuinte = "234567890";
	Date dataNascimento = new Date();
	Date comecoTarefa = new Date(2017, 10, 20);
	Date previsaoConclusaoTarefa = new Date(2017, 10, 25);
	Date dataCriacaoTarefa = new Date();

	String numTelefone = "+351964324567";
	String email = "167423@isep.ipp.pt";
	String numMecanografico = "11874638";
	List<EnderecoPostal> listaEnderecos = new ArrayList<EnderecoPostal>();
	Colaborador col1 = new Colaborador(nome, numTelefone, email, numMecanografico, numContribuinte,
			dataNascimento, listaEnderecos);
	Colaborador col2 = new Colaborador();
	Tarefa tarefa1 = new Tarefa("Teste", dataCriacaoTarefa, previsaoConclusaoTarefa, comecoTarefa);
	Tarefa tarefa2 = new Tarefa("Teste2", dataCriacaoTarefa, previsaoConclusaoTarefa, comecoTarefa);

	//Test to validate instance of colaborador
	@Test
	public void testColaboradorSuccess() {
		assertTrue(col1 instanceof Colaborador);
	}

	//Tests to validate method setNome
	@Test
	public void testSetNomeSuccess() {

		col1.setNome(nomeAlt);
		String result = col1.getNome();

		assertEquals(nomeAlt, result);
	}

	@Test(expected = Exception.class)
	public void testSetNomeEmptyField() {

		col1.setNome("");
	}

	//Tests to validate method setNumTelefone
	@Test
	public void testSetNumTelefoneSuccess() {
		String numTel = "234567890";
		col1.setNumTelefone(numTel);
		String result = col1.getNumTelefone();

		assertEquals(numTel, result);
	}

	@Test(expected = Exception.class)
	public void testSetNumTelefoneEmptyField() {

		col1.setNumTelefone("");
	}

	//Tests to validate method setEmail
	@Test
	public void testSetEmailSuccess() {

		String email2 = "sergio@rteuiod.ipewe.pt";
		col1.setEmail(email2);
		String result = col1.getEmail();

		assertEquals(email2, result);
	}

	@Test(expected = Exception.class)
	public void testSetEmailEmptyField() {

		col1.setEmail("");
	}

	//Tests to validate method setNumMecanografico
	@Test
	public void testSetNumMecanografico() {

		String numMec2 = "10707988";
		col1.setNumMecanografico(numMec2);
		String result = col1.getNumMecanografico();

		assertEquals(numMec2, result);
	}

	@Test(expected = Exception.class)
	public void testSetNumMecanograficoEmptyField() {

		col1.setNumMecanografico("");
	}

	//Tests to validate method setNumContribuinte
	@Test
	public void testSetNumContribuinte() {

		String numCont = "278943729";
		col1.setNumContribuinte(numCont);
		String result = col1.getNumContribuinte();

		assertEquals(numCont, result);
	}

	@Test(expected = Exception.class)
	public void testSetNumContribuinteEmptyField() {

		String numCont = "";
		col1.setNumContribuinte(numCont);
	}

	//Tests to validate setDataNascimento
	@SuppressWarnings("deprecation")
	@Test
	public void testSetDataNascimentoSuccess() {

		dataNascimento.setDate(2);
		dataNascimento.setMonth(10);
		dataNascimento.setYear(2017);
		col1.setDataNascimento(dataNascimento);
		Date result = col1.getDataNascimento();

		assertEquals(dataNascimento, result);
	}

	//Tests to validate method addEndereco
	@Test
	public void testAddEnderecoTrue() {

		EnderecoPostal e = new EnderecoPostal();
		e.setPais("Portugal");

		assertTrue(col1.addEndereco(e));
		}

	@Test
	public void testAddEnderecoFalseRepeatedAddress() {

		EnderecoPostal e = new EnderecoPostal();
		e.setPais("Espanha");
		col1.addEndereco(e);

		assertFalse(col1.addEndereco(e));
		}

	//Tests to validate method removeEndereco
	@Test
	public void testRemoveEnderecoTrue() {

		EnderecoPostal e = new EnderecoPostal();
		e.setPais("Portugal");
		col1.addEndereco(e);

		assertTrue(col1.removeEndereco(e));
		}

	@Test
	public void testRemoveEnderecoFalseNotPresent() {

		EnderecoPostal e = new EnderecoPostal();
		e.setPais("Espanha");

		assertFalse(col1.removeEndereco(e));
		}

	//Tests to validate method equals
	@Test
	public void testEqualsObjectSuccess() {

		col2.setNumContribuinte(numContribuinte);
		assertTrue(col1.equals(col2));
	}

	@Test
	public void testEqualsObjectFalse() {

		col2.setNumContribuinte("234546950");
		assertFalse(col1.equals(col2));
	}

	//Tests to validate method addTarefa
	@Test
	public void testAddTarefaSuccess() {

		boolean result = col1.addTarefa(tarefa1);

		assertTrue(result);
	}

	//Tests to validate method removeTarefa
	@Test
	public void testRemoveTarefaSuccess() {

		col1.addTarefa(tarefa1);
		boolean result = col1.removeTarefa(tarefa1);

		assertTrue(result);
	}

	@Test
	public void testRemoveTarefaFailureNotInList() {

		col1.addTarefa(tarefa2);
		boolean result = col1.removeTarefa(tarefa1);

		assertFalse(result);
	}

	@Test
	public void testRemoveTarefaFailureEmptyList() {

		boolean result = col1.removeTarefa(tarefa1);

		assertFalse(result);
	}

	//Tests to validate method marcarTarefaComoConcluida
	@Test
	public void testMarcarTarefaComoConcluidaSuccess() {

		col1.addTarefa(tarefa1);
		boolean result = col1.marcarTarefaComoConcluida(tarefa1);

		assertTrue(result);
	}

	@Test
	public void testMarcarTarefaComoConcluidaFailureNotInListTarefasPendentes() {

		col1.addTarefa(tarefa1);
		boolean result = col1.marcarTarefaComoConcluida(tarefa2);

		assertFalse(result);
	}
}

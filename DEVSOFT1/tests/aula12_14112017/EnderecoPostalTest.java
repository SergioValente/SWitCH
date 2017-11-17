package aula12_14112017;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EnderecoPostalTest {

	EnderecoPostal enderecoTest = new EnderecoPostal();
	EnderecoPostal enderecoTest2 = new EnderecoPostal();

	@Test
	public void testEnderecoPostal() {

		String nomeRua = "Beco do Java, 101";
		String codigoPostal = "4000 - 225";
		String localidade = "Porto";
		String pais = "Portugal";

		EnderecoPostal result = new EnderecoPostal (nomeRua, codigoPostal, localidade, pais);

		enderecoTest.setNomeRua(nomeRua);
		enderecoTest.setCodigoPostal(codigoPostal);
		enderecoTest.setLocalidade(localidade);
		enderecoTest.setPais(pais);

		assertTrue(result.equals(enderecoTest));
	}

	//Tests to validate method setRua
	@Test
	public void testSetNomeRuaSuccess() {

		String nomeRua = "Beco do Java, 101";
		enderecoTest.setNomeRua(nomeRua);
		String result = enderecoTest.getNomeRua();

		assertEquals(nomeRua, result);
	}

	@Test(expected = Exception.class)
	public void testSetNomeRuaEmptyString() {

		String nomeRua = "";
		enderecoTest.setNomeRua(nomeRua);
	}

	//Tests to validate method setCodigoPostal
	@Test
	public void testSetCodigoPostalSuccess() {

		String codigoPostal = "4000 - 225";
		enderecoTest.setCodigoPostal(codigoPostal);
		String result = enderecoTest.getCodigoPostal();

		assertEquals(codigoPostal, result);
	}

	@Test(expected = Exception.class)
	public void testSetCodigoPostalEmptyString() {

		String codigoPostal = "";
		enderecoTest.setCodigoPostal(codigoPostal);
	}

	//Tests to validate method setLocalidade
	@Test
	public void testSetLocalidadeSuccess() {

		String localidade = "Porto";
		enderecoTest.setLocalidade(localidade);
		String result = enderecoTest.getLocalidade();

		assertEquals(localidade, result);
	}

	@Test(expected = Exception.class)
	public void testSetLocalidadeEmptyString() {

		String localidade = "";
		enderecoTest.setLocalidade(localidade);
	}

	//Tests to validate method setPais
	@Test
	public void testSetPaisSuccess() {

		String pais = "Portugal";
		enderecoTest.setPais(pais);
		String result = enderecoTest.getPais();

		assertEquals(pais, result);
	}

	@Test(expected = Exception.class)
	public void testSetPaisEmptyString() {

		String pais = "";
		enderecoTest.setPais(pais);
	}

	//Tests to validate method equals
	@Test
	public void testEqualsObjectTrue() {

		String nomeRua = "Beco do Java, 101";
		String codigoPostal = "4000 - 225";
		enderecoTest.setNomeRua(nomeRua);
		enderecoTest.setCodigoPostal(codigoPostal);
		enderecoTest2.setNomeRua(nomeRua);
		enderecoTest2.setCodigoPostal(codigoPostal);

		assertTrue(enderecoTest.equals(enderecoTest2));
	}

	@Test
	public void testEqualsObjectFalse() {

		String nomeRua = "Beco do Java, 101";
		String nomeRua2 = "Beco do Java, 102";
		String codigoPostal = "4000 - 225";
		enderecoTest.setNomeRua(nomeRua);
		enderecoTest.setCodigoPostal(codigoPostal);
		enderecoTest2.setNomeRua(nomeRua2);
		enderecoTest2.setCodigoPostal(codigoPostal);

		assertFalse(enderecoTest.equals(enderecoTest2));
	}
}

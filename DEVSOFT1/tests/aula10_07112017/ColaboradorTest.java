package aula10_07112017;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ColaboradorTest {

	//Test to validate constructor
	@Test
	public void testPerson() {
		String name = "Quim";
		String phoneNumber = "9345623290";

		Colaborador result = new Colaborador(name, phoneNumber);

		assertTrue(result instanceof Colaborador);
	}

	//Test to validate identical phone books
	@Test
	public void testPersonIdenticalPhoneBooks() {

		Colaborador p1 = new Colaborador("Quim", "9345623290");
		Colaborador p2 = new Colaborador("Zé", "942928721");
		Colaborador p3 = new Colaborador("Manuel", "234567890");
		p1.getPhoneBook().add(p1);
		p2.getPhoneBook().add(p1);
		p1.getPhoneBook().add(p3);
		p2.getPhoneBook().add(p3);

		assertEquals(p1.getPhoneBook(), p2.getPhoneBook());
	}

	//Tests to validate method nameExists
	@Test
	public void testNameExistsTrue() {

		String name = "Manuel";
		Colaborador testPerson = new Colaborador("Manuel Joaquim", "953452345");
		boolean result = testPerson.nameExists(name);

		assertTrue(result);
	}

	@Test
	public void testNameExistsFalse() {

		String name = "Daniel";
		Colaborador testPerson = new Colaborador("Manuel Joaquim", "953452345");
		boolean result = testPerson.nameExists(name);

		assertFalse(result);
	}

	@Test
	public void testNameExistsEmptyCompareString() {

		String name = "";
		Colaborador testPerson = new Colaborador("Manuel Joaquim", "953452345");
		boolean result = testPerson.nameExists(name);

		assertFalse(result);
	}
}

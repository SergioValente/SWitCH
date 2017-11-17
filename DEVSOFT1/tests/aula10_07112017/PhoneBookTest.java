package aula10_07112017;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class PhoneBookTest {

	Colaborador c1 = new Colaborador("Sergio", "963456789");
	Colaborador c2 = new Colaborador("Daniel", "234945678");
	Colaborador c3 = new Colaborador("Antonio", "9123456734");
	Colaborador c4 = new Colaborador("Manuel Sergio", "9723456734");
	Colaborador c5 = new Colaborador("Manuel Sergio Oliveira", "9733456734");
	PhoneBook phoneBookTest = new PhoneBook();
	PhoneBook phoneBookTest2 = new PhoneBook();

	// Tests to validate method add
	@Test
	public void testAddSuccess() {

		boolean result = phoneBookTest.add(c1);

		assertTrue(result);
	}

	@Test
	public void testAddFailureAlreadyInThePhoneBook() {

		phoneBookTest2.add(c2);

		boolean result = phoneBookTest2.add(c2);

		assertFalse(result);
	}

	// Tests to validate method remove
	@Test
	public void testRemoveSuccess() {

		phoneBookTest2.add(c2);
		boolean result = phoneBookTest2.remove(c2);

		assertTrue(result);
	}

	@Test
	public void testRemoveFailureEmptyList() {

		boolean result = phoneBookTest.remove(c3);

		assertFalse(result);
	}

	@Test
	public void testRemoveFailureContactDoesNotExist() {

		phoneBookTest.add(c2);
		boolean result = phoneBookTest.remove(c3);

		assertFalse(result);
	}

	// Tests to validate method search
	@Test
	public void testSearchSuccess() {

		String testString = "Sergio";

		List<Colaborador> expResult = new ArrayList<>();
		expResult.add(c1);
		expResult.add(c4);

		phoneBookTest.add(c1);
		phoneBookTest.add(c2);
		phoneBookTest.add(c3);
		phoneBookTest.add(c4);
		List<Colaborador> result = new ArrayList<>();
		result = phoneBookTest.search(testString);

		assertEquals(expResult, result);
	}

	@Test
	public void testSearchSuccessMixedCapitals() {

		String testString = "SeRgIO";

		List<Colaborador> expResult = new ArrayList<>();
		expResult.add(c1);
		expResult.add(c4);

		phoneBookTest.add(c1);
		phoneBookTest.add(c2);
		phoneBookTest.add(c3);
		phoneBookTest.add(c4);
		List<Colaborador> result = new ArrayList<>();
		result = phoneBookTest.search(testString);

		assertEquals(expResult, result);
	}

	@Test
	public void testSearchSuccessNotConsecutiveNames() {

		String testString = "Manuel Oliveira";

		List<Colaborador> expResult = new ArrayList<>();

		expResult.add(c5);
		phoneBookTest.add(c1);
		phoneBookTest.add(c2);
		phoneBookTest.add(c3);
		phoneBookTest.add(c4);
		phoneBookTest.add(c5);

		List<Colaborador> result = phoneBookTest.search(testString);

		assertEquals(expResult, result);
	}

	@Test
	public void testSearchFailure() {

		String testString = "Lisa";
		List<Colaborador> expResult = new ArrayList<>(); // Empty arrayList!
		phoneBookTest.add(c1);
		phoneBookTest.add(c2);
		phoneBookTest.add(c3);
		List<Colaborador> result = new ArrayList<>();
		result = phoneBookTest.search(testString);

		assertEquals(expResult, result);
	}

	// Tests to validate method existsInPhoneBook
	@Test
	public void testExistsInPhoneBookSuccess() {

		phoneBookTest2.add(c2);
		boolean result = phoneBookTest2.existsInPhoneBook(c2);

		assertTrue(result);
	}

	@Test
	public void testExistsInPhoneBookFailureNotInPhoneBook() {

		phoneBookTest2.add(c2);
		boolean result = phoneBookTest2.existsInPhoneBook(c3);

		assertFalse(result);
	}

	@Test
	public void testExistsInPhoneBookFailureEmpty() {

		boolean result = phoneBookTest2.existsInPhoneBook(c3);

		assertFalse(result);
	}

	// Tests to validate method nameExistsInPhoneBook

	@Test
	public void testNameExistsInPhoneBookSuccess() {

		String testString = "Manuel Sergio";
		phoneBookTest.add(c1);
		phoneBookTest.add(c2);
		phoneBookTest.add(c3);
		phoneBookTest.add(c4);
		phoneBookTest.add(c5);
		boolean result = phoneBookTest.nameExistsInPhoneBook(testString);

		assertTrue(result);
	}

	@Test
	public void testNameExistsInPhoneBookFailureNotExactMatch() {

		String testString = "Manuel";
		phoneBookTest.add(c1);
		phoneBookTest.add(c2);
		phoneBookTest.add(c3);
		phoneBookTest.add(c4);
		phoneBookTest.add(c5);
		boolean result = phoneBookTest.nameExistsInPhoneBook(testString);

		assertFalse(result);
	}

	@Test
	public void testNameExistsInPhoneBookFailureEmptyPhoneBook() {

		String testString = "Manuel";

		boolean result = phoneBookTest.nameExistsInPhoneBook(testString);

		assertFalse(result);
	}

	@Test
	public void testGetCommonContactsSuccess() {

		phoneBookTest.add(c1);
		phoneBookTest.add(c2);
		phoneBookTest.add(c3);
		phoneBookTest.add(c4);

		phoneBookTest2.add(c1);
		phoneBookTest2.add(c2);
		phoneBookTest2.add(c5);

		List<Colaborador> expResult = new ArrayList<>();
		expResult.add(c1);
		expResult.add(c2);

		List<Colaborador> result = phoneBookTest.getCommonContacts(phoneBookTest2);

		assertEquals(expResult, result);
	}
	
	@Test
	public void testGetCommonContactsEmptyPhoneBook() {

		phoneBookTest.add(c1);
		phoneBookTest.add(c2);
		phoneBookTest.add(c3);
		phoneBookTest.add(c4);

		List<Colaborador> expResult = new ArrayList<>();

		List<Colaborador> result = phoneBookTest.getCommonContacts(phoneBookTest2);

		assertEquals(expResult, result);
	}
}

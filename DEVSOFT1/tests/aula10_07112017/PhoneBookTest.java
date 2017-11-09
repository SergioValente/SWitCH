package aula10_07112017;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class PhoneBookTest {

	Person c1 = new Person("Sergio", "963456789");
	Person c2 = new Person("Daniel", "234945678");
	Person c3 = new Person("Antonio", "9123456734");
	Person c4 = new Person("Manuel Sergio", "9723456734");
	Person c5 = new Person("Manuel Sergio Oliveira", "9733456734");
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

		List<Person> expResult = new ArrayList<>();
		expResult.add(c1);
		expResult.add(c4);

		phoneBookTest.add(c1);
		phoneBookTest.add(c2);
		phoneBookTest.add(c3);
		phoneBookTest.add(c4);
		List<Person> result = new ArrayList<>();
		result = phoneBookTest.search(testString);

		assertEquals(expResult, result);
	}

	@Test
	public void testSearchSuccessMixedCapitals() {

		String testString = "SeRgIO";

		List<Person> expResult = new ArrayList<>();
		expResult.add(c1);
		expResult.add(c4);

		phoneBookTest.add(c1);
		phoneBookTest.add(c2);
		phoneBookTest.add(c3);
		phoneBookTest.add(c4);
		List<Person> result = new ArrayList<>();
		result = phoneBookTest.search(testString);

		assertEquals(expResult, result);
	}

	@Test
	public void testSearchSuccessNotConsecutiveNames() {

		String testString = "Manuel Oliveira";

		List<Person> expResult = new ArrayList<>();

		expResult.add(c5);
		phoneBookTest.add(c1);
		phoneBookTest.add(c2);
		phoneBookTest.add(c3);
		phoneBookTest.add(c4);
		phoneBookTest.add(c5);

		List<Person> result = phoneBookTest.search(testString);

		assertEquals(expResult, result);
	}

	@Test
	public void testSearchFailure() {

		String testString = "Lisa";
		List<Person> expResult = new ArrayList<>(); // Empty arrayList!
		phoneBookTest.add(c1);
		phoneBookTest.add(c2);
		phoneBookTest.add(c3);
		List<Person> result = new ArrayList<>();
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

		List<Person> expResult = new ArrayList<>();
		expResult.add(c1);
		expResult.add(c2);

		List<Person> result = phoneBookTest.getCommonContacts(phoneBookTest2);

		assertEquals(expResult, result);
	}
	
	@Test
	public void testGetCommonContactsEmptyPhoneBook() {

		phoneBookTest.add(c1);
		phoneBookTest.add(c2);
		phoneBookTest.add(c3);
		phoneBookTest.add(c4);

		List<Person> expResult = new ArrayList<>();

		List<Person> result = phoneBookTest.getCommonContacts(phoneBookTest2);

		assertEquals(expResult, result);
	}
}

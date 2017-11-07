package aula10_07112017;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class PhoneBookTest {

	Contact c1 = new Contact("Sergio", "963456789");
	Contact c2 = new Contact("Daniel", "234945678");
	Contact c3 = new Contact("Antonio", "9123456734");
	Contact c4 = new Contact("Manuel Sergio", "9723456734");
	Contact c5 = new Contact("Manuel Sergio Oliveira", "9733456734");
	PhoneBook phoneBookTest = new PhoneBook();
	PhoneBook phoneBookTest2 = new PhoneBook();
	
	
	//Tests to validate method add
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

	//Tests to validate method remove
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

	//Tests to validate method search
	@Test
	public void testSearchSuccess() {
		
		String testString = "Sergio";
		
		List<Contact> expResult = new ArrayList<>();
		expResult.add(c1);
		expResult.add(c4);
		
		phoneBookTest.add(c1);
		phoneBookTest.add(c2);
		phoneBookTest.add(c3);
		phoneBookTest.add(c4);
		List<Contact> result = new ArrayList<>();
		result = phoneBookTest.search(testString);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public void testSearchSuccessMixedCapitals() {
		
		String testString = "SeRgIO";
		
		List<Contact> expResult = new ArrayList<>();
		expResult.add(c1);
		expResult.add(c4);
		
		phoneBookTest.add(c1);
		phoneBookTest.add(c2);
		phoneBookTest.add(c3);
		phoneBookTest.add(c4);
		List<Contact> result = new ArrayList<>();
		result = phoneBookTest.search(testString);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public void testSearchSuccessNotConsecutiveNames() {
		
		String testString = "Manuel Oliveira";
		
		List<Contact> expResult = new ArrayList<>();

		expResult.add(c5);
		phoneBookTest.add(c1);
		phoneBookTest.add(c2);
		phoneBookTest.add(c3);
		phoneBookTest.add(c4);
		phoneBookTest.add(c5);
		
		List<Contact> result = phoneBookTest.search(testString);
		
		assertEquals(expResult, result);
	}
	
	@Test
	public void testSearchFailure() {
		
		String testString = "Lisa";
		List<Contact> expResult = new ArrayList<>(); //Empty arrayList!
		phoneBookTest.add(c1);
		phoneBookTest.add(c2);
		phoneBookTest.add(c3);
		List<Contact> result = new ArrayList<>();
		result = phoneBookTest.search(testString);
		
		assertEquals(expResult, result);
	}

	//Tests to validate method existsInPhoneBook
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
	
	//Tests to validate method nameExistsInPhoneBook

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
}

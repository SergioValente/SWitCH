package aula10_07112017;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	public void testPerson() {
		String name = "Quim";
		String phoneNumber = "9345623290";
		
		Person result = new Person(name, phoneNumber);
	
		assertTrue(result instanceof Person);
	}
	
	@Test
	public void testPersonIdenticalPhoneBooks() {
		
		Person p1 = new Person("Quim", "9345623290");
		Person p2 = new Person("Zé", "942928721");
		Person p3 = new Person("Manuel", "234567890");
		p1.getPhoneBook().add(p1);
		p2.getPhoneBook().add(p1);
		p1.getPhoneBook().add(p3);
		p2.getPhoneBook().add(p3);
		
		assertEquals(p1.getPhoneBook(), p2.getPhoneBook());
	}

	@Test
	public void testNameExistsTrue() {
		
		String name = "Manuel";
		Person testPerson = new Person("Manuel Joaquim", "953452345");
		boolean result = testPerson.nameExists(name);
		
		assertTrue(result);
	}
	
	@Test
	public void testNameExistsFalse() {
		
		String name = "Daniel";
		Person testPerson = new Person("Manuel Joaquim", "953452345");
		boolean result = testPerson.nameExists(name);
		
		assertFalse(result);
	}

	@Test
	public void testNameExistsEmptyCompareString() {
		
		String name = "";
		Person testPerson = new Person("Manuel Joaquim", "953452345");
		boolean result = testPerson.nameExists(name);
		
		assertFalse(result);
	}
}

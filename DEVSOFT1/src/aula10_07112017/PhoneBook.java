package aula10_07112017;

import java.util.*;

public class PhoneBook {

	private List<Person> myPhoneBook = new ArrayList<>();

	/**
	 * Adds a Contact to myPhoneBook. Doesn't allow repeated phone numbers.
	 * @param c Contact to be added
	 * @return True if adding was successful, false otherwise.
	 */
	public boolean add(Person c) {

		if (this.existsInPhoneBook(c))
			return false;
		return (this.myPhoneBook.add(c));

	}

	/**
	 * Removes a contact from myPhoneBook. Checks for empty phone book and non existence of contact. 
	 * @param c Contact to be removed.
	 * @return True if successfully removed, false if not.
	 */
	public boolean remove(Person c) {

		if ((this.myPhoneBook.isEmpty()) || (!this.existsInPhoneBook(c)))
			return false;
		else {
			this.myPhoneBook.remove(c);
			return true;
		}
	}

	/**
	 * Searches myPhoneBook for name given.
	 * @param name Given parameter to search.
	 * @return An ArrayList containing all matches.
	 */
	public List<Person> search(String name) {

		List<Person> namesFound = new ArrayList<>();

		for (Person contact : myPhoneBook) {
			if (contact.nameExists(name)) {
				namesFound.add(contact);
			}
		}
		return namesFound;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((myPhoneBook == null) ? 0 : myPhoneBook.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneBook other = (PhoneBook) obj;
		if (myPhoneBook == null) {
			if (other.myPhoneBook != null)
				return false;
		} else if (!myPhoneBook.equals(other.myPhoneBook))
			return false;
		return true;
	}

	/**
	 * Checks if a contact exists in myPhoneBook. Uses the overridden equals method from class Contact.
	 * @param c Contact to be checked.
	 * @return True if contact exists in myPhoneBook, false otherwise.
	 */
	public boolean existsInPhoneBook(Person c) {

		if (myPhoneBook.isEmpty()) return false;
		for (Person cont : this.myPhoneBook) {
			if (cont.equals(c))
				return true;
		}
		return false;
	}

	/**
	 * Checks if a contact exists in myPhoneBook. Uses name as search parameter. Name has to be an exact match.
	 * @param name Parameter to be searched.
	 * @return True if contact exists in myPhoneBook, false otherwise.
	 */
	public boolean nameExistsInPhoneBook(String name) {

		if (myPhoneBook.isEmpty()) return false;
		for (Person cont : this.myPhoneBook) {
			if (cont.getName().equals(name))
				return true;
		}
		return false;
	}

	//toString
	@Override
	public String toString() {

		String res = "";
		// System.out.println("");
		for (Person elem : myPhoneBook) {
			res = res + elem.getName() + "    " + elem.getPhoneNumber() + "\n";
		}
		return res;
	}

	/**
	 * Checks for common persons in two phonebooks.
	 * @param b The other phonebook to compare this to.
	 * @return A list with persons in common.
	 */
	public List<Person> getCommonContacts(PhoneBook b) {
		
		List<Person> contactsInCommon = new ArrayList<>();
		
		for(Person a : this.myPhoneBook) {
			for(Person c : b.myPhoneBook) {
				if (a.equals(c)) contactsInCommon.add(a);
			}
		}
		return contactsInCommon;
	}
 }

package aula10_07112017;

import java.util.*;

public class PhoneBook {

	private List<Contact> myPhoneBook = new ArrayList<>();

	/**
	 * Adds a Contact to myPhoneBook. Doesn't allow repeated phone numbers.
	 * @param c Contact to be added
	 * @return True if adding was successful, false otherwise.
	 */
	public boolean add(Contact c) {

		if (this.existsInPhoneBook(c))
			return false;
		return (this.myPhoneBook.add(c));

	}

	/**
	 * Removes a contact from myPhoneBook. Checks for empty phone book and non existence of contact. 
	 * @param c Contact to be removed.
	 * @return True if successfully removed, false if not.
	 */
	public boolean remove(Contact c) {

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
	public List<Contact> search(String name) {

		List<Contact> namesFound = new ArrayList<>();

		for (Contact contact : this.myPhoneBook) {
			if (contact.nameExists(name)) {
				namesFound.add(contact);
			}
		}
		return namesFound;
	}
	
	/**
	 * Checks if a contact exists in myPhoneBook. Uses the overridden equals method from class Contact.
	 * @param c Contact to be checked.
	 * @return True if contact exists in myPhoneBook, false otherwise.
	 */
	public boolean existsInPhoneBook(Contact c) {

		if (myPhoneBook.isEmpty()) return false;
		for (Contact cont : this.myPhoneBook) {
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
		for (Contact cont : this.myPhoneBook) {
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
		for (Contact elem : myPhoneBook) {
			res = res + elem.getName() + "    " + elem.getPhoneNumber() + "\n";
		}
		return res;
	}

}

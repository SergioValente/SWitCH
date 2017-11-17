package aula12_14112017;

import java.util.ArrayList;
import java.util.List;

public class Grupo {

	private List<Colaborador> grupo = new ArrayList<>();

	/**
	 * Adds a Contact to grupo. Doesn't allow repeated phone numbers.
	 * @param c Contact to be added
	 * @return True if adding was successful, false otherwise.
	 */
	public boolean addColaborador(Colaborador c) {

		if (this.existsInGroup(c)) {
			return false;
		}
		return (grupo.add(c));

	}

	/**
	 * Removes a contact from grupo. Checks for empty phone book and non existence of contact.
	 * @param c Contact to be removed.
	 * @return True if successfully removed, false if not.
	 */
	public boolean removeColaborador(Colaborador c) {

		if ((grupo.isEmpty()) || (!this.existsInGroup(c))) {
			return false;
		} else {
			grupo.remove(c);
			return true;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Grupo other = (Grupo) obj;
		if (grupo == null) {
			if (other.grupo != null) {
				return false;
			}
		} else if (!grupo.equals(other.grupo)) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if a contact exists in grupo. Uses the overridden equals method from class Contact.
	 * @param c Contact to be checked.
	 * @return True if contact exists in myPhoneBook, false otherwise.
	 */
	public boolean existsInGroup(Colaborador c) {

		if (grupo.isEmpty()) {
			return false;
		}
		for (Colaborador cont : grupo) {
			if (cont.equals(c)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if a contact exists in grupo. Uses name as search parameter. Name has to be an exact match.
	 * @param name Parameter to be searched.
	 * @return True if contact exists in myPhoneBook, false otherwise.
	 */
	public boolean nameExistsInGroup(String name) {

		if (grupo.isEmpty()) {
			return false;
		}
		for (Colaborador cont : grupo) {
			if (cont.getNome().equals(name)) {
				return true;
			}
		}
		return false;
	}

	//toString
	@Override
	public String toString() {

		String res = "";
		// System.out.println("");
		for (Colaborador elem : grupo) {
			res = res + elem.getNome() + "    " + elem.getNumTelefone() + "\n";
		}
		return res;
	}

	/**
	 * Checks for common colaboradores in two grupo objects.
	 * @param b The other grupo to compare this to.
	 * @return A list with persons in common.
	 */
	public List<Colaborador> getCommonContacts(Grupo b) {

		List<Colaborador> contactsInCommon = new ArrayList<>();

		for(Colaborador a : grupo) {
			for(Colaborador c : b.grupo) {
				if (a.equals(c)) {
					contactsInCommon.add(a);
				}
			}
		}
		return contactsInCommon;
	}
 }

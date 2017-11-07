package aula10_07112017;

public class Contact {

	private String name;
	private String phoneNumber;
	
	//Constructor
	public Contact (String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	//hashCode, equals and toString
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	
	/**
	 * Checks if name exists. Works for not consecutive names too.
	 * @param name Name to be tested.
	 * @return True if name exists, false otherwise.
	 */
	public boolean nameExists(String name) {
		
		name = name.toLowerCase();
		String[] nameSplitted = name.split(" ");
		
		for(String eachName : nameSplitted) {
			if(!this.name.toLowerCase().contains(eachName)) return false;
		}
		return true;	
	}
}
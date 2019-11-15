package org.faac.ebb.training.model;

public class User {
	private Long id;
	private String firstName;
	private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		bf.append("{").append(System.lineSeparator())
		.append("\"id\":").append(id).append(",").append(System.lineSeparator())
		.append("\"firstName\": \"").append(firstName).append("\",").append(System.lineSeparator())
		.append("\"lastName\":\"").append(lastName).append("\"").append(System.lineSeparator())
		.append("}");
		return bf.toString();
	}
}

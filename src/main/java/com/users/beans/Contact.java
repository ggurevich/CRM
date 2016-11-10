package com.users.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//creates a tale for contacts
@Entity
@Table(name = "contacts")
public class Contact {
	// creates id for each user in contacts
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private long userId;

	private String firstName;
	private String lastName;
	// unique properties for each contact
	@Column(unique = true)
	private String email;
	private String phoneNumber;
	private boolean active;

	// generic contact
	protected Contact() {
	}

	public Contact(long userId) {
		this.userId = userId;

	}

	// constructor for contact with properties
	public Contact(long userId, String firstName, String lastName, String email, String phoneNumber, String password,
			boolean active) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.active = active;
	}

	// creates string with all info
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", active=" + active + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}

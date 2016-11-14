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

	private String twitterHandle;
	private String facebookUrl;

	// generic contact
	protected Contact() {
	}

	public Contact(long userId) {
		this.userId = userId;
		this.active = true;

	}

	// constructor for contact with properties
	public Contact(long userId, String firstName, String lastName, String email, String phoneNumber, String password,
			boolean active, String twitterHandle, String facebookUrl) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.active = active;
		this.twitterHandle = twitterHandle;
		this.facebookUrl = facebookUrl;
	}

	// creates string with all info
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", active=" + active + ", twitterHandle=" + twitterHandle
				+ ", facebookUrl=" + facebookUrl + "]";
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

	public String getTwitterHandle() {
		return twitterHandle;
	}

	public void setTwitterHandle(String twitterHandle) {
		this.twitterHandle = twitterHandle;
	}

	public String getFacebookUrl() {
		return facebookUrl;
	}

	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

}

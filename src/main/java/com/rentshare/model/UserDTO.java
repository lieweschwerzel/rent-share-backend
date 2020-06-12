package com.rentshare.model;

import java.time.LocalDateTime;

public class UserDTO {

	private String username;
	private String password;
	private String zipcode;
	private String streetName;
	private int houseNumber;
	private LocalDateTime createdOn;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public LocalDateTime getCreatedOn() { return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) { this.createdOn = createdOn;
	}
}
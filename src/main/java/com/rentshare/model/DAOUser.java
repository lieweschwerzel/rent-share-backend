package com.rentshare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column
	private String username;

	@Column
	@JsonIgnore
	private String password;

	@Column(name = "zipcode")
	private String zipcode;

	@Column(name = "streetName")
	private String streetName;

	@Column(name = "houseNumber")
	private int houseNumber;

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

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

	public String getZipcode() { return zipcode; }

	public void setZipcode(String zipcode) { this.zipcode = zipcode; }

	public String getStreetName() { return streetName; }

	public void setStreetName(String streetName) { this.streetName = streetName; }

	public int getHouseNumber() { return houseNumber; }

	public void setHouseNumber(int houseNumber) { this.houseNumber = houseNumber; }
}
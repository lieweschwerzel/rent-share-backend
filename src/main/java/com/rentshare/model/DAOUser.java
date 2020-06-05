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

	@Column(name = "latitude")
	private String latitude;

	@Column(name = "longitude")
	private String longitude;

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

	public String getLatitude() { return latitude; }

	public void setLatitude(String latitude) { this.latitude = latitude; }

	public String getLongitude() { return longitude; }

	public void setLongitude(String longitude) { this.longitude = longitude; }
}
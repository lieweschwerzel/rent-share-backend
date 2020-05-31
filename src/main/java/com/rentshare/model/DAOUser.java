package com.rentshare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private String password;
//	@OneToMany(targetEntity = Advert.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "ua_fk", referencedColumnName = "id" )
//	private List<Advert> adverts;

	public DAOUser() {
	}

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

}
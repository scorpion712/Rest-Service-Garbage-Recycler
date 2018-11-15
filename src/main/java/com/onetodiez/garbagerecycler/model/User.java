package com.onetodiez.garbagerecycler.model;
/**
 * @author: Oneto, Fernando
 * @author: Diez, Lautaro
 */

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.OneToMany; 
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class User { 
	@Size(min=1, max=50)
	@Column(name = "firstname", nullable = false)
	private String firstname;

	@Size(min=1, max=50)
	@Column(name = "lastname", nullable = false)
	private String lastname;
	
	@Size(min=1, max=50)
	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Size(min=1, max=255)
	@Column(name = "address", nullable = true)
	private String address;

	@Size(min=1, max=255)
	@Column(name = "mail", nullable = true)
	private String mail;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Defining OneToMany relationship between User and UserRecycling entities.
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserRecycling> userRecycling;
	
	public Set<UserRecycling> getUserRecycling() {
		 return userRecycling;
	 }
	 
	 public void setUserRecycling(Set<UserRecycling> userRecyclingList) {
		 this.userRecycling = userRecyclingList;
	 }
	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
}

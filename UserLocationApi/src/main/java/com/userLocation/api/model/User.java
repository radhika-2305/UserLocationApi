package com.userLocation.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "records")
@Table(name = "records")
public class User {
	
	public User(long id, String name, String postcode) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.postcode = postcode;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "postcode")
	private String postcode;
	
	
	public long getId() {
		return id;  
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	

}

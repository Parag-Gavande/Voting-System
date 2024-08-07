package com.votingSystem.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty(message = "Name cannot be Empty")
	@Size(min = 3,max = 15, message = "Name should have 3 to 15 character")
	@Pattern(regexp = "^{a-zA-Z}+$",message = "only character allowed")
	private String name;
	private String address;
	private Date dob;
	private String gender;
	private String username;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public Admin(int id,
			@NotEmpty(message = "Name cannot be Empty") @Size(min = 3, max = 15, message = "Name should have 4 to 8 character") @Pattern(regexp = "^{a-zA-Z}+$", message = "only character allowed") String name,
			String address, Date dob, String gender, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}
	public Admin() {
		super();
	}
}

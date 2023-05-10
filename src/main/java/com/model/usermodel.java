package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class usermodel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name,address,email,password;
	private Long contact;
	public usermodel(int id, String name, String address, String email, String password, Long contact) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.password = password;
		this.contact = contact;
	}
	public usermodel() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "usermodel [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", password="
				+ password + ", contact=" + contact + "]";
	}
	
}

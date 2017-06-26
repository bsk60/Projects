package com.roadtex.model;

import java.io.Serializable;

public class Customer implements Serializable {
	private int id;
	private String clientName;
	private String contactName;
	private String phone;
	private String email;
	private String offer="$";
	private String isCustomer;
	private Address address;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Customer(int id, String clientName, String contactName, String phone, String email, String offer,
			String isCustomer, Address address) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.contactName = contactName;
		this.phone = phone;
		this.email = email;
		this.offer = offer;
		this.isCustomer = isCustomer;
		this.address = address;
	}


	public Customer(String clientName, String contactName, String phone, String email, String offer, String isCustomer,
			Address address) {
		super();
		this.clientName = clientName;
		this.contactName = contactName;
		this.phone = phone;
		this.email = email;
		this.offer = offer;
		this.isCustomer = isCustomer;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	
	public String getIsCustomer() {
		return isCustomer;
	}
	public void setIsCustomer(String isCustomer) {
		this.isCustomer = isCustomer;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}

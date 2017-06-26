package com.roadtex.model;

import java.io.Serializable;

public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int addressID;
	private String street;
	private String city;
	private String state;
	private String zip;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Address(int addressID, String street, String city, String state, String zip) {
		super();
		this.addressID = addressID;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}



	public Address(String street, String city, String state, String zip) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public int getAddressID() {
		return addressID;
	}
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	

}

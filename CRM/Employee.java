package com.roadtex.model;

import java.io.Serializable;

public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int empID;
	private String fname;
	private String lname;
	private String email;
	private String pass;
	private Role role;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String fname, String lname, String email, String pass, Role role) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
		this.role = role;
	}

	public Employee(int empID, String fname, String lname, String email, String pass, Role role) {
		super();
		this.empID = empID;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
		this.role = role;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", role="
				+ role + "]";
	}
	
	
	
}

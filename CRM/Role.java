package com.roadtex.model;

import java.io.Serializable;

public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int roleID;
	private String name;
	private String roleDesc;
	
	public Role() {
		super();
	}
	
	public Role(int roleID, String name, String roleDesc) {
		super();
		this.roleID = roleID;
		this.name = name;
		this.roleDesc = roleDesc;
	}

	public Role(String name, String roleDesc) {
		super();
		this.name = name;
		this.roleDesc = roleDesc;
	}


	
	public int getRoleID() {
		return roleID;
	}


	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", name=" + name + ", roleDesc=" + roleDesc + "]";
	}
	
	
}

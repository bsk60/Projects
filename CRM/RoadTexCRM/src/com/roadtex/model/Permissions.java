package com.roadtex.model;

import java.io.Serializable;

public class Permissions implements Serializable {
	private int id;
	private Role role;
	//private boolean canEdit;
	//private boolean readOnly;
	//private boolean isEnable;
	//private boolean accountProfile;
	//private boolean cargoPic;
	//private boolean shipData;
	//private boolean revenue;
	private boolean addCustomer;
	private boolean changePass;
	private boolean adminSettings;
	private boolean users;
	private boolean userSettings;
	private boolean roles;
	private boolean rolesPermission;
	public Permissions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Permissions(Role role, boolean addCustomer, boolean changePass, boolean adminSettings, boolean users,
			boolean userSettings, boolean roles, boolean rolesPermission) {
		super();
		this.role = role;
		this.addCustomer = addCustomer;
		this.changePass = changePass;
		this.adminSettings = adminSettings;
		this.users = users;
		this.userSettings = userSettings;
		this.roles = roles;
		this.rolesPermission = rolesPermission;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public boolean isAddCustomer() {
		return addCustomer;
	}
	public void setAddCustomer(boolean addCustomer) {
		this.addCustomer = addCustomer;
	}
	public boolean isChangePass() {
		return changePass;
	}
	public void setChangePass(boolean changePass) {
		this.changePass = changePass;
	}
	public boolean isAdminSettings() {
		return adminSettings;
	}
	public void setAdminSettings(boolean adminSettings) {
		this.adminSettings = adminSettings;
	}
	public boolean isUsers() {
		return users;
	}
	public void setUsers(boolean users) {
		this.users = users;
	}
	public boolean isUserSettings() {
		return userSettings;
	}
	public void setUserSettings(boolean userSettings) {
		this.userSettings = userSettings;
	}
	public boolean isRoles() {
		return roles;
	}
	public void setRoles(boolean roles) {
		this.roles = roles;
	}
	public boolean isRolesPermission() {
		return rolesPermission;
	}
	public void setRolesPermission(boolean rolesPermission) {
		this.rolesPermission = rolesPermission;
	}
	
}

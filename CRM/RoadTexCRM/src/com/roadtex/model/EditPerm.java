package com.roadtex.model;

import java.io.Serializable;

public class EditPerm extends Permissions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditPerm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EditPerm(int roleID, boolean accountProfile, boolean cargoPic, boolean shipData, boolean revenue,
			boolean addCustomer, boolean changePass, boolean adminSettings, boolean users, boolean roles,
			boolean rolesPermission) {
		super(roleID, accountProfile, cargoPic, shipData, revenue, addCustomer, changePass, adminSettings, users, roles,
				rolesPermission);
		// TODO Auto-generated constructor stub
	}

}

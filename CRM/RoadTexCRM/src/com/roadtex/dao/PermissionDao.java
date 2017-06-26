package com.roadtex.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.roadtex.model.Customer;
import com.roadtex.model.Permissions;
import com.roadtex.util.AppUtil;

public class PermissionDao {

	public PermissionDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setPermissions(Permissions p){
		Session session = AppUtil.openSession();

		//System.out.println(role.getName());

		try {
			Transaction tx = session.getTransaction();
			tx.begin();
			session.save(p);
			tx.commit();
			System.out.println("Successfully added");
		} catch (Exception e) {
			System.out.println("Could not insert data.");
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	
	public List<Permissions> getListOfPermissions() {
		List<Permissions> list = new ArrayList<Permissions>();
		Session session = AppUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			list = session.createQuery("from Permissions").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		return list;
	}
	
	
}

package com.roadtex.dao;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.sql.Statement;

import com.roadtex.model.Role;
import com.roadtex.util.AppUtil;

public class RoleDao {

	public RoleDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addRole(Role role) {
		Session session = AppUtil.openSession();

		System.out.println(role.getName());

		try {
			Transaction tx = session.getTransaction();
			tx.begin();
			session.save(role);
			tx.commit();
			System.out.println("Successfully added");
		} catch (Exception e) {
			System.out.println("Could not insert data.");
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public Role getRoleByName(String name) {
		Session session = AppUtil.openSession();
		Transaction tx = null;
		Role role = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "FROM Role WHERE name = '" + name + "'";
			Query query = session.createQuery(hql);
			role = (Role) query.uniqueResult();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return role;
	}

	public List<Role> getListOfRoles() {
		List<Role> list = new ArrayList<Role>();
		Session session = AppUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			list = session.createQuery("from Role").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		return list;
	}

	public void updateRole(Role role) {
		Session session = AppUtil.openSession();

		try {
			Transaction tx = session.getTransaction();
			tx.begin();
			session.update(role);
			tx.commit();
			System.out.println("Successfully added");
		} catch (Exception e) {
			System.out.println("Could not insert data.");
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public boolean deleteRole(Role role) {
		Session session = AppUtil.openSession();

		try {
			Transaction tx = session.getTransaction();
			tx.begin();
			session.delete(role);
			tx.commit();
			System.out.println("Successfully deleted");
			return true;
		} catch (Exception ex) {
			return false;
		}

	}

}

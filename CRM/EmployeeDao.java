package com.roadtex.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.roadtex.model.Employee;
import com.roadtex.util.AppUtil;

public class EmployeeDao {

	public EmployeeDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean authenticateEmployee(String email, String password) {

		Employee emp = getUserByEmail(email);
		if (emp != null && emp.getEmail().equals(email) && emp.getPass().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public Employee getUserByEmail(String email) {
		Session session = AppUtil.openSession();
		Transaction tx = null;
		Employee emp = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "FROM Employee WHERE email = '" + email + "'";
			Query query = session.createQuery(hql);
			emp = (Employee) query.uniqueResult();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} 
		return emp;
	}

	public List<Employee> getListOfUsers() {
		Session session = AppUtil.openSession();
		List<Employee> list = new ArrayList<Employee>();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			list = session.createQuery("from Employee").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return list;

	}

	public void addUser(Employee emp) {
		Session session = AppUtil.openSession();

		try {
			Transaction tx = session.getTransaction();
			tx.begin();
			session.save(emp);
			tx.commit();
			System.out.println("Successfully added");
		} catch (Exception e) {
			System.out.println("Could not insert data.");
			e.printStackTrace();
		} 
	}

	public void updateUser(Employee emp) {
		Session session = AppUtil.openSession();

		try {
			Transaction tx = session.getTransaction();
			tx.begin();
			session.update(emp);
			tx.commit();
			System.out.println("Successfully added");
		} catch (Exception e) {
			System.out.println("Could not insert data.");
			e.printStackTrace();
		}

	}

	public void deleteUser(Employee emp) {
		Session session = AppUtil.openSession();

		try {
			Transaction tx = session.getTransaction();
			tx.begin();
			session.delete(emp);
			tx.commit();
			System.out.println("Successfully deleted");
		} catch (Exception e) {
			System.out.println("Could not deleted data.");
			e.printStackTrace();
		} 
	}

}

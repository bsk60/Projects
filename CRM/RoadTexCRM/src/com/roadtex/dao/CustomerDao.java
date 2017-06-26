package com.roadtex.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.roadtex.model.Address;
import com.roadtex.model.Customer;
import com.roadtex.model.Employee;
import com.roadtex.util.AppUtil;

public class CustomerDao {

	public void addClient(Address address, Customer cus) {
		Session session = AppUtil.openSession();

		// System.out.println(role.getName());

		try {
			Transaction tx = session.getTransaction();
			tx.begin();
			session.save(address);
			session.save(cus);
			tx.commit();
			System.out.println("Successfully added");
		} catch (Exception e) {
			System.out.println("Could not insert data.");
			e.printStackTrace();
		} 
	}
	
	public Customer getCustomerById(int id){
		Session session = AppUtil.openSession();
		Transaction tx = null;
		Customer cus = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "FROM Customer WHERE id = '" + id + "'";
			Query query = session.createQuery(hql);
			cus = (Customer) query.uniqueResult();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} 
		return cus;
	}

	public List<Customer> getListOfClients() {
		Session session = AppUtil.openSession();
		List<Customer> list = new ArrayList<Customer>();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			list = session.createQuery("from Customer").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return list;

	}
	public void update(Customer cus, Address address){
		Session session = AppUtil.openSession();
		try {
			Transaction tx = session.getTransaction();
			tx.begin();
			session.update(address);
			session.update(cus);
			tx.commit();
			System.out.println("Successfully added");
		} catch (Exception e) {
			System.out.println("Could not insert data.");
			e.printStackTrace();
		}

	}
	
	public void delete(Address address, Customer cus){
		Session session = AppUtil.openSession();

		try {
			Transaction tx = session.getTransaction();
			tx.begin();
			session.delete(address);
			session.delete(cus);
			tx.commit();
			System.out.println("Successfully deleted");
		} catch (Exception e) {
			System.out.println("Could not deleted data.");
			e.printStackTrace();
		} 
			
	
	}
}

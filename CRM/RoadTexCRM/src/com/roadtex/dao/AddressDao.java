package com.roadtex.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.roadtex.model.Address;
import com.roadtex.model.Customer;
import com.roadtex.util.AppUtil;

public class AddressDao {

	public AddressDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Address getAddressById(int id){
		Session session = AppUtil.openSession();
		Transaction tx = null;
		Address address = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "FROM Address WHERE addressID = '" + id + "'";
			Query query = session.createQuery(hql);
			address = (Address) query.uniqueResult();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} 
		return address;
	}

}

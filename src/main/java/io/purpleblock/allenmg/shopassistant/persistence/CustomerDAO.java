package io.purpleblock.allenmg.shopassistant.persistence;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import io.purpleblock.allenmg.shopassistant.model.Customer;

public class CustomerDAO {

	private final SessionFactory sessionFactory;

	@Inject
	public CustomerDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		session.close();
	}

	public List<Customer> getCustomers() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List result = session.createQuery("from Customer").list();
		session.getTransaction().commit();
		session.close();

		return result;
	}
}

package io.purpleblock.shopassistant.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import io.purpleblock.shopassistant.model.Customer;

public class CustomerDAO {

	private final EntityManagerFactory entityManagerFactory;

	@Inject
	public CustomerDAO(EntityManagerFactory factory) {
		this.entityManagerFactory = factory;
	}

	public void saveCustomer(Customer customer) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
		em.close();
	}

	public List<Customer> getCustomers() {
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Customer> result = em.createQuery("from Customer", Customer.class).getResultList();
		em.close();

		return result;
	}
}

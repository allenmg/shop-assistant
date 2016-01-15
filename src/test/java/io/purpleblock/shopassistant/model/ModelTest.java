/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2010, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package io.purpleblock.shopassistant.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import io.purpleblock.shopassistant.model.Customer;
import io.purpleblock.shopassistant.model.Vehicle;

public class ModelTest {
	private EntityManager em;

	@Before
	public void setUp() {
		em = Persistence.createEntityManagerFactory("shop_manager").createEntityManager();
		System.out.println("Built Factory:" + em);
	}

	@After
	public void tearDown() throws Exception {
		em.close();
	}

	@Test
	public void testVehicleMapping() {
		System.out.println("Selecting Vehicles");
		List<Vehicle> result = em.createQuery("from Vehicle", Vehicle.class).getResultList();
		System.out.println(result.size());
		for (Vehicle v : result) {
			System.out.println(v);
		}
	}
	
	@Test
	public void testCustomerMapping() {
		System.out.println("Selecting Customers");
		List<Customer> result = em.createQuery("from Customer", Customer.class).getResultList();
		System.out.println(result.size());
		for (Customer v : result) {
			System.out.println(v);
		}
	}
	
	@Test
	public void testCustomerVehicleMapping() {
		System.out.println("Selecting Customers with vehicles");
		List<Customer> result = em.createQuery("select c from Customer c join fetch c.vehicles", Customer.class).getResultList();
		System.out.println(result.size());
		for (Customer v : result) {
			System.out.println(v);
		}
	}
	
	@Ignore
	@Test
	public void testInsertCustomerVehicle() {
		System.out.println("Inserting Customer with vehicle");
		Customer c = em.createQuery("select c from Customer c where c.id = 0", Customer.class).getSingleResult();
		Vehicle v = em.createQuery("select v from Vehicle v where v.id = 0", Vehicle.class).getSingleResult();
		c.getVehicles().add(v);
		em.getTransaction().begin();
		em.persist(c);
		em.flush();
		em.getTransaction().commit();
		
	}
}

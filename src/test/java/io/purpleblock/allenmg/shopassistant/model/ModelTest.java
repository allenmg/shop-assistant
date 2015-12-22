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
package io.purpleblock.allenmg.shopassistant.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import junit.framework.TestCase;

/**
 * Illustrates the use of Hibernate native APIs.  The code here is unchanged from the {@code basic} example, the
 * only difference being the use of annotations to supply the metadata instead of Hibernate mapping files.
 *
 * @author Steve Ebersole
 */
public class ModelTest extends TestCase {
	private SessionFactory sessionFactory;

	@Override
	protected void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		System.out.println("Building factory");
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			System.out.println("Built a factory taht is :"+sessionFactory);
		}
		catch (Exception e) {
			e.printStackTrace();
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}

	@Override
	protected void tearDown() throws Exception {
		System.out.println("Breaking factory!!!");
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}
	
	public void testVehicleCustomerMapping(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Customer c = new Customer();
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(new Vehicle());
		vehicles.add(new Vehicle());
		c.setVehicles(vehicles);
		for(Vehicle v:vehicles){
			session.save(v);
		}
		session.save(c);
		session.getTransaction().commit();
		session.close();

		// now lets pull events from the database and list them
		session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery( "from Vehicle" ).list();
		for ( Vehicle event : (List<Vehicle>) result ) {
			System.out.println( "Vehicle");
		}
        session.getTransaction().commit();
        session.close();
	}
}

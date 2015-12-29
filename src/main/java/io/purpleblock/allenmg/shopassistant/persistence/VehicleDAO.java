package io.purpleblock.allenmg.shopassistant.persistence;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import io.purpleblock.allenmg.shopassistant.model.Vehicle;

public class VehicleDAO {

	private final SessionFactory sessionFactory;

	@Inject
	public VehicleDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveVehicle(Vehicle vehicle) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
	}

	public List<Vehicle> getVehicles() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List result = session.createQuery("from Vehicle").list();
		session.getTransaction().commit();
		session.close();

		return result;
	}
}

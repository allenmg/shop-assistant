package io.purpleblock.shopassistant.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import io.purpleblock.shopassistant.model.Vehicle;

public class VehicleDAO {

	private final EntityManagerFactory entityManagerFactory;

	@Inject
	public VehicleDAO(EntityManagerFactory factory) {
		this.entityManagerFactory = factory;
	}

	public void saveVehicle(Vehicle vehicle) {
		
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(vehicle);
		em.getTransaction().commit();
		em.close();
	}

	public List<Vehicle> getVehicles() {
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Vehicle> result = em.createQuery("from Vehicle", Vehicle.class).getResultList();
		em.close();

		return result;
	}
}

package io.purpleblock.allenmg.shopassistant.persistence;

import java.util.List;

import org.hibernate.Session;

import io.purpleblock.allenmg.shopassistant.model.Vehicle;

public class VehicleDAO {
	
	static public void saveVehicle(Vehicle vehicle){
		Session session = ShopSessionFactoryProvider.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
	}
	
	static public List<Vehicle> getVehicles(){
		Session session = ShopSessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        List result = session.createQuery( "from Vehicle" ).list();
        session.getTransaction().commit();
        session.close();
        
        return result;
	}
}

package io.purpleblock.allenmg.shopassistant.persistence;

import java.util.List;

import org.hibernate.Session;

import io.purpleblock.allenmg.shopassistant.model.Customer;

public class CustomerDAO {
	
	static public void saveCustomer(Customer customer){
		Session session = ShopSessionFactoryProvider.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		session.close();
	}
	
	static public List<Customer> getCustomers(){
		Session session = ShopSessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        List result = session.createQuery( "from Customer" ).list();
        session.getTransaction().commit();
        session.close();
        
        return result;
	}
}

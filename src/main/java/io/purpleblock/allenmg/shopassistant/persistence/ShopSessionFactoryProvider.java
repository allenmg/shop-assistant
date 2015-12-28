package io.purpleblock.allenmg.shopassistant.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ShopSessionFactoryProvider {
	
	private static SessionFactory sessionFactory;
	
	static public SessionFactory getSessionFactory() {
		if(sessionFactory != null){
			return sessionFactory;
		}
		System.out.println("Building factory");
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			System.out.println("Built hibernate session factory:"+sessionFactory);
		}
		catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy( registry );
		}
		return sessionFactory;
	}
	
	static public void closeFactory() {
		sessionFactory.close();
	}
}

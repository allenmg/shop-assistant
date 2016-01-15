package io.purpleblock.allenmg.shopassistant.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.inject.Provider;

public class EntityManagerFactoryProvider implements Provider<EntityManagerFactory>{
	
	private static EntityManagerFactory emf;
	
	static public EntityManagerFactory getFactory() {
		if(emf != null){
			return emf;
		}
		emf = Persistence.createEntityManagerFactory("shop_manager");
		return emf;
	}
	
	static public void closeFactory() {
		emf.close();
	}

	@Override
	public EntityManagerFactory get() {
		return getFactory();
	}
}

package io.purpleblock.allenmg.shopassistant.gui;

import javax.persistence.EntityManagerFactory;

import com.google.inject.AbstractModule;

import io.purpleblock.allenmg.shopassistant.persistence.CustomerDAO;
import io.purpleblock.allenmg.shopassistant.persistence.EntityManagerFactoryProvider;
import io.purpleblock.allenmg.shopassistant.persistence.VehicleDAO;

public class ApplicationModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(EntityManagerFactory.class).toProvider(EntityManagerFactoryProvider.class);
		
		bind(CustomerDAO.class);
		bind(VehicleDAO.class);
		
		
	}
	
}

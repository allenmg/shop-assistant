package io.purpleblock.shopassistant.gui;

import javax.persistence.EntityManagerFactory;

import com.google.inject.AbstractModule;

import io.purpleblock.shopassistant.persistence.CustomerDAO;
import io.purpleblock.shopassistant.persistence.EntityManagerFactoryProvider;
import io.purpleblock.shopassistant.persistence.VehicleDAO;

public class ApplicationModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(EntityManagerFactory.class).toProvider(EntityManagerFactoryProvider.class);
		
		bind(CustomerDAO.class);
		bind(VehicleDAO.class);
		
		
	}
	
}

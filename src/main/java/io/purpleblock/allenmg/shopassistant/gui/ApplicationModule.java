package io.purpleblock.allenmg.shopassistant.gui;

import com.google.inject.AbstractModule;

import io.purpleblock.allenmg.shopassistant.persistence.CustomerDAO;
import io.purpleblock.allenmg.shopassistant.persistence.ShopSessionFactoryProvider;
import io.purpleblock.allenmg.shopassistant.persistence.VehicleDAO;

public class ApplicationModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(ShopSessionFactoryProvider.class);
		
		bind(CustomerDAO.class);
		bind(VehicleDAO.class);
		
	}
	
}

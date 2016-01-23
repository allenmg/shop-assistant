package io.purpleblock.shopassistant.gui.vehicle;

import javax.inject.Inject;

import io.purpleblock.shopassistant.model.Vehicle;
import io.purpleblock.shopassistant.persistence.VehicleDAO;
import javafx.stage.Stage;

public class VehicleController  extends AbstractVehicleController {
	
	private final VehicleDAO vehicleDao;
	
	@Inject
	public VehicleController(VehicleDAO vehicleDao) {
		this.vehicleDao = vehicleDao;
	}
	
	public void initialize() {
		setVehicle(new Vehicle());
	}
	
	public void save() {
		System.out.println("SAVING...");
		vehicleDao.saveVehicle(vehicle);
		System.out.println("SAVED!");
		
		Stage window = (Stage) plateField.getScene().getWindow();
		window.close();
	}
}

package io.purpleblock.allenmg.shopassistant.gui.vehicle;

import java.math.BigInteger;

import javax.inject.Inject;

import io.purpleblock.allenmg.shopassistant.model.Vehicle;
import io.purpleblock.allenmg.shopassistant.persistence.VehicleDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VehicleController {
	
	private final VehicleDAO vehicleDao;
	
	@FXML TextField plateField;
	@FXML TextField yearField;
	@FXML TextField makeField;
	@FXML TextField modelField;
	@FXML TextField vinNumberField;
	
	@Inject
	public VehicleController(VehicleDAO vehicleDao) {
		this.vehicleDao = vehicleDao;
	}
	
	public void save() {
		System.out.println("SAVING...");
		Vehicle vehicle = new Vehicle();
		vehicle.setMake(makeField.getText());
		vehicle.setModel(modelField.getText());
		vehicle.setYear(new BigInteger(yearField.getText()));
		vehicle.setPlate(plateField.getText());
		vehicle.setVin(vinNumberField.getText());
		vehicleDao.saveVehicle(vehicle);
		System.out.println("SAVED!");
		
		Stage window = (Stage) plateField.getScene().getWindow();
		window.close();
	}
}

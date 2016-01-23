package io.purpleblock.shopassistant.gui.vehicle;

import io.purpleblock.shopassistant.model.Vehicle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.util.converter.BigIntegerStringConverter;

public abstract class AbstractVehicleController {
	@FXML TextField plateField;
	@FXML TextField yearField;
	@FXML TextField makeField;
	@FXML TextField modelField;
	@FXML TextField vinNumberField;
	
	protected Vehicle vehicle;
	
	public void setVehicle(Vehicle vehicle){
		this.vehicle = vehicle;
		bindVehicle();
	}
	
	private void bindVehicle() {
		plateField.textProperty().bindBidirectional(vehicle.plateProperty());
		yearField.textProperty().bindBidirectional(vehicle.yearProperty(), new BigIntegerStringConverter());
		makeField.textProperty().bindBidirectional(vehicle.makeProperty());
		modelField.textProperty().bindBidirectional(vehicle.modelProperty());
		vinNumberField.textProperty().bindBidirectional(vehicle.vinProperty());
	}
}

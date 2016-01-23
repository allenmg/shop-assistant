package io.purpleblock.shopassistant.gui.workorder;

import javax.inject.Inject;

import io.purpleblock.shopassistant.gui.customer.AbstractCustomerController;
import io.purpleblock.shopassistant.gui.vehicle.AbstractVehicleController;
import io.purpleblock.shopassistant.model.Customer;
import io.purpleblock.shopassistant.model.Vehicle;
import io.purpleblock.shopassistant.persistence.CustomerDAO;
import io.purpleblock.shopassistant.persistence.VehicleDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class WorkOrderController {
	@FXML TextField workOrderText;
	@FXML TextField purchaseOrderText;
	
	@FXML AbstractCustomerController customerController;
	@FXML AbstractVehicleController vehicleController;
	
	private final CustomerDAO customerDAO;
	private final VehicleDAO vehicleDAO;
	
	@Inject
	public WorkOrderController(CustomerDAO customerDAO, VehicleDAO vehicleDAO) {
		this.customerDAO = customerDAO;
		this.vehicleDAO = vehicleDAO;
	}
	
	public void save() {
		
	}
	
	public void setCustomer(Customer customer){
		customerController.setCustomer(customer);
	}
	
	public void setVehicle(Vehicle vehicle){
		vehicleController.setVehicle(vehicle);
	}
}

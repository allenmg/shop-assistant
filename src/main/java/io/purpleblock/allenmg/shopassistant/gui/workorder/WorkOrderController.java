package io.purpleblock.allenmg.shopassistant.gui.workorder;

import javax.inject.Inject;

import io.purpleblock.allenmg.shopassistant.persistence.CustomerDAO;
import io.purpleblock.allenmg.shopassistant.persistence.VehicleDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class WorkOrderController {
	@FXML TextField workOrderText;
	@FXML TextField purchaseOrderText;
	
	private final CustomerDAO customerDAO;
	private final VehicleDAO vehicleDAO;
	
	@Inject
	public WorkOrderController(CustomerDAO customerDAO, VehicleDAO vehicleDAO) {
		this.customerDAO = customerDAO;
		this.vehicleDAO = vehicleDAO;
	}
	
	public void save() {
		
	}
}

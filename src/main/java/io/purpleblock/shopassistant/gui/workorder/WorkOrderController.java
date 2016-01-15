package io.purpleblock.shopassistant.gui.workorder;

import javax.inject.Inject;

import io.purpleblock.shopassistant.gui.customer.AbstractCustomerController;
import io.purpleblock.shopassistant.model.Customer;
import io.purpleblock.shopassistant.persistence.CustomerDAO;
import io.purpleblock.shopassistant.persistence.VehicleDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class WorkOrderController {
	@FXML TextField workOrderText;
	@FXML TextField purchaseOrderText;
	
	@FXML AbstractCustomerController customerAbstractController;
	
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
		customerAbstractController.setCustomer(customer);
	}
}

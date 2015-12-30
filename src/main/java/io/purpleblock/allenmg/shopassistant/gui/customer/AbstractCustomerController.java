package io.purpleblock.allenmg.shopassistant.gui.customer;

import io.purpleblock.allenmg.shopassistant.model.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AbstractCustomerController {
	
	@FXML TextField firstNameField;
	@FXML TextField lastNameField;
	
	private Customer customer;
	
	public void setCustomer(Customer customer){
		this.customer = customer;
		bindCustomer();
	}
	
	private void bindCustomer() {
		firstNameField.textProperty().bindBidirectional(customer.firstNameProperty());
		lastNameField.textProperty().bindBidirectional(customer.lastNameProperty());
	}
}

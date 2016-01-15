package io.purpleblock.shopassistant.gui.customer;

import io.purpleblock.shopassistant.model.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AbstractCustomerController {
	
	@FXML TextField firstNameField;
	@FXML TextField lastNameField;
	
	protected Customer customer;
	
	public void setCustomer(Customer customer){
		this.customer = customer;
		bindCustomer();
	}
	
	private void bindCustomer() {
		firstNameField.textProperty().bindBidirectional(customer.firstNameProperty());
		lastNameField.textProperty().bindBidirectional(customer.lastNameProperty());
	}
}

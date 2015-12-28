package io.purpleblock.allenmg.shopassistant.gui.customer;

import io.purpleblock.allenmg.shopassistant.model.Customer;
import io.purpleblock.allenmg.shopassistant.persistence.CustomerDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerController {
	
	@FXML TextField firstNameField;
	@FXML TextField lastNameField;
	
	public void saveCustomer(ActionEvent event) {
		System.out.println("SAVING...");
		Customer customer = new Customer();
		customer.setFirstName(firstNameField.getText());
		customer.setLastName(lastNameField.getText());
		CustomerDAO.saveCustomer(customer);
		System.out.println("SAVED!");
		
		Stage window = (Stage) lastNameField.getScene().getWindow();
		window.close();
	}
	
}

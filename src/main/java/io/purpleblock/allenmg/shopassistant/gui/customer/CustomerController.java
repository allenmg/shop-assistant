package io.purpleblock.allenmg.shopassistant.gui.customer;

import javax.inject.Inject;

import io.purpleblock.allenmg.shopassistant.model.Customer;
import io.purpleblock.allenmg.shopassistant.persistence.CustomerDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerController {
	
	private final CustomerDAO customerDao;
	
	@FXML TextField firstNameField;
	@FXML TextField lastNameField;
	
	@Inject
	public CustomerController(CustomerDAO customerDao) {
		this.customerDao = customerDao;
	}
	
	public void saveCustomer(ActionEvent event) {
		System.out.println("SAVING...");
		Customer customer = new Customer();
		customer.setFirstName(firstNameField.getText());
		customer.setLastName(lastNameField.getText());
		customerDao.saveCustomer(customer);
		System.out.println("SAVED!");
		
		Stage window = (Stage) lastNameField.getScene().getWindow();
		window.close();
	}
	
}

package io.purpleblock.allenmg.shopassistant.gui.customer;

import javax.inject.Inject;

import io.purpleblock.allenmg.shopassistant.model.Customer;
import io.purpleblock.allenmg.shopassistant.persistence.CustomerDAO;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class CustomerController extends AbstractCustomerController {
	
	private final CustomerDAO customerDao;
	
	@Inject
	public CustomerController(CustomerDAO customerDao) {
		this.customerDao = customerDao;
	}
	
	public void initialize() {
		setCustomer(new Customer());
	}
	
	public void saveCustomer(ActionEvent event) {
		System.out.println("SAVING...");
		customerDao.saveCustomer(customer);
		System.out.println("SAVED!");
		
		Stage window = (Stage) lastNameField.getScene().getWindow();
		window.close();
	}
	
}

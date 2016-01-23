package io.purpleblock.shopassistant.gui;

import java.io.IOException;

import javax.inject.Inject;

import io.purpleblock.shopassistant.gui.customer.CustomerController;
import io.purpleblock.shopassistant.gui.vehicle.VehicleController;
import io.purpleblock.shopassistant.gui.workorder.WorkOrderController;
import io.purpleblock.shopassistant.model.Customer;
import io.purpleblock.shopassistant.model.Vehicle;
import io.purpleblock.shopassistant.persistence.CustomerDAO;
import io.purpleblock.shopassistant.persistence.VehicleDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ApplicationController {
	
	private final VehicleDAO vehicleDao;
	private final CustomerDAO customerDao;
	
	@FXML TableView<Vehicle> vehicleTable;
	@FXML TableView<Customer> customerTable;
	@FXML TabPane tableTabPane;
	
	@Inject
	public ApplicationController(VehicleDAO vehicleDao, CustomerDAO customerDao) {
		this.vehicleDao = vehicleDao;
		this.customerDao = customerDao;
	}
	
	public void populateCustomerTable() {
		customerTable.getItems().clear();
		customerTable.getItems().addAll(customerDao.getCustomers());
	}
	
	public void populateVehicleTable() {
		vehicleTable.getItems().clear();
		vehicleTable.getItems().addAll(vehicleDao.getVehicles());
	}
	
	public void initialize() {
		VehicleTableFactory.initVehicleTableGeneralized(vehicleTable);
		populateVehicleTable();
		
		CustomerTableFactory.initCustomerTableGeneralized(customerTable);
		populateCustomerTable();
		
	}
	
	public void addCustomer(ActionEvent event) throws IOException {
		Stage stage = new Stage();
	    Parent root = GuiceFXMLLoader.load(
	        CustomerController.class.getResource("customer.fxml"));
	    stage.setScene(new Scene(root));
	    stage.setTitle("Add Customer");
	    stage.initModality(Modality.WINDOW_MODAL);
	    stage.initOwner(
	        ((Node)event.getSource()).getScene().getWindow() );
	    
	    stage.setOnHiding(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				populateCustomerTable();
			}
		});
	    stage.show();
	}
	
	public void addVehicle(ActionEvent event) throws IOException {
		Stage stage = new Stage();
	    Parent root = GuiceFXMLLoader.load(
	        VehicleController.class.getResource("vehicle.fxml"));
	    stage.setScene(new Scene(root));
	    stage.setTitle("Add Vehicle");
	    stage.initModality(Modality.WINDOW_MODAL);
	    stage.initOwner(
	        ((Node)event.getSource()).getScene().getWindow() );
	    
	    stage.setOnHiding(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				populateVehicleTable();
			}
		});
	    stage.show();
	}
	
	public void addWorkOrder(ActionEvent event) throws IOException {
		Stage stage = new Stage();
		GuiceFXMLLoader loader = new GuiceFXMLLoader(WorkOrderController.class.getResource("workorder.fxml"));
	    Parent root = loader.load();
	    loader.getFXMLLoader().<WorkOrderController>getController().setCustomer(customerDao.getCustomers().get(0));
	    loader.getFXMLLoader().<WorkOrderController>getController().setVehicle(vehicleDao.getVehicles().get(0));
	    stage.setScene(new Scene(root));
	    stage.setTitle("Work Order");
	    stage.initModality(Modality.WINDOW_MODAL);
	    stage.initOwner(
	        ((Node)event.getSource()).getScene().getWindow() );
	    stage.setOnHiding(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
			}
		});
	    stage.show();
	}
}

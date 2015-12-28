package io.purpleblock.allenmg.shopassistant.gui;

import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import io.purpleblock.allenmg.shopassistant.gui.customer.CustomerController;
import io.purpleblock.allenmg.shopassistant.gui.vehicle.VehicleController;
import io.purpleblock.allenmg.shopassistant.gui.workorder.WorkOrderController;
import io.purpleblock.allenmg.shopassistant.model.Customer;
import io.purpleblock.allenmg.shopassistant.model.Vehicle;
import io.purpleblock.allenmg.shopassistant.persistence.CustomerDAO;
import io.purpleblock.allenmg.shopassistant.persistence.VehicleDAO;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

public class ApplicationController {
	@FXML TableView<Vehicle> vehicleTable;
	@FXML TableView<Customer> customerTable;
	@FXML TabPane tableTabPane;
	
	public void initVehicleTable() {
		ObservableList<TableColumn<Vehicle, ?>> columns = vehicleTable.getColumns();
		
		TableColumn<Vehicle, Number> idCol =  new TableColumn<Vehicle, Number>("Id");
		idCol.setCellValueFactory(new Callback<CellDataFeatures<Vehicle, Number>, ObservableValue<Number>>() {
			public ObservableValue<Number> call(CellDataFeatures<Vehicle, Number> p) {
				return new SimpleLongProperty(p.getValue().getId());
			}
		});
		columns.add(idCol);
		
		TableColumn<Vehicle, String> makeCol =  new TableColumn<Vehicle, String>("Make");
		makeCol.setCellValueFactory(new Callback<CellDataFeatures<Vehicle, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Vehicle, String> p) {
				return new SimpleStringProperty(p.getValue().getMake());
			}
		});
		columns.add(makeCol);
		
		TableColumn<Vehicle, String> modelCol =  new TableColumn<Vehicle, String>("Model");
		modelCol.setCellValueFactory(new Callback<CellDataFeatures<Vehicle, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Vehicle, String> p) {
				return new SimpleStringProperty(p.getValue().getModel());
			}
		});
		columns.add(modelCol);
		
		TableColumn<Vehicle, String> yearCol =  new TableColumn<Vehicle, String>("Year");
		yearCol.setCellValueFactory(new Callback<CellDataFeatures<Vehicle, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Vehicle, String> p) {
				return new SimpleStringProperty(p.getValue().getYear().toString());
			}
		});
		columns.add(yearCol);
		
		TableColumn<Vehicle, String> plateCol =  new TableColumn<Vehicle, String>("Plate");
		plateCol.setCellValueFactory(new Callback<CellDataFeatures<Vehicle, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Vehicle, String> p) {
				return new SimpleStringProperty(p.getValue().getPlate());
			}
		});
		columns.add(plateCol);
		
		TableColumn<Vehicle, String> vinCol =  new TableColumn<Vehicle, String>("VIN #");
		vinCol.setCellValueFactory(new Callback<CellDataFeatures<Vehicle, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Vehicle, String> p) {
				return new SimpleStringProperty(p.getValue().getVin());
			}
		});
		columns.add(vinCol);
		
		TableColumn<Vehicle, String> tsCol =  new TableColumn<Vehicle, String>("Date Created");
		tsCol.setCellValueFactory(new Callback<CellDataFeatures<Vehicle, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Vehicle, String> p) {
				return new SimpleStringProperty(p.getValue().getTs().toString());
			}
		});
		columns.add(tsCol);

	}
	
	public void initCustomerTable() {
		ObservableList<TableColumn<Customer, ?>> columns = customerTable.getColumns();
		
		TableColumn<Customer, Number> idCol =  new TableColumn<Customer, Number>("Id");
		idCol.setCellValueFactory(new Callback<CellDataFeatures<Customer, Number>, ObservableValue<Number>>() {
			public ObservableValue<Number> call(CellDataFeatures<Customer, Number> p) {
				return new SimpleLongProperty(p.getValue().getId());
			}
		});
		columns.add(idCol);
		
		TableColumn<Customer, String> lastNameCol =  new TableColumn<Customer, String>("Last Name");
		lastNameCol.setCellValueFactory(new Callback<CellDataFeatures<Customer, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Customer, String> p) {
				return new SimpleStringProperty(p.getValue().getLastName());
			}
		});
		columns.add(lastNameCol);
		
		TableColumn<Customer, String> firstNameCol =  new TableColumn<Customer, String>("First Name");
		firstNameCol.setCellValueFactory(new Callback<CellDataFeatures<Customer, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Customer, String> p) {
				return new SimpleStringProperty(p.getValue().getFirstName());
			}
		});
		columns.add(firstNameCol);
		
	}
	
	public List<Vehicle> getVehicles() {
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		int id = 1;
		
		vehicles.add(buildVehicle(id++, "Saturn", "SL", 1996, LocalDate.of(2005, Month.JULY, 3)));
		vehicles.add(buildVehicle(id++, "Buick", "Park Avenue", 2003, LocalDate.of(2008, Month.MAY, 15)));
		vehicles.add(buildVehicle(id++, "Chevrolet", "Impala", 2006, LocalDate.of(2014, 11, 6)));
		vehicles.add(buildVehicle(id++, "Tesla", "Model S", 2015, LocalDate.of(2015, 8, 3)));
		
		return vehicles;
	}
	
	public void populateCustomerTable() {
		customerTable.getItems().clear();
		customerTable.getItems().addAll(CustomerDAO.getCustomers());
	}
	
	public void populateVehicleTable() {
		vehicleTable.getItems().clear();
		vehicleTable.getItems().addAll(VehicleDAO.getVehicles());
	}
	
	private Vehicle buildVehicle(int id, String make, String model, int year, LocalDate ts) {
		Vehicle v = new Vehicle();
		v.setId(Long.valueOf(id));
		v.setMake(make);
		v.setModel(model);
		v.setYear(BigInteger.valueOf(year));
		v.setTs(LocalDateTime.of(ts, LocalTime.of(0, 0)));
		return v;
	}
	
	public void initialize() {
		initVehicleTable();
		populateVehicleTable();
		
		initCustomerTable();
		populateCustomerTable();
		
	}
	
	public void addCustomer(ActionEvent event) throws IOException {
		Stage stage = new Stage();
	    Parent root = FXMLLoader.load(
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
	    Parent root = FXMLLoader.load(
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
	    Parent root = GuiceFXMLLoader.load(
	        WorkOrderController.class.getResource("workorder.fxml"));
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

package io.purpleblock.allenmg.shopassistant.gui;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import io.purpleblock.allenmg.shopassistant.model.Vehicle;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class ApplicationController {
	@FXML TableView<Vehicle> resultTable;
	
	public void initTable() {
		ObservableList<TableColumn<Vehicle, ?>> columns = resultTable.getColumns();
		
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
		
		TableColumn<Vehicle, String> tsCol =  new TableColumn<Vehicle, String>("Date Created");
		tsCol.setCellValueFactory(new Callback<CellDataFeatures<Vehicle, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Vehicle, String> p) {
				return new SimpleStringProperty(p.getValue().getTs().toString());
			}
		});
		columns.add(tsCol);

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
		initTable();
		resultTable.getItems().addAll(getVehicles());
	}
}

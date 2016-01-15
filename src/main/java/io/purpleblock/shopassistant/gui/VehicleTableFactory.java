package io.purpleblock.shopassistant.gui;

import java.math.BigInteger;
import java.time.LocalDateTime;

import io.purpleblock.shopassistant.model.Vehicle;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class VehicleTableFactory {
	public static void initVehicleTable(TableView<Vehicle> vehicleTable) {
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
				return new SimpleStringProperty(p.getValue().getCreatedTs().toString());
			}
		});
		columns.add(tsCol);

	}
	
	public static void initVehicleTableReflective(TableView<Vehicle> vehicleTable) {
		ObservableList<TableColumn<Vehicle, ?>> columns = vehicleTable.getColumns();
		
		TableColumn<Vehicle, Number> idCol =  new TableColumn<Vehicle, Number>("Id");
		idCol.setCellValueFactory(new PropertyValueFactory<Vehicle, Number>("id"));
		columns.add(idCol);
		
		TableColumn<Vehicle, String> makeCol =  new TableColumn<Vehicle, String>("Make");
		makeCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("make"));
		columns.add(makeCol);
		
		TableColumn<Vehicle, String> modelCol =  new TableColumn<Vehicle, String>("Model");
		modelCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("model"));
		columns.add(modelCol);
		
		TableColumn<Vehicle, BigInteger> yearCol =  new TableColumn<Vehicle, BigInteger>("Year");
		yearCol.setCellValueFactory(new PropertyValueFactory<Vehicle, BigInteger>("year"));
		columns.add(yearCol);
		
		TableColumn<Vehicle, String> plateCol =  new TableColumn<Vehicle, String>("Plate");
		plateCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("plate"));
		columns.add(plateCol);
		
		TableColumn<Vehicle, String> vinCol =  new TableColumn<Vehicle, String>("VIN #");
		vinCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("vin"));
		columns.add(vinCol);
		
		TableColumn<Vehicle, LocalDateTime> tsCol =  new TableColumn<Vehicle, LocalDateTime>("Date Created");
		tsCol.setCellValueFactory(new PropertyValueFactory<Vehicle, LocalDateTime>("ts"));
		columns.add(tsCol);
	}
	
	public static void initVehicleTableGeneralized(TableView<Vehicle> vehicleTable) {
		ObservableList<TableColumn<Vehicle, ?>> columns = vehicleTable.getColumns();
		
		columns.add(GeneralBeanTableColumnBuilder.makeColumn("Id", "id"));
		columns.add(GeneralBeanTableColumnBuilder.makeColumn("Make", "make"));
		columns.add(GeneralBeanTableColumnBuilder.makeColumn("Model", "model"));
		columns.add(GeneralBeanTableColumnBuilder.makeColumn("Year", "year"));
		columns.add(GeneralBeanTableColumnBuilder.makeColumn("Plate", "plate"));
		columns.add(GeneralBeanTableColumnBuilder.makeColumn("VIN #", "vin"));
		columns.add(GeneralBeanTableColumnBuilder.makeColumn("Date Created", "createdTs"));
		columns.add(GeneralBeanTableColumnBuilder.makeColumn("Date Updated", "updatedTs"));
	}
}

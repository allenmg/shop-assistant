package io.purpleblock.shopassistant.gui;

import io.purpleblock.shopassistant.model.Customer;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class CustomerTableFactory {
	public static void initCustomerTable(TableView<Customer> customerTable) {
		ObservableList<TableColumn<Customer, ?>> columns = customerTable.getColumns();
		
		TableColumn<Customer, Number> idCol =  new TableColumn<Customer, Number>("Id");
		idCol.setCellValueFactory(new Callback<CellDataFeatures<Customer, Number>, ObservableValue<Number>>() {
			public ObservableValue<Number> call(CellDataFeatures<Customer, Number> p) {
				return p.getValue().idProperty();
			}
		});
		columns.add(idCol);
		
		TableColumn<Customer, String> lastNameCol =  new TableColumn<Customer, String>("Last Name");
		lastNameCol.setCellValueFactory(new Callback<CellDataFeatures<Customer, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Customer, String> p) {
				return p.getValue().lastNameProperty();
			}
		});
		columns.add(lastNameCol);
		
		TableColumn<Customer, String> firstNameCol =  new TableColumn<Customer, String>("First Name");
		firstNameCol.setCellValueFactory(new Callback<CellDataFeatures<Customer, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Customer, String> p) {
				return p.getValue().firstNameProperty();
			}
		});
		columns.add(firstNameCol);
		
	}
	
	public static void initCustomerTableReflective(TableView<Customer> customerTable) {
		ObservableList<TableColumn<Customer, ?>> columns = customerTable.getColumns();
		
		TableColumn<Customer, Number> idCol =  new TableColumn<Customer, Number>("Id");
		idCol.setCellValueFactory(new PropertyValueFactory<Customer, Number>("id"));
		columns.add(idCol);
		
		TableColumn<Customer, String> lastNameCol =  new TableColumn<Customer, String>("Last Name");
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastName"));
		columns.add(lastNameCol);
		
		TableColumn<Customer, String> firstNameCol =  new TableColumn<Customer, String>("First Name");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("firstName"));
		columns.add(firstNameCol);
		
	}
	
	public static void initCustomerTableGeneralized(TableView<Customer> customerTable) {
		ObservableList<TableColumn<Customer, ?>> columns = customerTable.getColumns();
		
		columns.add(GeneralBeanTableColumnBuilder.makeColumn("Id", "id"));
		columns.add(GeneralBeanTableColumnBuilder.makeColumn("Last Name", "lastName"));
		columns.add(GeneralBeanTableColumnBuilder.makeColumn("First Name", "firstName"));
		columns.add(GeneralBeanTableColumnBuilder.makeColumn("Created Ts", "createdTs"));
		columns.add(GeneralBeanTableColumnBuilder.makeColumn("Updated Ts", "updatedTs"));
		
	}
}

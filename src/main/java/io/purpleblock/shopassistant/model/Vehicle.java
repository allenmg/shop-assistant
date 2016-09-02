package io.purpleblock.shopassistant.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

@Entity
@Table( name = "VEHICLE" )
public class Vehicle extends BaseEntity {
	
	
	private final SimpleStringProperty plate = new SimpleStringProperty();
	private final SimpleStringProperty vin = new SimpleStringProperty();
	private final SimpleStringProperty make = new SimpleStringProperty();
	private final SimpleStringProperty model = new SimpleStringProperty();
	private final SimpleObjectProperty<BigInteger> year = new SimpleObjectProperty<BigInteger>();
	//TODO this likley won't register modifications to elements in the list.  Should convert this to ObservableList
	private final SimpleObjectProperty<List<Customer>> customers = new SimpleObjectProperty<List<Customer>>();
	public SimpleStringProperty plateProperty() {
		return this.plate;
	}
	
	@Column(name="plate")
	public java.lang.String getPlate() {
		return this.plateProperty().get();
	}
	
	public void setPlate(final java.lang.String plate) {
		this.plateProperty().set(plate);
	}
	
	public SimpleStringProperty vinProperty() {
		return this.vin;
	}
	
	@Column(name="vin")
	public java.lang.String getVin() {
		return this.vinProperty().get();
	}
	
	public void setVin(final java.lang.String vin) {
		this.vinProperty().set(vin);
	}
	
	public SimpleStringProperty makeProperty() {
		return this.make;
	}
	
	@Column(name="make")
	public java.lang.String getMake() {
		return this.makeProperty().get();
	}
	
	public void setMake(final java.lang.String make) {
		this.makeProperty().set(make);
	}
	
	public SimpleStringProperty modelProperty() {
		return this.model;
	}
	
	@Column(name="model")
	public java.lang.String getModel() {
		return this.modelProperty().get();
	}
	
	public void setModel(final java.lang.String model) {
		this.modelProperty().set(model);
	}
	
	public SimpleObjectProperty<BigInteger> yearProperty() {
		return this.year;
	}
	
	@Column(name="year")
	public java.math.BigInteger getYear() {
		return this.yearProperty().get();
	}
	
	public void setYear(final java.math.BigInteger year) {
		this.yearProperty().set(year);
	}
	
	public SimpleObjectProperty<List<Customer>> customersProperty() {
		return this.customers;
	}
	
	@ManyToMany
	@JoinTable(name = "CUSTOMER_VEHICLE", 
		joinColumns = { @JoinColumn(name = "VEHICLE_ID", foreignKey=@ForeignKey(name="vehicle_fk"))}, 
		inverseJoinColumns = { @JoinColumn(name = "CUSTOMER_ID", foreignKey=@ForeignKey(name="customer_fk")) }, 
		foreignKey=@ForeignKey(name="vehicle_fk"), 
		inverseForeignKey=@ForeignKey(name="customer_fk")
	)
	public java.util.List<io.purpleblock.shopassistant.model.Customer> getCustomers() {
		return this.customersProperty().get();
	}
	
	public void setCustomers(final java.util.List<io.purpleblock.shopassistant.model.Customer> customers) {
		this.customersProperty().set(customers);
	}

}

package io.purpleblock.shopassistant.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name="CUSTOMER")
public class Customer extends BaseEntity {
	
	private final StringProperty lastName = new SimpleStringProperty();
	private final StringProperty firstName = new SimpleStringProperty();
	private final ObjectProperty<List<Vehicle>> vehicles = new SimpleObjectProperty<List<Vehicle>>();
	private final ObjectProperty<Address> address = new SimpleObjectProperty<Address>();
	
	public StringProperty lastNameProperty() {
		return this.lastName;
	}
	
	@Column(name="last_name")
	public java.lang.String getLastName() {
		return this.lastNameProperty().get();
	}
	
	public void setLastName(final java.lang.String lastName) {
		this.lastNameProperty().set(lastName);
	}
	
	public StringProperty firstNameProperty() {
		return this.firstName;
	}
	
	@Column(name="first_name")
	public java.lang.String getFirstName() {
		return this.firstNameProperty().get();
	}
	
	public void setFirstName(final java.lang.String firstName) {
		this.firstNameProperty().set(firstName);
	}
	
	public ObjectProperty<List<Vehicle>> vehiclesProperty() {
		return this.vehicles;
	}
	
	@ManyToMany
	@JoinTable(name = "CUSTOMER_VEHICLE", 
		joinColumns = { @JoinColumn(name = "CUSTOMER_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "VEHICLE_ID") },
		foreignKey=@ForeignKey(name="customer_fk"),
		inverseForeignKey=@ForeignKey(name="vehicle_fk")
	)
	public java.util.List<io.purpleblock.shopassistant.model.Vehicle> getVehicles() {
		return this.vehiclesProperty().get();
	}
	
	public void setVehicles(final java.util.List<io.purpleblock.shopassistant.model.Vehicle> vehicles) {
		this.vehiclesProperty().set(vehicles);
	}
	
	public ObjectProperty<Address> addressProperty() {
		return this.address;
	}
	
	@OneToOne
	@JoinColumn(name="address_id")
	public io.purpleblock.shopassistant.model.Address getAddress() {
		return this.addressProperty().get();
	}
	
	public void setAddress(final io.purpleblock.shopassistant.model.Address address) {
		this.addressProperty().set(address);
	}

}

package io.purpleblock.allenmg.shopassistant.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	private LongProperty id;
	private StringProperty lastName;
	private StringProperty firstName;
	private ObjectProperty<LocalDateTime> ts;
	private ObjectProperty<List<Vehicle>> vehicles;
	private ObjectProperty<Address> address;
	
	public Customer() {
		this.id = new SimpleLongProperty();
		this.lastName = new SimpleStringProperty();
		this.firstName = new SimpleStringProperty();
		this.ts = new SimpleObjectProperty<LocalDateTime>();
		this.vehicles = new SimpleObjectProperty<List<Vehicle>>();
		this.address = new SimpleObjectProperty<Address>();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public Long getId() {
		return id.get();
	}

	public void setId(Long id) {
		this.id.set(id);
	}

	@Column(name="last_name")
	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	@Column(name="first_name")
	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	@Column(name="ts", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false)
	public LocalDateTime getTs() {
		return ts.get();
	}

	public void setTs(LocalDateTime ts) {
		this.ts.set(ts);
	}

	@ManyToMany
	@JoinTable(name = "CUSTOMER_VEHICLE", 
		joinColumns = { @JoinColumn(name = "CUSTOMER_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "VEHICLE_ID") },
		foreignKey=@ForeignKey(name="customer_fk"),
		inverseForeignKey=@ForeignKey(name="vehicle_fk")
	)
	public List<Vehicle> getVehicles() {
		return vehicles.get();
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles.set(vehicles);
	}

	@OneToOne
	@JoinColumn(name="address_id")
	public Address getAddress() {
		return address.get();
	}

	public void setAddress(Address address) {
		this.address.set(address);
	}
	
	/* -- Properties ---------------------------------------------- */

	public LongProperty idProperty(){
		return id;
	}
	
	public StringProperty lastNameProperty(){
		return lastName;
	}
	
	public StringProperty firstNameProperty(){
		return firstName;
	}
	
	public ObjectProperty<LocalDateTime> tsProperty(){
		return ts;
	}
	
	public ObjectProperty<List<Vehicle>> vehiclesProperty(){
		return vehicles;
	}
	
	public ObjectProperty<Address> addressProperty(){
		return address;
	}
}

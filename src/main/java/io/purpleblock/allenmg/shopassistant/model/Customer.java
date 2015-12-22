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
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="ts", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false)
	private LocalDateTime ts;
	
	@ManyToMany
	@JoinTable(name = "CUSTOMER_VEHICLE", 
		joinColumns = { @JoinColumn(name = "CUSTOMER_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "VEHICLE_ID") },
		foreignKey=@ForeignKey(name="customer_fk"),
		inverseForeignKey=@ForeignKey(name="vehicle_fk")
	)
	private List<Vehicle> vehicles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDateTime getTs() {
		return ts;
	}

	public void setTs(LocalDateTime ts) {
		this.ts = ts;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
}

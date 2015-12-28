package io.purpleblock.allenmg.shopassistant.model;

import java.math.BigInteger;
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
@Table( name = "VEHICLE" )
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="plate")
	private String plate;

	@Column(name="vin")
	private String vin;
	
	@Column(name="make")
	private String make;
	
	@Column(name="model")
	private String model;
	
	@Column(name="year")
	private BigInteger year;
	
	@Column(name="ts", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false)
	private LocalDateTime ts;
	
	@ManyToMany
	@JoinTable(name = "CUSTOMER_VEHICLE", 
		joinColumns = { @JoinColumn(name = "VEHICLE_ID", foreignKey=@ForeignKey(name="vehicle_fk"))}, 
		inverseJoinColumns = { @JoinColumn(name = "CUSTOMER_ID", foreignKey=@ForeignKey(name="customer_fk")) }, 
		foreignKey=@ForeignKey(name="vehicle_fk"), 
		inverseForeignKey=@ForeignKey(name="customer_fk")
	)
	private List<Customer> customers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigInteger getYear() {
		return year;
	}

	public void setYear(BigInteger year) {
		this.year = year;
	}

	public LocalDateTime getTs() {
		return ts;
	}

	public void setTs(LocalDateTime ts) {
		this.ts = ts;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}

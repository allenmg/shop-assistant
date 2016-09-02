package io.purpleblock.shopassistant.model;

import java.time.LocalDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;

@MappedSuperclass
@Access(AccessType.PROPERTY)
public abstract class BaseEntity {
	private final SimpleLongProperty id = new SimpleLongProperty();
	private final SimpleObjectProperty<LocalDateTime> createdTs = new SimpleObjectProperty<LocalDateTime>();
	private final SimpleObjectProperty<LocalDateTime> updatedTs = new SimpleObjectProperty<LocalDateTime>();
	
	@PreUpdate
	@PrePersist
	public void updateTimestamp() {
		updatedTs.set(LocalDateTime.now());
	}
	
	public SimpleLongProperty idProperty() {
		return this.id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public long getId() {
		return this.idProperty().get();
	}

	public void setId(final long id) {
		this.idProperty().set(id);
	}

	public SimpleObjectProperty<LocalDateTime> createdTsProperty() {
		return this.createdTs;
	}

	@Column(name="created_ts", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, nullable=false)
	public java.time.LocalDateTime getCreatedTs() {
		return this.createdTsProperty().get();
	}

	public void setCreatedTs(final java.time.LocalDateTime createdTs) {
		this.createdTsProperty().set(createdTs);
	}

	public SimpleObjectProperty<LocalDateTime> updatedTsProperty() {
		return this.updatedTs;
	}

	@Column(name="updated_ts", columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP", insertable=true, nullable=false)
	public java.time.LocalDateTime getUpdatedTs() {
		return this.updatedTsProperty().get();
	}

	public void setUpdatedTs(final java.time.LocalDateTime updatedTs) {
		this.updatedTsProperty().set(updatedTs);
	}
	
}

package com.aegis.AegisDeviceManagement.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

@CreationTimestamp
@Column ( updatable = false )
private LocalDateTime createdAt;

@UpdateTimestamp
private LocalDateTime updatedAt;

@Column ( nullable = false )
private boolean deleted = false;

@Column ( nullable = false )
private String createdBy;

public void softDelete ( ) {
	this.deleted = true;
}
}

package com.aegis.AegisDeviceManagement.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarqueConfig extends BaseEntity implements Serializable {

private static final long serialVersionUID = 67973292120249808L;

@Id
@GeneratedValue ( strategy = GenerationType.AUTO )
private UUID id;

@Column ( nullable = false )
private String name;

private String endpointUrl;

private String authMethod;

@Column ( columnDefinition = "TEXT" )
private String authCredentials;

private LocalDateTime lastConnectionAttempt;

private String connectionStatus;

@Override
public boolean equals ( Object obj ) {
	if ( this == obj ) return true;
	if ( ! ( obj instanceof MarqueConfig other ) ) return false;
	return Objects.equals ( id , other.id );
}

@Override
public int hashCode ( ) {
	return Objects.hash ( id );
}

@Override
public String toString ( ) {
	return "MarqueConfig{" +
			       "id=" + id +
			       ", name='" + name + '\'' +
			       ", endpointUrl='" + endpointUrl + '\'' +
			       ", authMethod='" + authMethod + '\'' +
			       ", lastConnectionAttempt=" + lastConnectionAttempt +
			       ", connectionStatus='" + connectionStatus + '\'' +
			       ", deleted=" + isDeleted ( ) +
			       ", createdAt=" + getCreatedAt ( ) +
			       ", updatedAt=" + getUpdatedAt ( ) +
			       ", createdBy=" + getCreatedBy ( ) +
			       '}';
}
}

package com.aegis.AegisDeviceManagement.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marque extends BaseEntity implements Serializable {

private static final long serialVersionUID = 71047262891862601L;

@Id
@GeneratedValue ( strategy = GenerationType.AUTO )
private UUID id;

@Column ( nullable = false )
private String name;

private String description;

@Column ( columnDefinition = "TEXT" )
private String logo;

@OneToMany ( mappedBy = "marque", cascade = CascadeType.ALL, orphanRemoval = true )
private List < Device > devices = new ArrayList <> ( );

@Override
public boolean equals ( Object o ) {
	if ( this == o ) return true;
	if ( ! ( o instanceof Marque marque ) ) return false;
	return Objects.equals ( id , marque.id ) &&
			       Objects.equals ( name , marque.name ) &&
			       Objects.equals ( description , marque.description ) &&
			       Objects.equals ( logo , marque.logo );
}

@Override
public int hashCode ( ) {
	return Objects.hash ( id , name , description , logo );
}

@Override
public String toString ( ) {
	return "Marque{" +
			       "id=" + id +
			       ", name='" + name + '\'' +
			       ", description='" + description + '\'' +
			       ", logo='" + logo + '\'' +
			       ", createdAt=" + getCreatedAt ( ) +
			       ", updatedAt=" + getUpdatedAt ( ) +
			       ", deleted=" + isDeleted ( ) +
			       ", createdBy=" + getCreatedBy ( ) +
			       ", devicesCount=" + ( devices != null ? devices.size ( ) : 0 ) +
			       '}';
}
}

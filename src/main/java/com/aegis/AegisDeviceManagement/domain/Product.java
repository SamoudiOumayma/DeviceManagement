package com.aegis.AegisDeviceManagement.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product extends BaseEntity implements Serializable {

private static final long serialVersionUID = 66702894630098485L;

@Id
@GeneratedValue ( strategy = GenerationType.AUTO )
private UUID id;

@Column ( nullable = false )
private String name;

private UUID originalId;

@ElementCollection
@CollectionTable ( name = "product_data", joinColumns = @JoinColumn ( name = "product_id" ) )
@MapKeyColumn ( name = "key" )
@Column ( name = "value" )
private Map < String, String > data;

@Override
public boolean equals ( Object obj ) {
	if ( this == obj ) return true;
	if ( ! ( obj instanceof Product other ) ) return false;
	return Objects.equals ( id , other.id ) &&
			       Objects.equals ( name , other.name ) &&
			       Objects.equals ( originalId , other.originalId );
}

@Override
public int hashCode ( ) {
	return Objects.hash ( id , name , originalId );
}

@Override
public String toString ( ) {
	return "Product{" +
			       "id=" + id +
			       ", name='" + name + '\'' +
			       ", originalId=" + originalId +
			       ", createdAt=" + getCreatedAt ( ) +
			       ", updatedAt=" + getUpdatedAt ( ) +
			       ", deleted=" + isDeleted ( ) +
			       ", createdBy=" + getCreatedBy ( ) +
			       ", dataSize=" + ( data != null ? data.size ( ) : 0 ) +
			       '}';
}
}

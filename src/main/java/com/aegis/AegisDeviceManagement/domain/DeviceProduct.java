package com.aegis.AegisDeviceManagement.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceProduct extends BaseEntity implements Serializable {

private static final long serialVersionUID = 42045662657537826L;

@EmbeddedId
private DPId id;

@ManyToOne
@MapsId ( "deviceId" )
@JoinColumn ( name = "device_id", nullable = false )
private Device device;

@ManyToOne
@MapsId ( "productId" )
@JoinColumn ( name = "product_id", nullable = false )
private Product product;

@Override
public boolean equals ( Object o ) {
	if ( this == o ) return true;
	if ( ! ( o instanceof DeviceProduct that ) ) return false;
	return Objects.equals ( id , that.id ) &&
			       Objects.equals ( device , that.device ) &&
			       Objects.equals ( product , that.product );
}

@Override
public int hashCode ( ) {
	return Objects.hash ( id , device , product );
}

@Override
public String toString ( ) {
	return "DeviceProduct{" +
			       "id=" + id +
			       ", device=" + ( device != null ? device.getId ( ) : "null" ) +
			       ", product=" + ( product != null ? product.getId ( ) : "null" ) +
			       ", createdAt=" + getCreatedAt ( ) +
			       ", updatedAt=" + getUpdatedAt ( ) +
			       ", deleted=" + isDeleted ( ) +
			       ", createdBy=" + getCreatedBy ( ) +
			       '}';
}
}

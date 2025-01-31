package com.aegis.AegisDeviceManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface IBaseRepository < E, ID extends Serializable > extends JpaRepository < E, ID > {

	@Query ( "UPDATE #{#entityName} e SET e.deleted = true, e.updatedAt = cast(current_timestamp AS java.time.Instant) WHERE e.id = :id" )
    void softDelete ( @Param ( "id" ) ID id );

    @Query ( "SELECT e FROM #{#entityName} e WHERE e.deleted = false" )
    List < E > findAllActive ( );

	@Query ( "SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM #{#entityName} e WHERE e.id = :id AND e.deleted = true" )
    boolean isDeleted ( @Param ( "id" ) ID id );
}

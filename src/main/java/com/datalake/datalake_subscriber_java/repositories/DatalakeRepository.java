package com.datalake.datalake_subscriber_java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.datalake.datalake_subscriber_java.entities.DatalakeEntity;

public interface DatalakeRepository extends JpaRepository<DatalakeEntity, Long> {

    @Query("SELECT COUNT(d) > 0 FROM DatalakeEntity d WHERE d.order_id = :order_id")
    boolean existsByOrder_id(@Param("order_id") String order_id);

}

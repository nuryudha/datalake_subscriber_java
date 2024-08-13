package com.datalake.datalake_subscriber_java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datalake.datalake_subscriber_java.entities.DatalakeEntity;

public interface DatalakeRepository extends JpaRepository<DatalakeEntity, Long> {

    boolean existsByOrderId(String orderId);

}

package com.datalake.datalake_subscriber_java.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "STG_DATALAKE2")
@Data
// @AllArgsConstructor
@NoArgsConstructor
public class DatalakeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String order_id;
    private String debitur_area_branch_desc;
    private Long jumlah_debitur;
    private String external_sales_no;
    private String internal_sales_head_name;

}

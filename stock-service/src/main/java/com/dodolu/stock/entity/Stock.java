package com.dodolu.stock.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Saint
 */
@Entity
@Table(name = "stock_tbl")
@DynamicUpdate
@DynamicInsert
@Data
public class Stock {

    @Id
    private Long id;
    private String commodityCode;
    private Integer count;
}

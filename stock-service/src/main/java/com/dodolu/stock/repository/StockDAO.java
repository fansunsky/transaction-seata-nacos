package com.dodolu.stock.repository;

import com.dodolu.stock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fanhaoyu
 */
public interface StockDAO extends JpaRepository<Stock, String> {

    Stock findByCommodityCode(String commodityCode);

}

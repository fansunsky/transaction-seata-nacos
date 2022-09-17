package com.dodolu.order.repository;

import com.dodolu.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fanhaoyu
 */
public interface OrderDAO extends JpaRepository<Order, Long> {

}

package com.dodolu.order.service;

import com.dodolu.order.entity.Order;
import com.dodolu.order.feign.AccountFeignClient;
import com.dodolu.order.repository.OrderDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author fanhaoyu
 */
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class OrderService {

    private final AccountFeignClient accountFeignClient;
    private final OrderDAO orderDAO;

    @Transactional
    public void create(String userId, String commodityCode, Integer count) {

        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(orderMoney);

        orderDAO.save(order);
        accountFeignClient.debit(userId, orderMoney);

    }

}

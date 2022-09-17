package com.dodolu.trade.service;

import com.dodolu.trade.feign.OrderFeignClient;
import com.dodolu.trade.feign.StockFeignClient;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Saint
 */
@Service
@RequiredArgsConstructor
public class TradeService {

    private final StockFeignClient stockFeignClient;
    private final OrderFeignClient orderFeignClient;

    /**
     * 减库存，下订单
     *
     * @param userId
     * @param commodityCode
     * @param orderCount
     */
    @GlobalTransactional
    public void purchase(String userId, String commodityCode, int orderCount) {
        stockFeignClient.deduct(commodityCode, orderCount);

        orderFeignClient.create(userId, commodityCode, orderCount);
    }

    /**
     * 减库存，下订单（有异常）
     *
     * @param userId
     * @param commodityCode
     * @param orderCount
     */
    @GlobalTransactional
    public void failToPurchase(String userId, String commodityCode, int orderCount) {
        stockFeignClient.deduct(commodityCode, orderCount);
        orderFeignClient.create(userId, commodityCode, orderCount);
        throw new RuntimeException("Error!");
    }
}

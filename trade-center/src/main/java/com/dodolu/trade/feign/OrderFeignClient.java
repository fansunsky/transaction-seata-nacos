package com.dodolu.trade.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author fanhaoyu
 */
@FeignClient(name = "order-service", url = "127.0.0.1:9021")
public interface OrderFeignClient {

    @GetMapping("/create")
    void create(@RequestParam("userId") String userId, @RequestParam("commodityCode") String commodityCode,
                @RequestParam("count") Integer count);

}

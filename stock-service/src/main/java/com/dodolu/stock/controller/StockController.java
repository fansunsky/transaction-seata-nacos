package com.dodolu.stock.controller;

import com.dodolu.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanhaoyu
 */
@RestController
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class StockController {

    private final StockService stockService;

    @GetMapping(path = "/deduct")
    public Boolean deduct(String commodityCode, Integer count) {
        stockService.deduct(commodityCode, count);
        return true;
    }
}

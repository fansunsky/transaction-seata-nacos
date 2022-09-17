package com.dodolu.stock.service;

import com.dodolu.stock.entity.Stock;
import com.dodolu.stock.repository.StockDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Saint
 */
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class StockService {

    private final StockDAO stockDAO;

    @Transactional
    public void deduct(String commodityCode, int count) {
        Stock stock = stockDAO.findByCommodityCode(commodityCode);
        stock.setCount(stock.getCount() - count);

        stockDAO.save(stock);
    }
}

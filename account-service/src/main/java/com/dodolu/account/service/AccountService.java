package com.dodolu.account.service;

import com.dodolu.account.entity.Account;
import com.dodolu.account.repository.AccountDAO;
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
public class AccountService {

    private final AccountDAO accountDAO;

    private static final String ERROR_USER_ID = "1002";

    @Transactional(rollbackFor = Exception.class)
    public void debit(String userId, BigDecimal num) {
        Account account = accountDAO.findByUserId(userId);
        account.setMoney(account.getMoney().subtract(num));
        accountDAO.save(account);

        if (ERROR_USER_ID.equals(userId)) {
            throw new RuntimeException("account branch exception");
        }
    }
}



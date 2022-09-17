package com.dodolu.account.repository;

import com.dodolu.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Saint
 */
public interface AccountDAO extends JpaRepository<Account, Long> {

    Account findByUserId(String userId);

}


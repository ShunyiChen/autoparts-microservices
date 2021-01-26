package com.shunyi.autoparts.seataaccount.service;

import java.math.BigDecimal;

/**
 * @author Shunyi Chen
 *
 * @create 2020-12-09 23:32
 */
public interface AccountService {

    void deduct(Long userId, BigDecimal money);
}

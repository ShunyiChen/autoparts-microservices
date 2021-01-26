package com.shunyi.autoparts.seataaccount.service.impl;

import com.shunyi.autoparts.seataaccount.dao.AccountDao;
import com.shunyi.autoparts.seataaccount.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author Shunyi Chen
 *
 * @create 2020-12-09 23:34
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void deduct(Long userId, BigDecimal money) {
        accountDao.deduct(userId, money);
        log.info("*******成功从账户扣款："+money+"元");
    }
}

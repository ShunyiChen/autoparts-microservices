package com.shunyi.autoparts.seataorder.service.impl;

import com.shunyi.autoparts.seataorder.dao.OrderDao;
import com.shunyi.autoparts.seataorder.entity.Order;
import com.shunyi.autoparts.seataorder.service.AccountService;
import com.shunyi.autoparts.seataorder.service.OrderService;
import com.shunyi.autoparts.seataorder.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Shunyi Chen
 *
 * @create 2020-12-09 23:34
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    public void create(Order order) {
        //*******新建订单
        orderDao.create(order);
        log.info("成功新建一个订单");
        //*******调用库存做扣减
        storageService.deduct(order.getProductId(), order.getCount());
        log.info("成功扣减库存数量");
        //*******调用账户做扣钱
        accountService.deduct(order.getUserId(), order.getMoney());
        log.info("成功扣减账户钱数");
        //*******修改订单状态， 从零到1
        orderDao.update(order.getUserId(), 0);
        log.info("成功修改订单状态为0");

        log.info("恭喜您已成功下单");
    }

}

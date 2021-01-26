package com.shunyi.autoparts.seataorder.service;

import com.shunyi.autoparts.seataorder.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author Shunyi Chen
 *
 * @create 2020-12-09 23:32
 */
@Service
public interface OrderService {

    void create(Order order);
}

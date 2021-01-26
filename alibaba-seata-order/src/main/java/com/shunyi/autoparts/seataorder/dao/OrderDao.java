package com.shunyi.autoparts.seataorder.dao;

import com.shunyi.autoparts.seataorder.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Shunyi Chen
 * @create 2020-12-09 22:46
 */
@Mapper
public interface OrderDao {

    void create(Order order);

    void update(@Param("userId") Long userId, @Param("status") Integer status);
}

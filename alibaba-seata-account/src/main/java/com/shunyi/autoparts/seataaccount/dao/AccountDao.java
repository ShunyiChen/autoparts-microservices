package com.shunyi.autoparts.seataaccount.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author Shunyi Chen
 *
 * @create 2020-12-09 22:46
 */
@Mapper
public interface AccountDao {

    void deduct(@Param("userId") Long userId, @Param("money") BigDecimal money);
}

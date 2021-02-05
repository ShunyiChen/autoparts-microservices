package com.shunyi.autoparts.seatastorage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Shunyi Chen
 *
 * @create 2020-12-09 22:46
 */
@Mapper
public interface StorageDao {

    void deduct(@Param("productId") Long productId, @Param("count") Integer count);
}

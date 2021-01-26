package com.shunyi.autoparts.seatastorage.dao;

import com.shunyi.autoparts.seatastorage.entity.Storage;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Shunyi Chen
 *
 * @create 2020-12-09 22:46
 */
@Mapper
public interface StorageDao {

    void deduct(Long productId, Integer count);
}

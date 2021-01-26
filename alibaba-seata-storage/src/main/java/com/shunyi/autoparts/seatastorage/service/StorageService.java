package com.shunyi.autoparts.seatastorage.service;

/**
 * @author Shunyi Chen
 *
 * @create 2020-12-09 23:32
 */
public interface StorageService {

    void deduct(Long productId, Integer count);
}

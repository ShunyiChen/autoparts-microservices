package com.shunyi.autoparts.seatastorage.service;

import org.springframework.stereotype.Service;

/**
 * @author Shunyi Chen
 *
 * @create 2020-12-09 23:32
 */
public interface StorageService {

    void deduct(Long productId, Integer count);
}

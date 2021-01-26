package com.shunyi.autoparts.seatastorage.service.impl;

import com.shunyi.autoparts.seatastorage.dao.StorageDao;
import com.shunyi.autoparts.seatastorage.service.StorageService;
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
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void deduct(Long productId, Integer count) {
        storageDao.deduct(productId, count);
        log.info("********成功扣减库存数："+count);
    }
}

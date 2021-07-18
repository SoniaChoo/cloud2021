package com.sonia.springcloud.service.impl;

import com.sonia.springcloud.dao.StorageDao;
import com.sonia.springcloud.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;
    private static final Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Override
    public void decrease(Long productId, Integer count) {
        logger.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId, count);
        logger.info("------->storage-service中扣减库存结束");
    }
}

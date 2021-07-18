package com.sonia.springcloud.service.impl;

import com.sonia.springcloud.dao.AccountDao;
import com.sonia.springcloud.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        logger.info("------->account-service中扣减账户余额开始");
        accountDao.decrease(userId,money);
        logger.info("------->account-service中扣减账户余额结束");
    }
}

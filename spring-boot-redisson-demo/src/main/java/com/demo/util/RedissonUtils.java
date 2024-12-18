package com.demo.util;

import lombok.RequiredArgsConstructor;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class RedissonUtils {

    @Resource
    private final RedissonClient redissonClient;

}


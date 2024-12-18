package com.demo;

import org.junit.jupiter.api.Test;
import org.redisson.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedissonTests {

    @Resource
    private RedissonClient redissonClient;

    @Test
    public void testBloomFilter() {
        RBloomFilter<String> bloomFilter = redissonClient.getBloomFilter("sample");

        bloomFilter.tryInit(55000000L, 0.03);

        bloomFilter.add("a");
        bloomFilter.add("b");

        System.out.println(bloomFilter.contains("b"));
        System.out.println(bloomFilter.contains("c"));

    }

    @Test
    public void testLock() throws InterruptedException {
        RLock lock = redissonClient.getLock("anyLock");

        //lock.lock(); //默认30s
        //lock.lock(10, TimeUnit.SECONDS);
        // 尝试加锁，最多等待100秒，上锁以后10秒自动解锁
        boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
        if (Boolean.TRUE.equals(res)) {
            try {
                System.out.println("hello world!");
            } finally {
                lock.unlock();
            }
        }
    }

}

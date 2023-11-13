package com.xiaoxu.partnermatchingbackend.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoxu.partnermatchingbackend.model.domain.User;
import com.xiaoxu.partnermatchingbackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 缓存预热任务
 */
@Component
@Slf4j
public class PreCacheJob {
    @Resource
    private UserService userService;


    @Resource
    private RedissonClient redissonClient;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    //重点用户
    private List<Long> mainUserList = Arrays.asList(1L);

    //每天执行，预热加载用户
    @Scheduled(cron = "0 0 0 * * *")
    public void doCacheRecommendUser() {
        RLock lock = redissonClient.getLock("yupao:precache:docache:lock");
        try {
            //只有一共线程能获取到锁
            if (lock.tryLock(0, -1, TimeUnit.MILLISECONDS)) {
                for (Long userId : mainUserList) {
                    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                    Page<User> userPage = userService.page(new Page<>(1, 20), queryWrapper);
                    String redisKey = String.format("yupao:user:recommend:%s", userId);
                    ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
                    //写缓存
                    try {
                        valueOperations.set(redisKey, userPage, 300000, TimeUnit.NANOSECONDS);
                    } catch (Exception e) {
                        log.error("redis set key error ", e);
                    }
                }

            }
        } catch (InterruptedException e) {
        log.error("doCacheRecommendUser error",e);
        } finally {
            //只能释放自己的锁
            if (lock.isHeldByCurrentThread())
                lock.unlock();
        }
    }
}

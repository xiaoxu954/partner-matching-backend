package com.xiaoxu.partnermatchingbackend;

import java.util.Date;

import com.xiaoxu.partnermatchingbackend.model.domain.User;
import jdk.nashorn.internal.ir.CallNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    //增
    @Test
    void testAdd() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("xiaoxuString", "dogxu");
        valueOperations.set("xiaoxuInt", 1);
        valueOperations.set("xiaoxuDouble", 2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("xiaoxu");
        valueOperations.set("xiaoxuUser", user);
    }

    //查
    @Test
    void testSearch() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object xiaoxuString = valueOperations.get("xiaoxuString");
        Assertions.assertTrue("dogxu".equals((String) xiaoxuString));

        Object xiaoxuInt = valueOperations.get("xiaoxuInt");

        Assertions.assertTrue((1 == (Integer) xiaoxuInt));

        Object xiaoxuDouble = valueOperations.get("xiaoxuDouble");
        Assertions.assertTrue((2.0 == (Double) xiaoxuDouble));

        Object xiaoxuUser = valueOperations.get("xiaoxuUser");
        System.out.println(xiaoxuUser);
    }

    //改
    @Test
    void testUpdate() {

    }

    //删
    @Test
    void testDelete() {

    }

}

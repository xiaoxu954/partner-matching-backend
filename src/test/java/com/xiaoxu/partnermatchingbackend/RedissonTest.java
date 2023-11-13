package com.xiaoxu.partnermatchingbackend;

import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class RedissonTest {

    @Resource
    private RedissonClient redissonClient;

    @Test
    void test() {
        //list
        List<String> list = new ArrayList<>();
        list.add("xiaoxu");

        System.out.println("list" + list.get(0));

        list.remove(0);

        //数据存在 redis内存中
        RList<String> rlist = redissonClient.getList("test-list" );
//        rlist.add("yupi");
        rlist.remove(0);
        System.out.println("rlist" + rlist.get(0));

        //map

        Map<String,Integer> map = new HashMap<>();
        map.put("xiaoxu",10);


        RMap<Object, Object> map1 = redissonClient.getMap("test-map");
        map1.put("xiaoxu",10);



        //set

        //stack

    }
}

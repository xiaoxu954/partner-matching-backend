package com.xiaoxu.partnermatchingbackend.once;

import com.xiaoxu.partnermatchingbackend.model.domain.User;
import com.xiaoxu.partnermatchingbackend.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class InsertUsers {

    @Resource
    private UserService userService;

    /**
     * 批量插入用户
     */
    public void doInsertUser() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<User> userList = new ArrayList<>();

        final int INSERTNUM = 1000;
        for (int i = 0; i < INSERTNUM; i++) {
            User user = new User();
            user.setUsername("假用户1");
            user.setUserAccount("fake");
            user.setAvatarUrl("https://nlp-eb.cdn.bcebos.com/static/eb/asset/robin.e9dc83e5.png");
            user.setGender(0);
            user.setUserPassword("b0dd3697a192885d7c055db46155b26a");
            user.setEmail("123456@qq.com");
            user.setProfile("");
            user.setUserStatus(0);
            user.setPhone("176050");
            user.setUserRole(0);
            user.setTags("[]");
            userList.add(user);
        }
        userService.saveBatch(userList, 100);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }

    /**
     * 多线程并发批量插入用户
     */
    public void doConcurrencyInsertUser() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERTNUM = 1000000;
        //分十组
        int batchSize = 5000;
        int j = 0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //注意线程安全
//            List<User> userList = Collections.synchronizedList(new ArrayList<>());
            List<User> userList = new ArrayList<>();
            while (true) {
                j++;
                User user = new User();
                user.setUsername("假用户1");
                user.setUserAccount("fake");
                user.setAvatarUrl("https://nlp-eb.cdn.bcebos.com/static/eb/asset/robin.e9dc83e5.png");
                user.setGender(0);
                user.setUserPassword("b0dd3697a192885d7c055db46155b26a");
                user.setEmail("123456@qq.com");
                user.setProfile("");
                user.setUserStatus(0);
                user.setPhone("176050");
                user.setUserRole(0);
                user.setTags("[]");
                userList.add(user);
                if (j % batchSize == 0) {
                    break;
                }
            }
            //异步执行任务
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("threadName:" + Thread.currentThread().getName());
                userService.saveBatch(userList, batchSize);
            });

            futureList.add(future);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();

        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }

    public static void main(String[] args) {
        new InsertUsers().doInsertUser();
    }
}

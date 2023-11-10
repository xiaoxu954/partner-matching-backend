package com.xiaoxu.partnermatchingbackend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoxu.partnermatchingbackend.model.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author xujihong
 * @description 针对表【user(用户表)】的数据库操作Service
 * @createDate 2023-11-05 16:31:03
 */
public interface UserService extends IService<User> {


    /**
     * 用户注册
     *
     * @param userAccount
     * @param userPassword
     * @param checkPassword
     * @return
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     *
     * @param userAccount
     * @param userPassword
     * @param request
     * @return
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);


    /**
     * 用户脱敏方法
     *
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    /**
     * 用户注销方法
     *
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);

    /**
     * 根据标签搜索用户方法
     *
     * @param tagNameList
     * @return
     */
    List<User> searchUsersByTags(List<String> tagNameList);

    /**
     * 用户信息修改
     *
     * @param user
     * @param loginuser
     * @return
     */
    int updateUser(User user, User loginuser);

    /**
     * 获取当前用户
     *
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 是否为管理员
     *
     * @param request
     * @return
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * 是否为管理员
     *
     * @param user
     * @return
     */
    boolean isAdmin(User user);
}

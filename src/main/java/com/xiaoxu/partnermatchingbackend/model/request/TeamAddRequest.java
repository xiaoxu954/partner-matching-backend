package com.xiaoxu.partnermatchingbackend.model.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 队伍添加请求体
 */
@Data
public class TeamAddRequest implements Serializable {

    private static final long serialVersionUID = -4101859946250812172L;
    /**
     * 队伍名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 最大人数
     */
    private Integer maxNum;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 用户id（队长 id）
     */
    private Long userId;

    /**
     * 0 - 公开，1 - 私有，2 - 加密
     */
    private Integer status;

    /**
     * 密码
     */
    private String password;


}
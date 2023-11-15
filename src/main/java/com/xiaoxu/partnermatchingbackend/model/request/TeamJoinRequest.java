package com.xiaoxu.partnermatchingbackend.model.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 队伍更新请求体
 */
@Data
public class TeamJoinRequest implements Serializable {

    private static final long serialVersionUID = -4101859946250812172L;
    /**
     * id
     */
    private Long teamId;


    /**
     * 密码
     */
    private String password;


}
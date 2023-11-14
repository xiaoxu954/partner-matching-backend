package com.xiaoxu.partnermatchingbackend.service;

import com.xiaoxu.partnermatchingbackend.model.domain.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoxu.partnermatchingbackend.model.domain.User;

/**
* @author xujihong
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2023-11-14 10:34:50
*/
public interface TeamService extends IService<Team> {

    /**
     * 创建队伍
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);

}

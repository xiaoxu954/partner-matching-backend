package com.xiaoxu.partnermatchingbackend.service;

import com.xiaoxu.partnermatchingbackend.model.domain.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoxu.partnermatchingbackend.model.domain.User;
import com.xiaoxu.partnermatchingbackend.model.dto.TeamQuery;
import com.xiaoxu.partnermatchingbackend.model.request.TeamJoinRequest;
import com.xiaoxu.partnermatchingbackend.model.request.TeamUpdateRequest;
import com.xiaoxu.partnermatchingbackend.model.vo.TeamUserVO;

import java.util.List;

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

    /**
     * 搜索队伍
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery,boolean isAdmin);

    /**
     * 更新队伍
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest,User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest,User loginUser);
}

package com.xiaoxu.partnermatchingbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoxu.partnermatchingbackend.model.domain.UserTeam;
import com.xiaoxu.partnermatchingbackend.service.UserTeamService;
import com.xiaoxu.partnermatchingbackend.mapper.UserTeamMapper;
import org.springframework.stereotype.Service;

/**
* @author xujihong
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2023-11-14 10:34:56
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}





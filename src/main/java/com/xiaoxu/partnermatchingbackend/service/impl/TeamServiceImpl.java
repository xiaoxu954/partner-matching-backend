package com.xiaoxu.partnermatchingbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoxu.partnermatchingbackend.model.domain.Team;
import com.xiaoxu.partnermatchingbackend.service.TeamService;
import com.xiaoxu.partnermatchingbackend.mapper.TeamMapper;
import org.springframework.stereotype.Service;

/**
* @author xujihong
* @description 针对表【team(队伍)】的数据库操作Service实现
* @createDate 2023-11-14 10:34:50
*/
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team>
    implements TeamService{

}





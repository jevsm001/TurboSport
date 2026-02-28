package com.cclinux.projects.meetsport.mapper;

import com.cclinux.framework.core.mapper.ProjectBaseMapper;
import com.cclinux.projects.meetsport.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("MeetSportUserMapper")
@Mapper
public interface UserMapper extends ProjectBaseMapper<UserModel> {
}

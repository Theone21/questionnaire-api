package com.questionnaire.dao.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.questionnaire.dao.entity.sys.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {

    List<Map<String, Object>> getRolesByUserId(@Param("userId") long userId);
}

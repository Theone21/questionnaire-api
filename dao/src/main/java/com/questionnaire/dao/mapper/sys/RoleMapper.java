package com.questionnaire.dao.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.questionnaire.dao.entity.sys.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper extends BaseMapper<Role> {


    void bindRoleAndFunction(@Param("roleId") Integer roleId, @Param("functionId") Integer functionId);

    void delAllRoleFunction(@Param("roleId") Integer roleId);
}

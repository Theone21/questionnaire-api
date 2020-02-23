package com.questionnaire.dao.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.questionnaire.dao.entity.sys.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleMapper extends BaseMapper<Role> {


    void bindRoleAndFunction(@Param("roleId") Integer roleId, @Param("functionId") Integer functionId);

    void delAllRoleFunction(@Param("roleId") Integer roleId);


    List<Map<String, Object>> getFunctionsByRoleId(@Param("roleId") Integer roleId);

    void setUserRoles(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    void delUserAllRoles(@Param("userId") Integer userId);

    List<Map<String, Object>> getUserRoles(@Param("userId") Integer userId);
}

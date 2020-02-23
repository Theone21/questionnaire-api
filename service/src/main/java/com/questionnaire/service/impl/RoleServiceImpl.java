package com.questionnaire.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.questionnaire.common.result.PageLimit;
import com.questionnaire.common.result.R;
import com.questionnaire.common.result.TableData;
import com.questionnaire.dao.entity.sys.Role;
import com.questionnaire.dao.mapper.sys.RoleMapper;
import com.questionnaire.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public TableData list(PageLimit pageLimit) {
        Page<Role> page = new Page<>(pageLimit.getCurrentPage(), pageLimit.getPageSize());
        Page<Role> result = roleMapper.selectPage(page, new QueryWrapper<Role>());
        return new TableData(result.getTotal(), result.getRecords());
    }

    @Override
    public R bindRoleAndFunction(List<Integer> functionIds, Integer roleId) {

        roleMapper.delAllRoleFunction(roleId);
        functionIds.forEach(functionId -> {
            roleMapper.bindRoleAndFunction(roleId, functionId);
        });
        return R.ok("绑定权限成功");
    }

    @Override
    public R getFunctionsByRoleId(Integer roleId) {
        List<Map<String, Object>> functions = roleMapper.getFunctionsByRoleId(roleId);
        return R.ok("查询到与该角色关联的权限", functions);
    }

    @Override
    public R getAllRoles() {
        List<Role> roles = roleMapper.selectList(null);
        return R.ok("获取到所有的角色", roles);
    }

    @Override
    public R setUserRoles(Integer userId, List<Integer> roles) {
        roleMapper.delUserAllRoles(userId);
        roles.forEach(roleId -> {
            roleMapper.setUserRoles(userId, roleId);
        });
        return R.ok("设置用户的角色成功");
    }

    @Override
    public R getUserRoes(Integer userId) {
        List<Map<String, Object>> roles = roleMapper.getUserRoles(userId);
        return R.ok("获取用户的角色成功", roles);
    }


}

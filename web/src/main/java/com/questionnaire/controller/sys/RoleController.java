package com.questionnaire.controller.sys;

import com.alibaba.fastjson.JSON;
import com.questionnaire.common.result.PageLimit;
import com.questionnaire.common.result.R;
import com.questionnaire.common.result.TableData;
import com.questionnaire.dao.entity.sys.Role;
import com.questionnaire.dao.entity.sys.User;
import com.questionnaire.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * 新增角色
     * @param role 角色
     * @return R 结果集
     */
    @PostMapping("/insertRole")
    public R insertRole(Role role){
        role.insertOrUpdate();
        return R.ok("新增角色成功");
    }

    /**
     * 分页查询角色
     * @param pageLimit 分页
     * @return TableData 结果集
     */
    @GetMapping("/roleList")
    public TableData list(PageLimit pageLimit){
        return roleService.list(pageLimit);
    }

    /**
     * 删除多个角色
     * @param roles
     * @return
     */
    @PostMapping("/delRole")
    public R delUser(@RequestBody List<Role> roles){
        roles.forEach(Role::deleteById);
        return R.ok("删除成功！");
    }

    /**
     * 为一个角色绑定多个权限
     * @param functionIds 权限ID
     * @param roleId 角色ID
     * @return
     * @author jinliujie
     */
    @PostMapping("/bindRoleAndFunction")
    public R bindRoleAndFunction(String functionIds, Integer roleId){
        List<Integer> ids=JSON.parseArray(functionIds, Integer.class);
        return roleService.bindRoleAndFunction(ids, roleId);
    }


    /**
     * 获取一个角色的权限
     * @author jinliujie
     */
    @GetMapping("/getFunctionsByRoleId")
    public R getFunctionsByRoleId(Integer roleId){
        return roleService.getFunctionsByRoleId(roleId);
    }

    /**
     * 获取所有的角色
     * @return
     */
    @GetMapping("/getAllRoles")
    public R getAllRoles(){
        return roleService.getAllRoles();
    }

    /**
     * 设置用户的角色
     * @return
     */
    @PostMapping("/setUserRoles")
    public R setUserRoles(Integer userId, String roles){
        List<Integer> roleIds = JSON.parseArray(roles, Integer.class);
        return roleService.setUserRoles(userId, roleIds);
    }

    /**
     * 获取一个用户的角色
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/getUserRoes")
    public R getUserRoes(Integer userId){
        return roleService.getUserRoes(userId);
    }





















}

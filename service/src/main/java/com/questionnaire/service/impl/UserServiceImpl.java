package com.questionnaire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.questionnaire.common.result.PageLimit;
import com.questionnaire.common.result.TableData;
import com.questionnaire.dao.entity.sys.User;
import com.questionnaire.dao.mapper.sys.UserMapper;
import com.questionnaire.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public boolean userExists(User user) {
        User findUser = userMapper.selectOne(new QueryWrapper<User>()
                .eq("USER_NAME", user.getUserName())
                .eq("USER_PASSWORD", user.getUserPassword()));
        return findUser != null;
    }

    @Override
    public TableData list(PageLimit pageLimit) {
        Page<User> page = new Page<>(pageLimit.getCurrentPage(), pageLimit.getPageSize());
        Page<User> result = userMapper.selectPage(page, new QueryWrapper<User>());

        return new TableData(result.getTotal(), result.getRecords());
    }

    @Override
    public User getByUsername(String username) {
        User findUser = userMapper.selectOne(new QueryWrapper<User>()
                .eq("USER_NAME", username));
        return findUser;
    }

    @Override
    public String[] getRoleByUser(User user) {
        List<Map<String, Object>> roleMaps = userMapper.getRolesByUserId(user.getUserId());
        return roleMaps.stream().map(m -> String.valueOf(m.get("roleName"))).collect(Collectors.toList()).toArray(new String[0]);
    }


}

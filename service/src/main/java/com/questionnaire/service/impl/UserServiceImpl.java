package com.questionnaire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.questionnaire.common.result.PageLimit;
import com.questionnaire.dao.entity.User;
import com.questionnaire.dao.mapper.UserMapper;
import com.questionnaire.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User findUserById() {
        return userMapper.selectById(2);
    }

    @Override
    public boolean userExists(User user) {
        User findUser = userMapper.selectOne(new QueryWrapper<User>()
                .eq("USER_NAME", user.getUserName())
                .eq("USER_PASSWORD", user.getUserPassword()));
        return findUser != null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public List<User> list(PageLimit pageLimit) {
        Page<User> page = new Page<>(0, 10);
        page.getTotal();
        return userMapper.selectPage(page, new QueryWrapper()).getRecords();
    }


}

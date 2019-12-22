package com.questionnaire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.questionnaire.dao.entity.User;
import com.questionnaire.dao.mapper.UserMapper;
import com.questionnaire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
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
}

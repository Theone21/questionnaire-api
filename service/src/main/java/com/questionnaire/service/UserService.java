package com.questionnaire.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.questionnaire.common.result.PageLimit;
import com.questionnaire.dao.entity.User;

import java.util.List;

public interface UserService {

    User findUserById();

    boolean userExists(User user);

    void addUser(User user);

    List<User> list(PageLimit pageLimit);
}

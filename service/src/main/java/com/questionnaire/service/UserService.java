package com.questionnaire.service;

import com.questionnaire.dao.entity.User;

public interface UserService {

    User findUserById();

    boolean userExists(User user);
}

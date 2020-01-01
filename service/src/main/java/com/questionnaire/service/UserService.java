package com.questionnaire.service;

import com.questionnaire.common.result.PageLimit;
import com.questionnaire.common.result.TableData;
import com.questionnaire.dao.entity.sys.User;

public interface UserService {

    User findUserById();

    boolean userExists(User user);

    void addUser(User user);

    TableData list(PageLimit pageLimit);
}

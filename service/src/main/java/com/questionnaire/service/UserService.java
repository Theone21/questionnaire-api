package com.questionnaire.service;

import com.questionnaire.common.result.PageLimit;
import com.questionnaire.common.result.TableData;
import com.questionnaire.dao.entity.sys.User;

public interface UserService {

    boolean userExists(User user);

    TableData list(PageLimit pageLimit);

    User getByUsername(String username);

    String[] getRoleByUser(User user);
}

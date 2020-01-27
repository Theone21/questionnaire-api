package com.questionnaire.service;

import com.questionnaire.common.result.PageLimit;
import com.questionnaire.common.result.R;
import com.questionnaire.common.result.TableData;

import java.util.List;

public interface RoleService {

    TableData list(PageLimit pageLimit);



    R bindRoleAndFunction(List<Integer> functionIds, Integer roleId);
}

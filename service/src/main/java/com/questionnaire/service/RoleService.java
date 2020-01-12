package com.questionnaire.service;

import com.questionnaire.common.result.PageLimit;
import com.questionnaire.common.result.TableData;

public interface RoleService {

    TableData list(PageLimit pageLimit);
}

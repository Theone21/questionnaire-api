package com.questionnaire.common.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 前端传递的分页bean
 */
public class PageLimit {

    private int pageSize;
    private int currentPage;
}

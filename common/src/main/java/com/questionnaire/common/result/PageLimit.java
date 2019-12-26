package com.questionnaire.common.result;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageLimit {

    private int pageSize;
    private int currentPage;
}

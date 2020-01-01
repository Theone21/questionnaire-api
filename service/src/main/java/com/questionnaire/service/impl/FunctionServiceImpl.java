package com.questionnaire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.questionnaire.common.result.PageLimit;
import com.questionnaire.common.result.TableData;
import com.questionnaire.dao.entity.sys.Function;
import com.questionnaire.dao.mapper.sys.FunctoinMapper;
import com.questionnaire.service.FunctionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Resource
    private FunctoinMapper functoinMapper;

    @Override
    public TableData getFunctionList(PageLimit pageLimit) {
        Page<Function> page = new Page<>(pageLimit.getCurrentPage(), pageLimit.getPageSize());
        Page<Function> result = functoinMapper.selectPage(page, new QueryWrapper<Function>());

        return new TableData(result.getTotal(), result.getRecords());
    }

}

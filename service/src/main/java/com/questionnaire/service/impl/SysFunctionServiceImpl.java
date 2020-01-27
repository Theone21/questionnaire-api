package com.questionnaire.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.questionnaire.common.result.R;
import com.questionnaire.dao.entity.sys.SysFunction;
import com.questionnaire.dao.mapper.sys.RoleMapper;
import com.questionnaire.dao.mapper.sys.SysFunctionMapper;
import com.questionnaire.service.ISysFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author jlj
 * @since 2020-01-12
 */
@Service
public class SysFunctionServiceImpl extends ServiceImpl<SysFunctionMapper, SysFunction> implements ISysFunctionService {


}

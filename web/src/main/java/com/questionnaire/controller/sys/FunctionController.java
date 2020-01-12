package com.questionnaire.controller.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.questionnaire.common.result.R;
import com.questionnaire.dao.entity.sys.SysFunction;
import com.questionnaire.service.ISysFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/function")
public class FunctionController {

    @Autowired
    private ISysFunctionService sysFunctionService;

    @GetMapping("/getAllFunctions")
    public R getAllFunctions(SysFunction sysFunction){
        QueryWrapper<SysFunction> queryWrapper = new QueryWrapper<>(sysFunction)
                .select("function_name as functionName", "function_id as functionId");
        List<Map<String, Object>> lists = sysFunctionService.listMaps(queryWrapper);
        return R.ok("查询到了功能模块", lists);
    }

    @PostMapping("/addFunction")
    public R addFunction(SysFunction sysFunction){
        sysFunctionService.save(sysFunction);
        return R.ok("新增功能权限成功");
    }


    private List<Map<String, Object>> getFunctionAndDetails(boolean containButton){
        QueryWrapper<SysFunction> queryWrapper = new QueryWrapper<SysFunction>()
                .eq("function_type", 0)
                .select("function_name as label", "function_id as value");
        List<Map<String, Object>> result = sysFunctionService.listMaps(queryWrapper);
        result.forEach(oneFunction -> {
            QueryWrapper<SysFunction> queryWrapper1 = new QueryWrapper<SysFunction>()
                    .eq("function_type", 1)
                    .eq("function_parent_id", oneFunction.get("value"))
                    .select("function_name as label", "function_id as value");
            List<Map<String, Object>> detailsFunction = sysFunctionService.listMaps(queryWrapper1);
            if (containButton){
                detailsFunction.forEach(oneFunction2 -> {
                    QueryWrapper<SysFunction> queryWrapper2 = new QueryWrapper<SysFunction>()
                            .eq("function_type", 2)
                            .eq("function_parent_id", oneFunction2.get("value"))
                            .select("function_name as label", "function_id as value");
                    oneFunction2.put("children", sysFunctionService.listMaps(queryWrapper2));
                });
            }
            oneFunction.put("children", detailsFunction);
        });
        return result;
    }

    /**
     * 获取一级和二级权限
     * @return
     */
    @GetMapping("/getFunctionAndDetail")
    public R getFunctionAndDetail(){
        return R.ok("查询到一级和二级权限", getFunctionAndDetails(false));
    }

    /**
     * 获取一级二级和三级权限
     * @return
     */
    @GetMapping("/getFunctionAndDetailAndButton")
    public R getFunctionAndDetailAndButton(){
        return R.ok("查询到一级和二级权限", getFunctionAndDetails(true));
    }
}

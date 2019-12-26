package com.questionnaire.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.questionnaire.common.result.PageLimit;
import com.questionnaire.common.result.R;
import com.questionnaire.dao.entity.User;
import com.questionnaire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys")
public class SysController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R login(User user){
        if (userService.userExists(user)){
            return R.ok("登录成功", null);
        } else {
            return R.error("登录失败", null);
        }
    }

    /**
     * 添加用户
     * @return
     */
    @GetMapping("/addUser")
    public R addUser(User user){
        user.insert();
        return R.ok("添加用户成功");
    }

    @GetMapping("/list")
    public List<User> list(PageLimit pageLimit){
        return userService.list(pageLimit);
    }
}

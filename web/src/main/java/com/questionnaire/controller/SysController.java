package com.questionnaire.controller;

import com.questionnaire.common.result.R;
import com.questionnaire.dao.entity.User;
import com.questionnaire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

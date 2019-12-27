package com.questionnaire.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.questionnaire.common.result.PageLimit;
import com.questionnaire.common.result.R;
import com.questionnaire.common.result.TableData;
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

    @GetMapping("/test")
    public R test(){
        return R.ok("testaaa");
    }

    @PostMapping("/login")
    public R login(User insertRecords){
        if (userService.userExists(insertRecords)){
            return R.ok("登录成功");
        } else {
            return R.error("登录失败");
        }
    }

    /**
     * 添加用户
     * @return
     */
    @PostMapping("/addUser")
    public R addUser(User user){
        user.insertOrUpdate();
        return R.ok("添加用户成功");
    }

    /**
     * 分页查询用户
     * @param pageLimit
     * @return
     */
    @GetMapping("/list")
    public TableData list(PageLimit pageLimit){
        return userService.list(pageLimit);
    }

    /**
     * 删除一个用户
     * @param users
     * @return
     */
    @PostMapping("/delUser")
    public R delUser(@RequestBody List<User> users){
        users.forEach(user -> user.deleteById());
        return R.ok("删除成功！");
    }
}

package com.questionnaire.controller.sys;

import com.questionnaire.common.result.PageLimit;
import com.questionnaire.common.result.R;
import com.questionnaire.common.result.TableData;
import com.questionnaire.dao.entity.sys.User;
import com.questionnaire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys")
public class SysController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/test")
    public R test(){
        return R.ok("成功");
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
        user.setUserPassword(new BCryptPasswordEncoder().encode(user.getUserPassword()));
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
     * 删除多个用户
     * @param users
     * @return
     */
    @PostMapping("/delUser")
    public R delUser(@RequestBody List<User> users){
        users.forEach(User::deleteById);
        return R.ok("删除成功！");
    }


}

package com.questionnaire.dao;

import com.questionnaire.dao.entity.sys.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DaoApplicationTests {

    @Test
    void contextLoads() {

        User user = new User();
        user.setUserName("李四");
        user.setUserPassword("lisi");
        Assert.assertTrue(user.insert());
        System.out.println(user.getUserId());
    }

}

package com.questionnaire.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class WebApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testPasswordEncoder() {
        System.out.println(new BCryptPasswordEncoder().encode("12"));
    }

}

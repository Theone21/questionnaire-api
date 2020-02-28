package com.questionnaire.config.security;

import com.questionnaire.dao.entity.sys.User;
import com.questionnaire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date 2019/4/8 11:26.
 */
@Component
public class JwtUserDetailServiceImpl implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    public JwtUserDetailServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 借助userService 服务层查询该用户是否存在
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username);
        String[] roles = userService.getRoleByUser(user);
        if (user != null){
            return new JwtUser(username, user.getUserPassword(), roles);
        }
        return null;
    }
}

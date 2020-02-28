package com.questionnaire.config.security;

import com.alibaba.fastjson.JSON;
import com.questionnaire.common.result.R;
import org.springframework.security.core.Authentication;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**登录成功
 * @author
 * @date 2019/3/12.
 */
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RsaSigner signer;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        String userJsonStr = JSON.toJSONString(authentication.getPrincipal());
        String token = JwtHelper.encode(userJsonStr, signer).getEncoded();
        //签发token
        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        result.put("roles", authentication.getAuthorities());
        response.getWriter().write(JSON.toJSONString(R.ok("登录成功", result)));
    }

    public void setSigner(RsaSigner signer) {
        this.signer = signer;
    }
}

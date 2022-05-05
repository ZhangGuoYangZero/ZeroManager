package com.manager.mag.interceptor;

/*
    访问拦截，不让XX访问

    1.判断cookie中是否存在用户信息（获取用户ID
    2. 判断数据库中是否有ID对应的值
* */


import com.manager.mag.dao.UserMapper;
import com.manager.mag.exceptions.NoLoginException;
import com.manager.mag.utils.CookieUtil;
import com.manager.mag.utils.LoginUserUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoLogininterceptor extends HandlerInterceptorAdapter {

    @Resource
    private UserMapper userMapper = null;

    @Override//尚未解决的BUG
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //通过cookie获取id
        // 获取cookie中的用户ID
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        // 判断用户ID是否为空，且数据库中存在该ID的用户记录
        if (null == userId || userMapper.selectByPrimaryKey(userId) == null) {
            throw new NoLoginException();
        }
        return true;
    }

}

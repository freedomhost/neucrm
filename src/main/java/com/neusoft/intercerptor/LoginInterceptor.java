package com.neusoft.intercerptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(Objects.nonNull(request.getSession().getAttribute("login"))){
            return true;
        }
        //重定向
        response.sendRedirect("/pages/login.html");
        return false;
    }
}

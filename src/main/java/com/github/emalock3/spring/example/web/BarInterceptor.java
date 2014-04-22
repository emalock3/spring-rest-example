package com.github.emalock3.spring.example.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class BarInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req, 
            HttpServletResponse res, Object handler) throws Exception {
        log.info("call BarInterceptor#preHandle handler:{}", 
                handler.toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, 
            Object handler, ModelAndView mav) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, 
            Object handler, Exception excptn) throws Exception {
    }

}

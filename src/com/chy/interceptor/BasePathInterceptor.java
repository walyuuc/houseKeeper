package com.chy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BasePathInterceptor extends HandlerInterceptorAdapter{

    private String charset = null;

    public void setCharset(String charset) {
        this.charset = charset;
    }
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	super.postHandle(request, response, handler, modelAndView);
    	if (modelAndView != null) {
    		modelAndView.getModelMap().put("base", request.getContextPath());
    		modelAndView.getModelMap().put("adminRes", request.getContextPath()+"/resources/admin");
    		modelAndView.getModelMap().put("frontRes", request.getContextPath()+"/resources/front");
    		modelAndView.getModelMap().put("siteName", "houseKeeper");
    	}
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        
    }
}

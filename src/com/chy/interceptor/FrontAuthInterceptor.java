package com.chy.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.chy.entity.User;
import com.chy.manager.UserMng;

public class FrontAuthInterceptor extends HandlerInterceptorAdapter {
	private List<String> excludeUrl = new ArrayList<String>();

	private PathMatcher pathMatcher = new AntPathMatcher();

	public void setExcludeUrl(List<String> excludeUrl) {
		this.excludeUrl = excludeUrl;
	}

	/**
	 * 进入controller之前执行
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String servletPath = request.getServletPath(); // 排除上传请求的Session检测
		for (String urlPattern : excludeUrl) {
			if (pathMatcher.match(urlPattern, servletPath)) {
				return true;
			}
		}
		Long userId=(Long) request.getSession().getAttribute("userId");
		if(userId!=null){
			return true;
		}else{
			response.sendRedirect(request.getContextPath()+"/login");
		}
		return false;
	}

	/**
	 * 将会在controller之后、返回页面之前执行
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		Long userId=(Long) request.getSession().getAttribute("userId");
		User user=userMng.getById(userId);
		modelAndView.getModel().put("user", user);
	}

	@Autowired
	private UserMng userMng;

}

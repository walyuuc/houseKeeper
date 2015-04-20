package com.chy.controller.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chy.entity.User;
import com.chy.manager.UserMng;

@Controller
public class LoginController {

	@RequestMapping(value="login",method=RequestMethod.GET)
	public String getPage(){
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(User user,ModelMap model,HttpServletRequest request){
		User sessionUser=(User) request.getSession().getAttribute("user");
		if(sessionUser==null){
			sessionUser=userMng.login(user);
			request.getSession().setAttribute("userId", sessionUser.getId());
		}
		if(sessionUser!=null){
			Byte type=sessionUser.getType();
			if(type==0){
				return "redirect:/employee/index";
			}else{
				return "redirect:/employer/index";
			}
		}else{
			model.put("res", "登录失败");
			return getPage();
		}
	}
	
	@RequestMapping(value="logout")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("userId");
		return "redirect:/login";
	}
	
	@Autowired
	private UserMng userMng;
}

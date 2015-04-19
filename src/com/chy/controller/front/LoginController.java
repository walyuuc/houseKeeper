package com.chy.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	public String login(User user,ModelMap model){
		boolean res=userMng.login(user);
		model.put("res", res);
		return "login";
	}
	
	@Autowired
	private UserMng userMng;
}

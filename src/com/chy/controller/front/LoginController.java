package com.chy.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chy.entity.User;

@Controller
public class LoginController {

	@RequestMapping(value="login.jspx")
	public String doLogin(User user){
		return "index";
	}
}

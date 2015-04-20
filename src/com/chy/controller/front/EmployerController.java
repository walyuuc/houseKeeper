package com.chy.controller.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chy.entity.User;

@Controller
public class EmployerController {

	@RequestMapping(value="employer/index")
	public String getEmployeePage(HttpServletRequest request,ModelMap model){
		User sessionUser=(User) request.getSession().getAttribute("user");
		model.put("user", sessionUser);
		return "employer/index";
	}
	
	
}

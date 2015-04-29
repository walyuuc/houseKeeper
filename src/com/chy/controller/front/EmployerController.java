package com.chy.controller.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chy.common.Page;
import com.chy.entity.User;
import com.chy.manager.RelativeMng;
import com.chy.manager.UserMng;

@Controller
public class EmployerController {

	@RequestMapping(value="employer/index")
	public String getEmployerPage(HttpServletRequest request,ModelMap model){
		return "employer/index";
	}
	
	@RequestMapping(value="employer/myinfo")
	public String myinfo(HttpServletRequest request,ModelMap model){
		return "employer/myinfo";
	}
	
	@RequestMapping(value="employer/updinfo",method=RequestMethod.GET)
	public String updinfo(HttpServletRequest request,ModelMap model){
		return "employer/updinfo";
	}
	
	@RequestMapping(value="employer/updinfo",method=RequestMethod.POST)
	public String update(User user,HttpServletRequest request,ModelMap model){
		User hasUser=userMng.getById(user.getId());
		hasUser.setRealname(user.getRealname());
		hasUser.setIdCard(user.getIdCard());
		hasUser.setPhone(user.getPhone());
		hasUser.setAddress(user.getAddress());
		hasUser=userMng.update(hasUser);
		return "redirect:/employer/myinfo";
	}
	
	@RequestMapping(value="employer/mykeeper",method=RequestMethod.GET)
	public String mykeeper(Page page,HttpServletRequest request,ModelMap model){
		Long userId=(Long) request.getSession().getAttribute("userId");
		page=relMng.getByEmployer(userId, page);
		model.put("page", page);
		return "employer/mykeeper";
	}
	
	@RequestMapping(value="employer/guanjia_list",method=RequestMethod.GET)
	public String guanjiaList(Page page,HttpServletRequest request,ModelMap model){
		page=userMng.getEmployee(page);
		model.put("page", page);
		return "employer/guanjia_list";
	}
	
	@RequestMapping(value="employer/guanjia/{id}",method=RequestMethod.GET)
	public String guanjia(@PathVariable Long id,HttpServletRequest request,ModelMap model){
		User user=userMng.getById(id);
		model.put("guanjia", user);
		return "employer/guanjia_detail";
	}
	
	@Autowired
	private UserMng userMng;
	@Autowired
	private RelativeMng relMng;
}

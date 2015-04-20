package com.chy.controller.front;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chy.common.Page;
import com.chy.entity.Relative;
import com.chy.entity.User;
import com.chy.manager.RelativeMng;
import com.chy.manager.UserMng;

@Controller
public class EmployeeController {

	@RequestMapping(value="employee/index")
	public String getEmployeePage(HttpServletRequest request,ModelMap model){
		return "employee/index";
	}
	
	@RequestMapping(value="employee/myinfo")
	public String myInfo(HttpServletRequest request,ModelMap model){
		return "employee/myinfo";
	}
	
	@RequestMapping(value="employee/updinfo",method=RequestMethod.GET)
	public String updInfo(HttpServletRequest request,ModelMap model){
		return "employee/updinfo";
	}
	
	@RequestMapping(value="employee/updinfo",method=RequestMethod.POST)
	public String update(User user,HttpServletRequest request,ModelMap model){
		User hasUser=userMng.getById(user.getId());
		hasUser.setRealname(user.getRealname());
		hasUser.setIdCard(user.getIdCard());
		hasUser.setPhone(user.getPhone());
		hasUser.setAddress(user.getAddress());
		hasUser=userMng.update(hasUser);
		return "redirect:/employee/myinfo";
	}
	
	@RequestMapping(value="employee/mygod",method=RequestMethod.GET)
	public String mygod(Page page,HttpServletRequest request,ModelMap model){
		Long userId=(Long) request.getSession().getAttribute("userId");
		List<Relative> list=relMng.getByEmployee(userId,page);
		List<User> userList=new ArrayList<User>();
		for(int i=0;i<list.size();i++){
			userList.add(userMng.getById(list.get(i).getEmployerId()));
		}
		model.put("userList", userList);
		return "employee/mygod";
	}
	
	@Autowired
	private UserMng userMng;
	@Autowired
	private RelativeMng relMng;
}
